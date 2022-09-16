package com.dogoo.dataitems.rest.internal.resource.v2_0;

import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.dataitems.rest.dto.v2_0.DataItem;
import com.dogoo.dataitems.rest.dto.v2_0.InitDataItem;
import com.dogoo.dataitems.rest.internal.mapper.DataItemMapper;
import com.dogoo.dataitems.rest.internal.odata.v2_0.DataItemEntryModel;
import com.dogoo.dataitems.rest.internal.service.DataItemService;
import com.dogoo.dataitems.rest.internal.util.LanguageKeys;
import com.dogoo.dataitems.rest.internal.validator.DataItemValidator;
import com.dogoo.dataitems.rest.resource.v2_0.DataItemResource;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author khoa
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/data-item.properties",
	scope = ServiceScope.PROTOTYPE, service = DataItemResource.class
)
public class DataItemResourceImpl extends BaseDataItemResourceImpl {
	private final EntityModel _entityModel = new DataItemEntryModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return _entityModel;
	}

	@Override
	public DataItem postDataItem(DataItem dataItem) throws Exception {
		_dataItemValidator.validateForAdd(
				getUserToken().getCustomerId(),
				dataItem,
				getLocale());

		return _dataItemService.addDataItem(
					getUserToken().getCustomerId(),
					getUserToken().getUserId(),
					dataItem,
					getServiceContext());
	}

	@Override
	public void postInitDataItem(InitDataItem initDataItem) throws Exception {
		Arrays.stream(initDataItem.getDataItems()).forEach(dataItem -> {
			_dataItemService.addDataItem(
					initDataItem.getCustomerId(),
					getUserToken().getUserId(),
					dataItem,
					getServiceContext());
		});
	}

	@Override
	public void deleteDataItem(Long dataItemId) throws Exception {
		_dataItemValidator.validateForDelete(dataItemId, getLocale());

		_dataItemService.deleteDataItemById(dataItemId);
	}

	@Override
	public DataItem getDataItem(Long dataItemId) throws Exception {
		_dataItemValidator.validateDataItemExist(dataItemId, getLocale());

		return _dataItemService.getDataItemById(dataItemId);
	}

	@Override
	public DataItem putDataItem(Long dataItemId, DataItem dataItem) throws Exception {

		_dataItemValidator.validateForUpdate(
				getUserToken().getCustomerId(),
				dataItemId,
				dataItem,
				getLocale());

		return _dataItemService.updateDataItem(
				getUserToken().getUserId(),
				dataItemId,
				dataItem,
				getServiceContext());
	}

	@Override
	public void deleteDataItemByExternalReferenceCode(String externalReferenceCode) throws Exception {

		long dataItemId =
				_dataItemMapper.getDataItemEntryId(externalReferenceCode);

		_dataItemValidator.validateForDelete(dataItemId, getLocale());

		deleteDataItem(dataItemId);
	}

	@Override
	public DataItem getDataItemByExternalReferenceCode(String externalReferenceCode) throws Exception {
		long dataItemId =
				_dataItemMapper.getDataItemEntryId(externalReferenceCode);

		return getDataItem(dataItemId);
	}

	@Override
	public DataItem putDataItemByExternalReferenceCode(String externalReferenceCode, DataItem dataItem) throws Exception {
		long dataItemId =
				_dataItemMapper.getDataItemEntryId(externalReferenceCode);

		return putDataItem(dataItemId, dataItem);
	}

	@Override
	public Page<DataItem> getDataItemByParentCode(String type,
												  String parentCode,
												  Integer sibling) throws Exception {

		long parentId =
				_dataItemMapper.getDataItemEntryId(parentCode);

		return _dataItemService.getDataItemsByParentCodePage(
				sibling,
				getUserToken().getCustomerId(),
				type,
				parentId,
				getServiceContext());
	}

	public Locale getLocale() {

		Locale locale = contextHttpServletRequest.getLocale();

		if (locale.getLanguage().isEmpty()) {
			locale = new Locale(LanguageKeys.DEFAULT_LANG, LanguageKeys.DEFAULT_COUNTRY);
		}

		return locale;
	}

	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());
		serviceContext.setLanguageId(getLocale().getLanguage());

		return serviceContext;
	}

	private UserTokenModel getUserToken() {
		return _tokenHelper.getUserToken(contextHttpServletRequest);
	}

	@Reference
	private CommonTokenHelper _tokenHelper;

	@Reference
	private DataItemService _dataItemService;

	@Reference
	private DataItemValidator _dataItemValidator;

	@Reference
	private DataItemMapper _dataItemMapper;
}