package com.dogoo.address.rest.internal.resource.v2_0;

import com.dogoo.address.rest.dto.v2_0.Address;
import com.dogoo.address.rest.internal.mapper.AddressMapper;
import com.dogoo.address.rest.internal.odata.v2_0.AddressEntityIndexModel;
import com.dogoo.address.rest.internal.service.AddressService;
import com.dogoo.address.rest.internal.util.LanguageKeys;
import com.dogoo.address.rest.internal.validator.AddressValidator;
import com.dogoo.address.rest.resource.v2_0.AddressResource;

import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Locale;

/**
 * @author datdt
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/address.properties",
	scope = ServiceScope.PROTOTYPE, service = AddressResource.class
)
public class AddressResourceImpl extends BaseAddressResourceImpl {
	private AddressEntityIndexModel _addressEntityIndexModel = new AddressEntityIndexModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) { return _addressEntityIndexModel; }

	@Override
	public Page<Address> getAddresses(String search,
									  Filter filter,
									  Pagination pagination,
									  Sort[] sorts) throws Exception {
		_addressValidator.validatorForSearch(pagination);

		return _addressService.getAddresses(
				getUserToken().getCustomerId(),
				search,
				filter,
				pagination,
				sorts,
				getServiceContext()
		);
	}

	@Override
	public Address addAddress(Address address) throws Exception {
		_addressValidator.validatorForAddAddress(address, getLocale());

		return _addressService.addAddress(
				getUserToken().getCustomerId(),
				getUserToken().getUserId(),
				address,
				getServiceContext()
		);
	}

	@Override
	public void deleteAddress(Long addressId) throws Exception {
		_addressValidator.validatorAddressIsExists(addressId, getLocale());

		_addressService.deleteAddress(addressId);
	}

	@Override
	public Address getAddress(Long addressId) throws Exception {
		_addressValidator.validatorAddressIsExists(addressId, getLocale());

		return _addressService.getAddressById(addressId);
	}

	@Override
	public Address putAddress(Long addressId, Address address) throws Exception {
		_addressValidator.validatorForUpdateAddress(addressId, address, getLocale());

		return _addressService.updateAddress(
				getUserToken().getUserId(),
				addressId,
				address,
				getServiceContext()
		);
	}

	@Override
	public void deleteAddressByExternalReferenceCode(String externalReferenceCode)
		throws Exception {

		long addressId = _addressMapper.getAddressEntryId(externalReferenceCode);

		deleteAddress(addressId);
	}

	@Override
	public Address getAddressByExternalReferenceCode(String externalReferenceCode)
		throws Exception {

		long addressId = _addressMapper.getAddressEntryId(externalReferenceCode);

		return getAddress(addressId);
	}

	@Override
	public Address putAddressByExternalReferenceCode(String externalReferenceCode,
													 Address address) throws Exception {

		long addressId = _addressMapper.getAddressEntryId(externalReferenceCode);

		return putAddress(addressId, address);
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

		return serviceContext;
	}

	private UserTokenModel getUserToken() {
		return _tokenHelper.getUserToken(contextHttpServletRequest);
	}

	@Reference
	private CommonTokenHelper _tokenHelper;

	@Reference
	private AddressService _addressService;

	@Reference
	private AddressValidator _addressValidator;

	@Reference
	private AddressMapper _addressMapper;
}