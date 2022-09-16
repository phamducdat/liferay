package com.dogoo.common.files.manager.rest.internal.service;

import com.dogoo.common.file.helper.api.CommonFileHelper;
import com.dogoo.common.files.manager.rest.dto.v2_0.DGAttachedDocumentManager;
import com.dogoo.common.files.manager.rest.dto.v2_0.DGDocumentManager;
import com.dogoo.common.files.manager.rest.dto.v2_0.Metadata;
import com.dogoo.common.files.manager.rest.dto.v2_0.Module;
import com.dogoo.common.files.manager.rest.internal.mapper.DGDocumentManagerMapper;
import com.dogoo.common.files.manager.rest.internal.service.permission.FilePermissionService;
import com.dogoo.common.files.manager.rest.internal.util.DG_FileUtil;
import com.dogoo.common.files.manager.service.constant.SearchField;
import com.dogoo.common.files.manager.service.mapper.model.DocumentManagerMapperModel;
import com.dogoo.common.files.manager.service.model.DGDocumentManagerEntry;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileManagerEntry;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import com.dogoo.common.files.manager.service.service.DGDocumentManagerEntryLocalService;
import com.dogoo.common.files.manager.service.service.DGFileDepartmentPermissionEntryLocalService;
import com.dogoo.common.files.manager.service.service.DGFileManagerEntryLocalService;
import com.dogoo.common.files.manager.service.service.DGFileUserPermissionEntryLocalService;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.common.util.api.CommonUtil;
import com.dogoo.core.project.service.model.PhaseEntry;
import com.dogoo.core.project.service.model.ProjectEntry;
import com.dogoo.core.project.service.service.PhaseEntryLocalService;
import com.dogoo.core.project.service.service.ProjectEntryLocalService;
import com.dogoo.core.task.service.model.TaskEntry;
import com.dogoo.core.task.service.model.TaskEntryModel;
import com.dogoo.core.task.service.service.TaskEntryLocalService;
import com.dogoo.core.workflow.service.service.DoEntryLocalService;
import com.dogoo.employee.service.service.EmployeeCurrentPositionEntryLocalService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFolderService;
import com.liferay.document.library.opener.upload.UniqueFileEntryTitleProvider;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Component(immediate = true, service = DGDocumentManagerService.class)
public class DGDocumentManagerService {

    public static final String MODULE_FILE_PATH = "resource/Module.json";

    public Page<Module> getAllModules(String moduleId) throws JSONException {

        JSONObject modules = _fileResourceService.convertFileJsonToJsonObject(MODULE_FILE_PATH);

        List<Module> list = new ArrayList<>();

        if (Validator.isNull(moduleId)) {
            modules.keys().forEachRemaining(key -> {

                list.add(getModule(modules, key));
            });
        } else {
            list.add(getModule(modules, moduleId));
        }

        return Page.of(list);
    }

