package com.dogoo.common.files.manager.rest.resource.v2_0;

import com.dogoo.common.files.manager.rest.dto.v2_0.AttachPermission;
import com.dogoo.common.files.manager.rest.dto.v2_0.Config;
import com.dogoo.common.files.manager.rest.dto.v2_0.FileData;
import com.dogoo.common.files.manager.rest.dto.v2_0.FilePermission;
import com.dogoo.common.files.manager.rest.dto.v2_0.FilePermissionDepartment;
import com.dogoo.common.files.manager.rest.dto.v2_0.FilePermissionUser;
import com.dogoo.common.files.manager.rest.dto.v2_0.FilePreview;
import com.dogoo.common.files.manager.rest.dto.v2_0.FileRes;
import com.dogoo.common.files.manager.rest.dto.v2_0.FileUpdate;
import com.dogoo.common.files.manager.rest.dto.v2_0.GeneralPermission;
import com.dogoo.common.files.manager.rest.dto.v2_0.SettingPermission;
import com.dogoo.common.files.manager.rest.dto.v2_0.User;

import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.odata.filter.ExpressionConvert;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/dogoo/files-manager-rest/v2.0
 *
 * @author khoa
 * @generated
 */
@Generated("")
@ProviderType
public interface FilesResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public FileRes postFile(MultipartBody multipartBody) throws Exception;

	public Page<FilePreview> getAllFileByUserId(Long userId) throws Exception;

	public Config getConfigFileById(Long fileId) throws Exception;

	public FileData getFileById(Long fileId) throws Exception;

	public FileUpdate updateFile(Long fileId, FileUpdate fileUpdate)
		throws Exception;

	public void postMultipleFiles(MultipartBody multipartBody) throws Exception;

	public FilePreview getFilePreview(Long fileId) throws Exception;

	public String getFileDownload(Long fileId) throws Exception;

	public FilePermission getFilePermission(Long fileId) throws Exception;

	public void AttachPermission(Long fileId, AttachPermission attachPermission)
		throws Exception;

	public void DeleteFileUserPermission(Long fileId, Long userId)
		throws Exception;

	public void UpdateFilePermissionUser(
			Long fileId, Long userId, FilePermissionUser filePermissionUser)
		throws Exception;

	public void DeleteFilePermissionDepartment(Long fileId, Long departmentId)
		throws Exception;

	public void UpdateFilePermissionDepartment(
			Long fileId, Long departmentId,
			FilePermissionDepartment filePermissionDepartment)
		throws Exception;

	public void updateGeneralPermission(
			Long fileId, GeneralPermission generalPermission)
		throws Exception;

	public void updateSettingPermission(
			Long fileId, SettingPermission settingPermission)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

	public void setExpressionConvert(
		ExpressionConvert<Filter> expressionConvert);

	public void setFilterParserProvider(
		FilterParserProvider filterParserProvider);

	public void setGroupLocalService(GroupLocalService groupLocalService);

	public void setResourceActionLocalService(
		ResourceActionLocalService resourceActionLocalService);

	public void setResourcePermissionLocalService(
		ResourcePermissionLocalService resourcePermissionLocalService);

	public void setRoleLocalService(RoleLocalService roleLocalService);

	public default Filter toFilter(String filterString) {
		return toFilter(
			filterString, Collections.<String, List<String>>emptyMap());
	}

	public default Filter toFilter(
		String filterString, Map<String, List<String>> multivaluedMap) {

		return null;
	}

	public static class FactoryHolder {

		public static volatile Factory factory;

	}

	@ProviderType
	public interface Builder {

		public FilesResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder httpServletResponse(
			HttpServletResponse httpServletResponse);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}