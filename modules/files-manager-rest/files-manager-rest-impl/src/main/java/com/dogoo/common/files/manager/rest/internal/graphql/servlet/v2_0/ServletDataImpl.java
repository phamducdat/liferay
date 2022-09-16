package com.dogoo.common.files.manager.rest.internal.graphql.servlet.v2_0;

import com.dogoo.common.files.manager.rest.internal.graphql.mutation.v2_0.Mutation;
import com.dogoo.common.files.manager.rest.internal.graphql.query.v2_0.Query;
import com.dogoo.common.files.manager.rest.resource.v2_0.DGDocumentManagerResource;
import com.dogoo.common.files.manager.rest.resource.v2_0.DGFileManagerResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author khoa
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setDGDocumentManagerResourceComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects);
		Mutation.setDGFileManagerResourceComponentServiceObjects(
			_dgFileManagerResourceComponentServiceObjects);

		Query.setDGDocumentManagerResourceComponentServiceObjects(
			_dgDocumentManagerResourceComponentServiceObjects);
		Query.setDGFileManagerResourceComponentServiceObjects(
			_dgFileManagerResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/dogoo/files-manager-rest-graphql/v2_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<DGDocumentManagerResource>
		_dgDocumentManagerResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<DGFileManagerResource>
		_dgFileManagerResourceComponentServiceObjects;

}