    public Module getModule(JSONObject modules, String key) {

        Module module = new Module();

        List<DGDocumentManager> apps = new ArrayList<>();

        if (modules.has(key)) {
            JSONArray appJsonArray = modules.getJSONArray(key);

            appJsonArray.forEach(appJsonObject -> {

                try {
                    apps.add(_mapper.mapFromDGDocumentManagerToDGDocumentManagerEntry(appJsonObject.toString()));
                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        module.setName(key);
        module.setDgDocumentManagers(apps.toArray(new DGDocumentManager[]{}));

        return module;
    }

    public Page<DGDocumentManager> getAllDGDocumentManagerAttachProject(
            String search,
            Long parentId,
            String pkCode,
            Pagination pagination,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel
    ) throws ParseException, SearchException {

        ProjectEntry projectEntry = projectEntryLocalService.
                fetchProjectEntryByExternalReferenceCode(CompanyThreadLocal.getCompanyId(), pkCode);

        List<TaskEntry> taskEntries = taskEntryLocalService.
                getTaskByProject(projectEntry.getCustomerId(), projectEntry.getProjectId());

        List<PhaseEntry> phaseEntries = phaseEntryLocalService.
                findByProjectId(projectEntry.getCustomerId(), projectEntry.getProjectId());

        String[] ercArray = new String[]{projectEntry.getExternalReferenceCode()};

        String[] taskERC = taskEntries.stream().map(TaskEntryModel::getExternalReferenceCode).collect(Collectors.toList()).toArray(new String[]{});

        String[] phaseERC = phaseEntries.stream().map(PhaseEntry::getExternalReferenceCode).collect(Collectors.toList()).toArray(new String[]{});

        ercArray = ArrayUtil.append(ercArray, ArrayUtil.append(taskERC, phaseERC));

        SearchContext searchContext = getSearchContext(pagination);

        BooleanQuery booleanQuery = buildQuery(projectEntry.getCustomerId(), search);

        BooleanFilter booleanFilter = booleanQuery.getPreBooleanFilter();

        TermFilter moduleIdTermFilter = new TermFilter(SearchField.MODULE_ID, "work");

        booleanFilter.add(moduleIdTermFilter, BooleanClauseOccur.MUST);

        TermFilter parentIdTermFilter = new TermFilter(SearchField.PARENT_ID, String.valueOf(GetterUtil.getLong(parentId)));

        if (GetterUtil.getLong(parentId) == 0) {

            BooleanFilter ercBooleanFilter = new BooleanFilter();

            Arrays.stream(ercArray).forEach(erc -> {

                TermFilter ercTermFilter = new TermFilter(SearchField.PK_CODE + "_String_sortable", erc);

                ercBooleanFilter.add(ercTermFilter, BooleanClauseOccur.SHOULD);
            });

            booleanFilter.add(ercBooleanFilter, BooleanClauseOccur.MUST);
        }

        booleanFilter.add(parentIdTermFilter, BooleanClauseOccur.MUST);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        Document[] documents = hits.getDocs();

        return Page.of(TransformUtil.transformToList(
                        documents,
                        document -> {
                            long id = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                            return _mapper.mapFromDGDocumentManagerToDGDocumentManagerEntryProject(
                                    _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(id),
                                    themeDisplay,
                                    userTokenModel
                            );
                        }
                ),
                pagination,
                hits.getLength());
    }

    public DGDocumentManager postDgDocumentManager(
            long customerId,
            long creatorId,
            Long departmentId,
            DGDocumentManager dto,
            ServiceContext serviceContext,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel) throws PortalException {

        if (dto.getType().equals(DGDocumentManager.Type.FOLDER)) {

            DLFolder dlFolder;

            if (dto.getCategory().equals(DGDocumentManager.Category.ATTACHED)) {

                dlFolder = getAttachFolder(
                        serviceContext.getScopeGroupId(),
                        customerId,
                        userTokenModel.getCustomer(),
                        dto.getMetadata().getModuleId(),
                        dto.getMetadata().getAppId(),
                        dto.getPkCode(),
                        dto.getParentId(),
                        serviceContext
                );
            } else {

                if (dto.getCategory().equals(DGDocumentManager.Category.COMPANY)) {
                    dlFolder = getCategoryElseFolder(
                            serviceContext.getScopeGroupId(),
                            customerId,
                            userTokenModel.getCustomer(),
                            "COMMON",
                            "FILE",
                            dto.getCategory().getValue(),
                            String.valueOf(departmentId),
                            dto.getParentId(),
                            serviceContext
                    );
                } else {
                    dlFolder = getCategoryElseFolder(
                            serviceContext.getScopeGroupId(),
                            customerId,
                            userTokenModel.getCustomer(),
                            "COMMON",
                            "FILE",
                            dto.getCategory().getValue(),
                            String.valueOf(creatorId),
                            dto.getParentId(),
                            serviceContext
                    );
                }
            }

            DLFolder newFolder = getFolder(serviceContext.getScopeGroupId(), dlFolder.getFolderId(), dto.getName(), serviceContext);

            dto.setFileId(newFolder.getFolderId());
        }


        return _mapper.mapFromDGDocumentManagerToDGDocumentManagerEntry(
                _dgDocumentManagerEntryLocalService.addDGDocumentManager(
                        customerId,
                        creatorId,
                        departmentId,
                        _mapper.mapFromFileManagerMapperModelToDGDocumentManager(dto),
                        serviceContext
                ),
                themeDisplay,
                userTokenModel
        );
    }

    public void deleteDgDocumentManagerById(long id,
                                            long customerId,
                                            long userId,
                                            ServiceContext serviceContext) throws PortalException {

        DGDocumentManagerEntry entry = _dgDocumentManagerEntryLocalService.
                fetchDGDocumentManagerEntry(id);

        if (Validator.isNotNull(entry)) {
            if (!entry.getCategory().equalsIgnoreCase(DGDocumentManager.Category.ATTACHED.getValue())) {
                if (dg_fileUtil.checkOwner(id, userId)) {
                    _filePermissionService.deleteFilePermission(customerId, id);
                    _dgDocumentManagerEntryLocalService.deleteDgDocumentManagerEntryById(entry);
                } else
                    _dgFileUserPermissionEntryLocalService.deleteFileUserPermission(
                            customerId,
                            userId,
                            id,
                            serviceContext);
            } else {
                _dgDocumentManagerEntryLocalService.deleteDgDocumentManagerEntryById(entry);
            }
        }


    }

    public void deleteDgDocumentManagerByPkCode(String pkCode) throws PortalException {

        _dgDocumentManagerEntryLocalService.deleteDgDocumentManagerEntriesByPkCode(pkCode);
    }

    public DGDocumentManager putDgDocumentManagerById(long userId,
                                                      long id,
                                                      DGDocumentManager dto,
                                                      ServiceContext serviceContext,
                                                      ThemeDisplay themeDisplay,
                                                      UserTokenModel userTokenModel
    ) throws PortalException {


        return _mapper.mapFromDGDocumentManagerToDGDocumentManagerEntry(
                _dgDocumentManagerEntryLocalService.updateDGDocumentManager(
                        userId,
                        id,
                        _mapper.mapFromFileManagerMapperModelToDGDocumentManager(dto),
                        serviceContext),
                themeDisplay,
                userTokenModel
        );
    }

    public DGDocumentManager getDgDocumentManager(long id, String category, String appId, ThemeDisplay themeDisplay, UserTokenModel userTokenModel) throws PortalException {

        if (id == 0) {
            if (Validator.isNull(category)) return null;
            return _mapper.getDGDocumentManager(userTokenModel.getCustomerId(), userTokenModel.getUserId(), category, appId);
        } else {

            DGDocumentManagerEntry entry = _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(id);

            if (Validator.isNotNull(entry)) {
                return _mapper.mapFromDGDocumentManagerToDGDocumentManagerEntry(
                        entry,
                        themeDisplay,
                        userTokenModel
                );
            }
        }

        return null;
    }

    public Page<DGDocumentManager> getDgDocumentManagerCompanyPersonalPages(
            long customerId,
            String search,
            long userId,
            Long parentId,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel,
            Pagination pagination
    ) throws SearchException, ParseException {

        SearchContext searchContext = getSearchContext(pagination);

        BooleanQuery booleanQuery = buildQueryCompanyPersonal(customerId, userId, GetterUtil.getLong(parentId), _commonUtil.vnNormalize(search));

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        Document[] documents = hits.getDocs();

        return Page.of(
                TransformUtil.transformToList(
                        documents,
                        document -> {
                            long id = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                            return _mapper.mapFromDGDocumentManagerToDGDocumentManagerEntry(
                                    _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(id),
                                    themeDisplay,
                                    userTokenModel
                            );
                        }
                ),
                pagination, hits.getLength()
        );
    }

    public Page<DGDocumentManager> getDgDocumentManagerCompanyPages(
            long customerId,
            String search,
            long userId,
            Long departmentId,
            Long parentId,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel,
            Pagination pagination
    ) throws SearchException, ParseException {

        SearchContext searchContext = getSearchContext(pagination);

        BooleanQuery booleanQuery = buildQueryCompany(customerId, userId, departmentId, GetterUtil.getLong(parentId), _commonUtil.vnNormalize(search));

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        Document[] documents = hits.getDocs();

        return Page.of(
                TransformUtil.transformToList(
                        documents,
                        document -> {
                            long id = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                            return _mapper.mapFromDGDocumentManagerToDGDocumentManagerEntry(
                                    _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(id),
                                    themeDisplay,
                                    userTokenModel
                            );
                        }
                ),
                pagination, hits.getLength()
        );
    }

    public Page<DGDocumentManager> getDgDocumentManagerAttachPersonalPages(
            long customerId,
            String app,
            String search,
            long userId,
            Long parentId,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel,
            Pagination pagination
    ) throws SearchException, ParseException {

        SearchContext searchContext = getSearchContext(pagination);

        searchContext.setCompanyId(CompanyThreadLocal.getCompanyId());

        Sort[] sorts = new Sort[]{new Sort(SearchField.TYPE + "_String_sortable", true)};

        searchContext.setSorts(sorts);

        BooleanQuery booleanQuery = buildQueryAttachPersonal(customerId, app, userId, GetterUtil.getLong(parentId), _commonUtil.vnNormalize(search));

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        Document[] documents = hits.getDocs();

        return Page.of(
                TransformUtil.transformToList(
                        documents,
                        document -> {
                            long id = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                            if (document.get(Field.ENTRY_CLASS_NAME).equalsIgnoreCase(DGDocumentManagerEntry.class.getName())) {

                                return _mapper.mapFromDGDocumentManagerToDGDocumentManagerEntry(
                                        _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(id),
                                        themeDisplay,
                                        userTokenModel
                                );
                            } else {
                                return _mapper.mapFromDGFileManagerToDGDocumentManagerEntry(
                                        _dgFileManagerEntryLocalService.fetchDGFileManagerEntry(id),
                                        themeDisplay,
                                        userTokenModel
                                );
                            }
                        }
                ),
                pagination, hits.getLength()
        );
    }

    public Page<DGDocumentManager> getDgDocumentManagerPersonalPages(
            long customerId,
            String search,
            long userId,
            long departmentId,
            Long parentId,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel,
            Pagination pagination
    ) throws SearchException, ParseException {

        SearchContext searchContext = getSearchContext(pagination);

        searchContext.setCompanyId(CompanyThreadLocal.getCompanyId());

        Sort[] sorts = new Sort[]{new Sort(SearchField.TYPE + "_String_sortable", true)};

        searchContext.setSorts(sorts);

        BooleanQuery booleanQuery = buildQueryPersonal(customerId, userId, departmentId, GetterUtil.getLong(parentId), _commonUtil.vnNormalize(search));

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        Document[] documents = hits.getDocs();

        return Page.of(
                TransformUtil.transformToList(
                        documents,
                        document -> {
                            long id = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                            return _mapper.mapFromDGDocumentManagerToDGDocumentManagerEntry(
                                    _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(id),
                                    themeDisplay,
                                    userTokenModel
                            );
                        }
                ),
                pagination, hits.getLength()
        );
    }

    public Page<DGDocumentManager> getDgDocumentManagerPages(
            long customerId,
            String appId,
            String search,
            String pkCode,
            Long parentId,
            ThemeDisplay themeDisplay,
            UserTokenModel userTokenModel,
            Pagination pagination
    ) throws SearchException, ParseException {

        SearchContext searchContext = getSearchContext(pagination);

        searchContext.setCompanyId(CompanyThreadLocal.getCompanyId());

        Sort[] sorts = new Sort[]{new Sort(SearchField.TYPE + "_String_sortable", true)};

        searchContext.setSorts(sorts);

        BooleanQuery booleanQuery = buildQueryAttach(customerId, pkCode, GetterUtil.getLong(parentId), _commonUtil.vnNormalize(search));

        booleanQuery.addRequiredTerm(SearchField.APP_ID, appId);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        Document[] documents = hits.getDocs();

        return Page.of(
                TransformUtil.transformToList(
                        documents,
                        document -> {
                            long id = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                            return _mapper.mapFromDGDocumentManagerToDGDocumentManagerEntry(
                                    _dgDocumentManagerEntryLocalService.fetchDGDocumentManagerEntry(id),
                                    themeDisplay,
                                    userTokenModel
                            );
                        }
                ),
                pagination, hits.getLength()
        );
    }

    private BooleanQuery buildQueryCompanyPersonal(long customerId, long userId, Long parentId, String search) throws ParseException {

        BooleanQuery booleanQuery = buildQuery(customerId, search);

        TermFilter creatorIdTermFilter = new TermFilter(SearchField.CREATOR_ID, String.valueOf(userId));

        TermFilter categoryTermFilter = new TermFilter(SearchField.CATEGORY, DGDocumentManager.Category.COMPANY.getValue());

        BooleanFilter booleanFilter = booleanQuery.getPreBooleanFilter();

        booleanFilter.add(creatorIdTermFilter, BooleanClauseOccur.MUST);

        booleanFilter.add(categoryTermFilter, BooleanClauseOccur.MUST);

        booleanQuery.addRequiredTerm(SearchField.PARENT_ID, String.valueOf(GetterUtil.getLong(parentId)));

        return booleanQuery;
    }

    private BooleanQuery buildQueryCompany(long customerId, long userId, long departmentId, Long parentId, String search) throws ParseException {

        BooleanQuery booleanQuery = buildQuery(customerId, search);

        TermFilter categoryTermFilter = new TermFilter(SearchField.CATEGORY, DGDocumentManager.Category.COMPANY.getValue());

        BooleanFilter booleanFilter = booleanQuery.getPreBooleanFilter();

        booleanFilter.add(categoryTermFilter, BooleanClauseOccur.MUST);

        TermFilter parentIdTermFilter = new TermFilter(SearchField.PARENT_ID, String.valueOf(GetterUtil.getLong(parentId)));

        booleanFilter.add(buildBooleanFilterForExpectObjects(customerId, userId), BooleanClauseOccur.MUST);

        if (GetterUtil.getLong(parentId) == 0) {
            BooleanFilter companyBooleanFilter = new BooleanFilter();

            BooleanFilter isPublicBooleanFilter = new BooleanFilter();

            TermFilter isPublicTermFilter = new TermFilter(SearchField.IS_PRIVATE, String.valueOf(GetterUtil.DEFAULT_BOOLEAN));

            isPublicBooleanFilter.add(parentIdTermFilter, BooleanClauseOccur.MUST);

            isPublicBooleanFilter.add(isPublicTermFilter, BooleanClauseOccur.MUST);

            companyBooleanFilter.add(isPublicBooleanFilter, BooleanClauseOccur.SHOULD);

            BooleanFilter isPrivateBooleanFilter = new BooleanFilter();

            TermFilter isPrivateTermFilter = new TermFilter(SearchField.IS_PRIVATE, String.valueOf(Boolean.TRUE));

            isPrivateBooleanFilter.add(isPrivateTermFilter, BooleanClauseOccur.MUST);

            BooleanFilter allowBooleanFilter = new BooleanFilter();

            TermFilter departmentIdTermFilter = new TermFilter(SearchField.DEPARTMENT_ID, String.valueOf(departmentId));

            allowBooleanFilter.add(departmentIdTermFilter, BooleanClauseOccur.SHOULD);

            sharedObjectsFilter(customerId, userId, departmentId, allowBooleanFilter);

            isPrivateBooleanFilter.add(allowBooleanFilter, BooleanClauseOccur.MUST);

            companyBooleanFilter.add(isPrivateBooleanFilter, BooleanClauseOccur.SHOULD);

            booleanFilter.add(companyBooleanFilter, BooleanClauseOccur.MUST);
        } else {
            booleanFilter.add(parentIdTermFilter, BooleanClauseOccur.MUST);
        }

        return booleanQuery;
    }

    private BooleanQuery buildQueryPersonal(long customerId, long userId, long departmentId, Long parentId, String search) throws ParseException {

        BooleanQuery booleanQuery = buildQuery(customerId, search);

        TermFilter creatorIdTermFilter = new TermFilter(SearchField.CREATOR_ID, String.valueOf(userId));

        BooleanFilter booleanFilter = booleanQuery.getPreBooleanFilter();

        TermFilter parentIdTermFilter = new TermFilter(SearchField.PARENT_ID, String.valueOf(GetterUtil.getLong(parentId)));

        booleanFilter.add(buildBooleanFilterForExpectObjects(customerId, userId), BooleanClauseOccur.MUST);

        if (GetterUtil.getLong(parentId) == 0) {

            BooleanFilter allowFileBooleanFilter = new BooleanFilter();

            BooleanFilter ownerBooleanFilter = new BooleanFilter();

            ownerBooleanFilter.add(creatorIdTermFilter, BooleanClauseOccur.MUST);

            ownerBooleanFilter.add(parentIdTermFilter, BooleanClauseOccur.MUST);

            allowFileBooleanFilter.add(ownerBooleanFilter, BooleanClauseOccur.SHOULD);

            sharedObjectsFilter(customerId, userId, departmentId, allowFileBooleanFilter);

            TermFilter categoryTermFilter = new TermFilter(SearchField.CATEGORY, DGDocumentManager.Category.PERSONAL.getValue());

            booleanFilter.add(allowFileBooleanFilter, BooleanClauseOccur.MUST);

            booleanFilter.add(categoryTermFilter, BooleanClauseOccur.MUST);
        } else {
            booleanFilter.add(parentIdTermFilter, BooleanClauseOccur.MUST);
        }

        return booleanQuery;
    }

    private void sharedObjectsFilter(long customerId, long userId, long departmentId, BooleanFilter booleanFilter) {

        List<DGFileUserPermissionEntry> dgFileUserPermissionEntries =
                _dgFileUserPermissionEntryLocalService.fetchByC_U_S(customerId, userId, "approved");

        dgFileUserPermissionEntries.forEach(dgFileUserPermissionEntry -> {
            TermFilter fileIdTermFilter = new TermFilter(Field.ENTRY_CLASS_PK, String.valueOf(dgFileUserPermissionEntry.getFileId()));

            booleanFilter.add(fileIdTermFilter, BooleanClauseOccur.SHOULD);
        });

        List<DGFileDepartmentPermissionEntry> dgFileDepartmentPermissionEntries =
                _dgFileDepartmentPermissionEntryLocalService.fetchByC_D(customerId, departmentId);

        dgFileDepartmentPermissionEntries.forEach(dgFileDepartmentPermissionEntry -> {
            TermFilter fileIdTermFilter = new TermFilter(Field.ENTRY_CLASS_PK, String.valueOf(dgFileDepartmentPermissionEntry.getFileId()));

            booleanFilter.add(fileIdTermFilter, BooleanClauseOccur.SHOULD);
        });
    }

    private BooleanQuery buildQueryAttachPersonal(long customerId, String app, Long userId, Long parentId, String search) throws ParseException {

        BooleanQuery booleanQuery = new BooleanQueryImpl();

        TermFilter customerIdTermFilter = new TermFilter(SearchField.CUSTOMER_ID, String.valueOf(customerId));

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(customerIdTermFilter, BooleanClauseOccur.MUST);

        if (Validator.isNotNull(search)) {
            BooleanQuery searchQuery = new BooleanQueryImpl();

            searchQuery.addTerm(Field.NAME,
                    StringUtil.quote(Validator.isNotNull(search) ?
                            search : StringPool.BLANK, StringPool.PERCENT), true);

            booleanQuery.add(searchQuery, BooleanClauseOccur.MUST);
        }

        TermFilter userIdTermFilter = new TermFilter(SearchField.CREATOR_ID, String.valueOf(userId));

        TermFilter appTermFilter = new TermFilter(SearchField.APP_ID, app.toLowerCase());

        booleanFilter.add(userIdTermFilter, BooleanClauseOccur.MUST);

        booleanFilter.add(appTermFilter, BooleanClauseOccur.MUST);

        BooleanFilter documentBooleanFilter = new BooleanFilter();

        TermFilter categoryTermFilter = new TermFilter(SearchField.CATEGORY, DGDocumentManager.Category.ATTACHED.getValue());

        BooleanFilter entryClassNameBooleanFilter = new BooleanFilter();

        TermFilter documentEntryClassNameTermFilter = new TermFilter(Field.ENTRY_CLASS_NAME, DGDocumentManagerEntry.class.getName());

        if (Objects.nonNull(parentId)) {
            TermFilter parentIdTermFilter = new TermFilter(SearchField.PARENT_ID, String.valueOf(GetterUtil.getLong(parentId)));

            documentBooleanFilter.add(parentIdTermFilter, BooleanClauseOccur.MUST);
        }

        documentBooleanFilter.add(categoryTermFilter, BooleanClauseOccur.MUST);
        documentBooleanFilter.add(documentEntryClassNameTermFilter, BooleanClauseOccur.MUST);

        if (Validator.isNull(parentId)) {
            BooleanFilter fileBooleanFilter = new BooleanFilter();

            TermFilter fileEntryClassNameTermFilter = new TermFilter(Field.ENTRY_CLASS_NAME, DGFileManagerEntry.class.getName());

            fileBooleanFilter.add(fileEntryClassNameTermFilter, BooleanClauseOccur.MUST);
            entryClassNameBooleanFilter.add(fileBooleanFilter, BooleanClauseOccur.SHOULD);
        }

        entryClassNameBooleanFilter.add(documentBooleanFilter, BooleanClauseOccur.SHOULD);

        booleanFilter.add(entryClassNameBooleanFilter, BooleanClauseOccur.MUST);

        booleanQuery.setPreBooleanFilter(booleanFilter);

        return booleanQuery;
    }

    private BooleanQuery buildQueryAttach(long customerId, String pkCode, Long parentId, String search) throws ParseException {

        BooleanQuery booleanQuery = buildQuery(customerId, search);

        TermFilter pkCodeTermFilter = new TermFilter(SearchField.PK_CODE + "_String_sortable", pkCode);

        TermFilter categoryTermFilter = new TermFilter(SearchField.CATEGORY, DGDocumentManager.Category.ATTACHED.getValue());

        BooleanFilter booleanFilter = booleanQuery.getPreBooleanFilter();

        booleanFilter.add(categoryTermFilter, BooleanClauseOccur.MUST);

        TermFilter parentIdTermFilter = new TermFilter(SearchField.PARENT_ID, String.valueOf(GetterUtil.getLong(parentId)));

        BooleanFilter supportBooleanFilter = new BooleanFilter();

        if (GetterUtil.getLong(parentId) == 0) {
            supportBooleanFilter.add(parentIdTermFilter, BooleanClauseOccur.MUST);
            supportBooleanFilter.add(pkCodeTermFilter, BooleanClauseOccur.MUST);

            booleanFilter.add(supportBooleanFilter, BooleanClauseOccur.MUST);
        } else {
            booleanFilter.add(parentIdTermFilter, BooleanClauseOccur.MUST);
        }

        return booleanQuery;
    }

    private BooleanQuery buildQuery(long customerId, String search) throws ParseException {

        BooleanQuery booleanQuery = new BooleanQueryImpl();

        TermFilter customerIdTermFilter = new TermFilter(SearchField.CUSTOMER_ID, String.valueOf(customerId));

        TermFilter entryClassNameTermFilter = new TermFilter(Field.ENTRY_CLASS_NAME, DGDocumentManagerEntry.class.getName());

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(customerIdTermFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(entryClassNameTermFilter, BooleanClauseOccur.MUST);

        if (Validator.isNotNull(search)) {
            BooleanQuery searchQuery = new BooleanQueryImpl();

            searchQuery.addTerm(Field.NAME,
                    StringUtil.quote(Validator.isNotNull(search) ?
                            search : StringPool.BLANK, StringPool.PERCENT), false);

            booleanQuery.add(searchQuery, BooleanClauseOccur.MUST);
        }

        booleanQuery.setPreBooleanFilter(booleanFilter);

        return booleanQuery;
    }

    public void putDGDocumentManagerPublic(long documentId,
                                           long userId,
                                           DGDocumentManager dgDocumentManager,
                                           ServiceContext serviceContext)
            throws SearchException {
        DGDocumentManagerEntry dgDocumentManagerEntry =
                _dgDocumentManagerEntryLocalService.updateDGDocumentManagerPublic(
                        userId,
                        documentId,
                        dgDocumentManager.getIsPrivate(),
                        serviceContext);

        if (!dgDocumentManagerEntry.getIsPrivate())
            _filePermissionService.deleteFilePermission(dgDocumentManagerEntry.getCustomerId(),
                    dgDocumentManagerEntry.getDocumentManagerId());

    }

    public void postDGDocumentManagerAttach(long groupId,
                                            long customerId,
                                            String customerName,
                                            DGAttachedDocumentManager dto,
                                            ServiceContext serviceContext) {
        if (Validator.isNotNull(dto.getPkCode())) {
            Metadata metadata = dto.getMetadata();

            Set<String> strings = new HashSet<>(Arrays.asList(dto.getPkCode()));

            strings.forEach(code -> {
                handleCloneDocument(groupId, customerId, customerName, metadata.getModuleId(), metadata.getAppId(), dto.getExternalReferenceCode(), code, 0L, serviceContext);
            });

            _dgDocumentManagerEntryLocalService.deleteDgDocumentManagerEntriesByPkCode(dto.getExternalReferenceCode());
        }
    }

    private void handleCloneDocument(long groupId,
                                     long customerId,
                                     String customerName,
                                     String moduleId,
                                     String appId,
                                     String externalReferenceCode,
                                     String pkCode,
                                     long parentId,
                                     ServiceContext serviceContext) {

        if (Validator.isNull(pkCode)) return;

        List<DGDocumentManagerEntry> entries = _dgDocumentManagerEntryLocalService.
                fetchDgDocumentManagerEntryByPkCodeAndParentId(externalReferenceCode, GetterUtil.getLong(parentId));

        DLFolder dlFolder;

        try {
            dlFolder = getAttachFolder(groupId, customerId, customerName, moduleId, appId, pkCode, parentId, serviceContext);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        for (DGDocumentManagerEntry entry : entries) {

            long fileId;

            if (entry.getType().equalsIgnoreCase(DGDocumentManager.Type.FILE.getValue())) {
                DLFileEntry dlFileEntry = dlFileEntryLocalService
                        .fetchDLFileEntry(entry.getFileId());

                FileEntry newDlFileEntry = null;
                try {

                    String uniqueTitle = uniqueFileEntryTitleProvider.provide(
                            groupId,
                            dlFolder.getFolderId(),
                            dlFileEntry.getMimeType(),
                            dlFileEntry.getName());

                    newDlFileEntry = dlAppService.addFileEntry(
                            UUID.randomUUID().toString(), groupId, dlFolder.getFolderId(), getFileName(dlFileEntry.getFileName()), dlFileEntry.getMimeType(), uniqueTitle,
                            StringPool.BLANK, StringPool.BLANK, dlFileEntry.getContentStream().readAllBytes(), null, null,
                            serviceContext);

                } catch (IOException | PortalException e) {
                    throw new RuntimeException(e);
                }

                fileId = newDlFileEntry.getFileEntryId();

                _dgDocumentManagerEntryLocalService.addDGDocumentManager(
                        fileId,
                        GetterUtil.getLong(parentId),
                        pkCode,
                        entry,
                        serviceContext
                );
            } else {
                try {
                    DLFolder newFolder = getFolder(groupId, dlFolder.getFolderId(), entry.getName(), serviceContext);

                    fileId = newFolder.getFolderId();

                    DGDocumentManagerEntry dgDocumentManagerEntry = _dgDocumentManagerEntryLocalService.addDGDocumentManager(
                            fileId,
                            GetterUtil.getLong(parentId),
                            pkCode,
                            entry,
                            serviceContext
                    );

                    handleCloneDocument(groupId, customerId, customerName, moduleId, appId, externalReferenceCode, pkCode, dgDocumentManagerEntry.getParentId(), serviceContext);
                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void uploadMultipleFile(long groupId,
                                   long customerId,
                                   long creatorId,
                                   Long departmentId,
                                   String customerName,
                                   String moduleName,
                                   String appName,
                                   MultipartBody multipartBody,
                                   String category,
                                   String pkCode,
                                   Long parentId,
                                   ServiceContext serviceContext) throws SearchException {

        BinaryFile binaryFile = multipartBody.getBinaryFile("file");

        FileEntry fileEntry;

        String[] relativePath = binaryFile.getFileName().split("/");

        String fileName;

        long size = Arrays.stream(relativePath).count();

        long parent = GetterUtil.getLong(parentId);

        if (size == 1) {
            fileName = relativePath[0];
        } else {
            fileName = relativePath[(int) size - 1];

            for (int j = 0; j <= size - 2; j++) {

                String name = relativePath[j];

                DGDocumentManagerEntry dgDocumentManagerEntry = _dgDocumentManagerEntryLocalService.
                        fetchDgDocumentManagerEntryByNameAndTypeAndPkCodeAndParentIdAndCategoryAndCreatorId(
                                name,
                                DGDocumentManager.Type.FOLDER.getValue(),
                                pkCode,
                                parent,
                                category,
                                creatorId
                        );

                if (Validator.isNull(dgDocumentManagerEntry)) {
                    DocumentManagerMapperModel folder = new DocumentManagerMapperModel();

                    folder.setCategory(category);
                    folder.setName(name);
                    folder.setParentId(parent);
                    folder.setType(DGDocumentManager.Type.FOLDER.getValue());
                    folder.setPkCode(pkCode);

                    dgDocumentManagerEntry = _dgDocumentManagerEntryLocalService.
                            addDGDocumentManager(
                                    customerId,
                                    creatorId,
                                    departmentId,
                                    folder,
                                    serviceContext
                            );
                }

                parent = dgDocumentManagerEntry.getDocumentManagerId();
            }
        }

        String contentType = binaryFile.getContentType();

        InputStream inputStream = binaryFile.getInputStream();

        if (Validator.isNotNull(inputStream)) {

            boolean isLoop = true;

            serviceContext.setAddGroupPermissions(true);
            serviceContext.setAddGuestPermissions(true);

            DLFolder dlFolder = null;

            while (isLoop) {
                try {
                    if (category.equalsIgnoreCase(DGDocumentManager.Category.ATTACHED.getValue())) {
                        dlFolder = getAttachFolder(groupId, customerId, customerName, moduleName, appName, pkCode, GetterUtil.getLong(parentId), serviceContext);
                    } else {
                        if (category.equalsIgnoreCase(DGDocumentManager.Category.PERSONAL.getValue())) {
                            dlFolder = getCategoryElseFolder(groupId, customerId, customerName, moduleName, appName, category, String.valueOf(creatorId), parentId, serviceContext);
                        } else {
                            dlFolder = getCategoryElseFolder(groupId, customerId, customerName, moduleName, appName, category, String.valueOf(departmentId), parentId, serviceContext);
                        }
                    }
                    isLoop = false;
                } catch (PortalException ignore) {

                }
            }

            String uniqueTitle = null;
            isLoop = true;

            while (isLoop) {
                try {
                    uniqueTitle = uniqueFileEntryTitleProvider.provide(
                            groupId,
                            dlFolder.getFolderId(),
                            contentType,
                            fileName);

                    isLoop = false;
                } catch (PortalException ignore) {

                }
            }

            isLoop = true;

            while (isLoop) {

                try {
                    fileEntry = dlAppService.addFileEntry(
                            UUID.randomUUID().toString(), groupId, dlFolder.getFolderId(), getFileName(fileName), contentType, uniqueTitle,
                            StringPool.BLANK, StringPool.BLANK, inputStream.readAllBytes(), null, null,
                            serviceContext);

                    DocumentManagerMapperModel model = _mapper.mapFromFileManagerMapperModelToDGDocumentManager(
                            moduleName,
                            appName,
                            pkCode,
                            category,
                            parent,
                            fileEntry
                    );

                    _dgDocumentManagerEntryLocalService.addDGDocumentManager(customerId, creatorId, departmentId, model, serviceContext);

                    isLoop = false;
                } catch (IOException | PortalException ignore) {
                }
            }
        }
    }

    public DLFolder getCategoryElseFolder(long groupId,
                                          long customerId,
                                          String customerName,
                                          String moduleName,
                                          String appName,
                                          String category,
                                          String name,
                                          long parentId,
                                          ServiceContext serviceContext) throws PortalException {

        DLFolder appFolder = getAppFolder(groupId, customerId, customerName, moduleName, appName, serviceContext);

        DLFolder categoryFolder = getFolder(groupId, appFolder.getFolderId(), category, serviceContext);

//        DLFolder nameFolder = getFolder(groupId, categoryFolder.getFolderId(), name, serviceContext);

        DGDocumentManagerEntry dgDocumentManagerEntry = _dgDocumentManagerEntryLocalService.
                fetchDGDocumentManagerEntry(GetterUtil.getLong(parentId));

        if (Validator.isNull(dgDocumentManagerEntry))
            return getFolder(groupId, categoryFolder.getFolderId(), name, serviceContext);

        return getFolder(groupId, dgDocumentManagerEntry.getFileId(), dgDocumentManagerEntry.getName(), serviceContext);
    }

    public DLFolder getAttachFolder(long groupId,
                                    long customerId,
                                    String customerName,
                                    String moduleName,
                                    String appName,
                                    String pkCode,
                                    long parentId,
                                    ServiceContext serviceContext) throws PortalException {

        DLFolder appFolder = getAppFolder(groupId, customerId, customerName, moduleName, appName, serviceContext);

        DGDocumentManagerEntry dgDocumentManagerEntry = _dgDocumentManagerEntryLocalService.
                fetchDGDocumentManagerEntry(GetterUtil.getLong(parentId));

        if (Validator.isNull(dgDocumentManagerEntry))
            return getFolder(groupId, appFolder.getFolderId(), pkCode, serviceContext);

        return getFolder(groupId, dgDocumentManagerEntry.getFileId(), dgDocumentManagerEntry.getName(), serviceContext);
    }

    public DLFolder getAppFolder(long groupId,
                                 long customerId,
                                 String customerName,
                                 String moduleName,
                                 String appName,
                                 ServiceContext serviceContext)
            throws PortalException {

        DLFolder moduleFolder = getModuleFolder(groupId, customerId, customerName, moduleName, serviceContext);

        return getFolder(groupId, moduleFolder.getFolderId(), appName, serviceContext);
    }

    public DLFolder getModuleFolder(long groupId,
                                    long customerId,
                                    String customerName,
                                    String moduleName,
                                    ServiceContext serviceContext)
            throws PortalException {

        DLFolder rootFolder = getRootFolder(groupId, customerId, customerName, serviceContext);

        return getFolder(groupId, rootFolder.getFolderId(), moduleName, serviceContext);
    }

    public DLFolder getRootFolder(long groupId,
                                  long customerId,
                                  String customerName,
                                  ServiceContext serviceContext)
            throws PortalException {

        return getFolder(
                groupId,
                GetterUtil.DEFAULT_LONG,
                buildRootFolderName(customerId, customerName),
                serviceContext);
    }

    public DLFolder getFolder(long groupId,
                              long folderParentId,
                              String folderName,
                              ServiceContext serviceContext)
            throws PortalException {

        DLFolder dlFolder;

        try {
            dlFolder = dlFolderService.getFolder(
                    groupId,
                    folderParentId,
                    folderName);

            if (Validator.isNotNull(dlFolder)) {
                return dlFolder;
            }
        } catch (Exception ignored) {
        }

        return dlFolderService.addFolder(
                groupId,
                groupId,
                false,
                folderParentId,
                folderName,
                StringPool.BLANK,
                serviceContext);
    }

    private SearchContext getSearchContext(Pagination pagination) {

        SearchContext searchContext = new SearchContext();

        Sort[] sorts = new Sort[]{new Sort(SearchField.TYPE + "_String_sortable", true)};

        searchContext.setSorts(sorts);

        searchContext.setCompanyId(CompanyThreadLocal.getCompanyId());

        searchContext.setStart(pagination.getStartPosition());
        searchContext.setEnd(pagination.getEndPosition());

        return searchContext;
    }

    private BooleanFilter buildBooleanFilterForExpectObjects(long customerId, long userId) {
        BooleanFilter expectObject = new BooleanFilter();

        List<DGFileUserPermissionEntry> dgFileUserPermissionEntriesTrashed =
                _dgFileUserPermissionEntryLocalService.fetchByC_U_S(customerId, userId, "trashed");

        dgFileUserPermissionEntriesTrashed.forEach(dgFileUserPermissionEntry -> {
            TermFilter fileIdTermFilter = new TermFilter(Field.ENTRY_CLASS_PK, String.valueOf(dgFileUserPermissionEntry.getFileId()));

            expectObject.add(fileIdTermFilter, BooleanClauseOccur.MUST_NOT);
        });

        return expectObject;
    }

    private String buildRootFolderName(long customerId,
                                       String customerName) {
        return StringBundler.concat(customerId, StringPool.UNDERLINE, customerName);
    }

    public String getFileName(String fileName) {
        return StringBundler.concat(System.currentTimeMillis(), StringPool.UNDERLINE, fileName);
    }

    @Reference
    private DGDocumentManagerEntryLocalService _dgDocumentManagerEntryLocalService;

    @Reference
    private CommonFileHelper _fileHelper;
    @Reference
    private DGDocumentManagerMapper _mapper;
    @Reference
    private CommonUtil _commonUtil;
    @Reference
    DLAppService dlAppService;
    @Reference
    DLFolderService dlFolderService;
    @Reference
    protected UniqueFileEntryTitleProvider uniqueFileEntryTitleProvider;
    @Reference
    FileResourceService _fileResourceService;
    @Reference
    DGFileManagerEntryLocalService _dgFileManagerEntryLocalService;
    @Reference
    DGFileUserPermissionEntryLocalService _dgFileUserPermissionEntryLocalService;
    @Reference
    DGFileDepartmentPermissionEntryLocalService _dgFileDepartmentPermissionEntryLocalService;

    @Reference
    EmployeeCurrentPositionEntryLocalService _employeeCurrentPositionEntryLocalService;

    @Reference
    FilePermissionService _filePermissionService;

    @Reference
    ProjectEntryLocalService projectEntryLocalService;

    @Reference
    TaskEntryLocalService taskEntryLocalService;

    @Reference
    DoEntryLocalService doEntryLocalService;

    @Reference
    PhaseEntryLocalService phaseEntryLocalService;

    @Reference
    DG_FileUtil dg_fileUtil;

    @Reference
    DLFileEntryLocalService dlFileEntryLocalService;
}
