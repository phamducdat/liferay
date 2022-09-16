package com.dogoo.common.files.manager.rest.internal.resource.v2_0;

import com.dogoo.common.files.manager.rest.dto.v2_0.DGFileManager;
import com.dogoo.common.files.manager.rest.internal.service.DGFileManagerService;
import com.dogoo.common.files.manager.rest.resource.v2_0.DGFileManagerResource;
import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author khoa
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/dg-file-manager.properties",
	scope = ServiceScope.PROTOTYPE, service = DGFileManagerResource.class
)
public class DGFileManagerResourceImpl extends BaseDGFileManagerResourceImpl {

	@Override
	public DGFileManager postDGFileManager(DGFileManager dgFileManager) throws Exception {
		return _service.postDGFileManager(
				getUserToken().getCustomerId() , getUserToken().getUserId() , dgFileManager , getServiceContext());
	}

	@Override
	public Page<DGFileManager> getAllDGFileManagerByPkType(String parentCode, String pkType) throws Exception {
		return Page.of(_service.getAllDGFileManagerByPkType(getUserToken().getCustomerId(), parentCode, pkType ));
	}

	@Override
	public Page<DGFileManager> getAllDGFileManager( String parentCode) throws Exception {
		return Page.of(_service.getAllDGFileManager(getUserToken().getCustomerId(),
				parentCode ));
	}

	@Override
	public void deleteDGFileManager(Long fileId) throws Exception {
		_service.deleteFileId(fileId , getUserToken().getCustomerId());
	}

	@Override
	public void deleteMediaFiles(String parentCode) throws Exception {
		_service.deleteFileManagerOfParent(getUserToken().getCustomerId() , parentCode );
	}

	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		return serviceContext;
	}

	@Override
	public DGFileManager getDGFileManager(Long fileId) throws Exception {
		return _service.getDgFileManagerByFileId(fileId);
	}

	private UserTokenModel getUserToken() {
		return _tokenHelper.getUserToken(contextHttpServletRequest);
	}


	@Reference
	private CommonTokenHelper _tokenHelper;

	@Reference
	private DGFileManagerService _service;


}