package com.dogoo.common.api.rest.internal.graphql.servlet.v2_0;

import com.dogoo.common.api.rest.internal.graphql.mutation.v2_0.Mutation;
import com.dogoo.common.api.rest.internal.graphql.query.v2_0.Query;
import com.dogoo.common.api.rest.resource.v2_0.EmployeeReferenceResource;

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
		Query.setEmployeeReferenceResourceComponentServiceObjects(
			_employeeReferenceResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/dogoo/common-api-rest-graphql/v2_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<EmployeeReferenceResource>
		_employeeReferenceResourceComponentServiceObjects;

}