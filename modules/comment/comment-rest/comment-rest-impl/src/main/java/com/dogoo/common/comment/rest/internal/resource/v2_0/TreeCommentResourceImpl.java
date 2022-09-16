package com.dogoo.common.comment.rest.internal.resource.v2_0;

import com.dogoo.common.comment.rest.dto.v2_0.TreeComment;
import com.dogoo.common.comment.rest.internal.service.TreeCommentService;
import com.dogoo.common.comment.rest.resource.v2_0.TreeCommentResource;

import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.List;

/**
 * @author khoa
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/tree-comment.properties",
	scope = ServiceScope.PROTOTYPE, service = TreeCommentResource.class
)
public class TreeCommentResourceImpl extends BaseTreeCommentResourceImpl {

	@Override
	public Page<TreeComment> getAllTreeComment(Long classPkId, String classPkName , Integer pageSize) throws Exception {
		List<TreeComment> treeCommentList = _treeCommentService.
				getTreeCommentByPkIdAndPkName(
						getUserToken().getCustomerId(),
						classPkId,
						classPkName);
		return Page.of(treeCommentList);
	}

	public UserTokenModel getUserToken() {
		return _commonTokenHelper.getUserToken(contextHttpServletRequest);
	}

	@Reference
	private TreeCommentService _treeCommentService;

	@Reference
	private CommonTokenHelper _commonTokenHelper;
}