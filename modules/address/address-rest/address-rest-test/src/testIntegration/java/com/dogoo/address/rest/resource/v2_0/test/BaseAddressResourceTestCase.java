package com.dogoo.address.rest.resource.v2_0.test;

import com.dogoo.address.rest.client.dto.v2_0.Address;
import com.dogoo.address.rest.client.http.HttpInvoker;
import com.dogoo.address.rest.client.pagination.Page;
import com.dogoo.address.rest.client.pagination.Pagination;
import com.dogoo.address.rest.client.resource.v2_0.AddressResource;
import com.dogoo.address.rest.client.serdes.v2_0.AddressSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author datdt
 * @generated
 */
@Generated("")
public abstract class BaseAddressResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_addressResource.setContextCompany(testCompany);

		AddressResource.Builder builder = AddressResource.builder();

		addressResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Address address1 = randomAddress();

		String json = objectMapper.writeValueAsString(address1);

		Address address2 = AddressSerDes.toDTO(json);

		Assert.assertTrue(equals(address1, address2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Address address = randomAddress();

		String json1 = objectMapper.writeValueAsString(address);
		String json2 = AddressSerDes.toJSON(address);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Address address = randomAddress();

		address.setCountry(regex);
		address.setCountryCode(regex);
		address.setDetail(regex);
		address.setDistrict(regex);
		address.setDistrictCode(regex);
		address.setExternalReferenceCode(regex);
		address.setPostalCode(regex);
		address.setProvince(regex);
		address.setProvinceCode(regex);
		address.setTitle(regex);
		address.setWard(regex);
		address.setWardCode(regex);

		String json = AddressSerDes.toJSON(address);

		Assert.assertFalse(json.contains(regex));

		address = AddressSerDes.toDTO(json);

		Assert.assertEquals(regex, address.getCountry());
		Assert.assertEquals(regex, address.getCountryCode());
		Assert.assertEquals(regex, address.getDetail());
		Assert.assertEquals(regex, address.getDistrict());
		Assert.assertEquals(regex, address.getDistrictCode());
		Assert.assertEquals(regex, address.getExternalReferenceCode());
		Assert.assertEquals(regex, address.getPostalCode());
		Assert.assertEquals(regex, address.getProvince());
		Assert.assertEquals(regex, address.getProvinceCode());
		Assert.assertEquals(regex, address.getTitle());
		Assert.assertEquals(regex, address.getWard());
		Assert.assertEquals(regex, address.getWardCode());
	}

	@Test
	public void testDeleteAddress() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Address address = testDeleteAddress_addAddress();

		assertHttpResponseStatusCode(
			204, addressResource.deleteAddressHttpResponse(address.getId()));

		assertHttpResponseStatusCode(
			404, addressResource.getAddressHttpResponse(address.getId()));

		assertHttpResponseStatusCode(
			404, addressResource.getAddressHttpResponse(0L));
	}

	protected Address testDeleteAddress_addAddress() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteAddress() throws Exception {
		Address address = testGraphQLAddress_addAddress();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteAddress",
						new HashMap<String, Object>() {
							{
								put("addressId", address.getId());
							}
						})),
				"JSONObject/data", "Object/deleteAddress"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"address",
					new HashMap<String, Object>() {
						{
							put("addressId", address.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetAddress() throws Exception {
		Address postAddress = testGetAddress_addAddress();

		Address getAddress = addressResource.getAddress(postAddress.getId());

		assertEquals(postAddress, getAddress);
		assertValid(getAddress);
	}

	protected Address testGetAddress_addAddress() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetAddress() throws Exception {
		Address address = testGraphQLAddress_addAddress();

		Assert.assertTrue(
			equals(
				address,
				AddressSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"address",
								new HashMap<String, Object>() {
									{
										put("addressId", address.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/address"))));
	}

	@Test
	public void testGraphQLGetAddressNotFound() throws Exception {
		Long irrelevantAddressId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"address",
						new HashMap<String, Object>() {
							{
								put("addressId", irrelevantAddressId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutAddress() throws Exception {
		Address postAddress = testPutAddress_addAddress();

		Address randomAddress = randomAddress();

		Address putAddress = addressResource.putAddress(
			postAddress.getId(), randomAddress);

		assertEquals(randomAddress, putAddress);
		assertValid(putAddress);

		Address getAddress = addressResource.getAddress(putAddress.getId());

		assertEquals(randomAddress, getAddress);
		assertValid(getAddress);
	}

	protected Address testPutAddress_addAddress() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetAddresses() throws Exception {
		Page<Address> page = addressResource.getAddresses(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Address address1 = testGetAddresses_addAddress(randomAddress());

		Address address2 = testGetAddresses_addAddress(randomAddress());

		page = addressResource.getAddresses(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(address1, (List<Address>)page.getItems());
		assertContains(address2, (List<Address>)page.getItems());
		assertValid(page);

		addressResource.deleteAddress(address1.getId());

		addressResource.deleteAddress(address2.getId());
	}

	@Test
	public void testGetAddressesWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Address address1 = randomAddress();

		address1 = testGetAddresses_addAddress(address1);

		for (EntityField entityField : entityFields) {
			Page<Address> page = addressResource.getAddresses(
				null, getFilterString(entityField, "between", address1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(address1),
				(List<Address>)page.getItems());
		}
	}

	@Test
	public void testGetAddressesWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Address address1 = testGetAddresses_addAddress(randomAddress());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Address address2 = testGetAddresses_addAddress(randomAddress());

		for (EntityField entityField : entityFields) {
			Page<Address> page = addressResource.getAddresses(
				null, getFilterString(entityField, "eq", address1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(address1),
				(List<Address>)page.getItems());
		}
	}

	@Test
	public void testGetAddressesWithPagination() throws Exception {
		Page<Address> totalPage = addressResource.getAddresses(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Address address1 = testGetAddresses_addAddress(randomAddress());

		Address address2 = testGetAddresses_addAddress(randomAddress());

		Address address3 = testGetAddresses_addAddress(randomAddress());

		Page<Address> page1 = addressResource.getAddresses(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Address> addresses1 = (List<Address>)page1.getItems();

		Assert.assertEquals(
			addresses1.toString(), totalCount + 2, addresses1.size());

		Page<Address> page2 = addressResource.getAddresses(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Address> addresses2 = (List<Address>)page2.getItems();

		Assert.assertEquals(addresses2.toString(), 1, addresses2.size());

		Page<Address> page3 = addressResource.getAddresses(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(address1, (List<Address>)page3.getItems());
		assertContains(address2, (List<Address>)page3.getItems());
		assertContains(address3, (List<Address>)page3.getItems());
	}

	@Test
	public void testGetAddressesWithSortDateTime() throws Exception {
		testGetAddressesWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, address1, address2) -> {
				BeanUtils.setProperty(
					address1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetAddressesWithSortInteger() throws Exception {
		testGetAddressesWithSort(
			EntityField.Type.INTEGER,
			(entityField, address1, address2) -> {
				BeanUtils.setProperty(address1, entityField.getName(), 0);
				BeanUtils.setProperty(address2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetAddressesWithSortString() throws Exception {
		testGetAddressesWithSort(
			EntityField.Type.STRING,
			(entityField, address1, address2) -> {
				Class<?> clazz = address1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						address1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						address2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						address1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						address2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						address1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						address2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetAddressesWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Address, Address, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Address address1 = randomAddress();
		Address address2 = randomAddress();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, address1, address2);
		}

		address1 = testGetAddresses_addAddress(address1);

		address2 = testGetAddresses_addAddress(address2);

		for (EntityField entityField : entityFields) {
			Page<Address> ascPage = addressResource.getAddresses(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(address1, address2),
				(List<Address>)ascPage.getItems());

			Page<Address> descPage = addressResource.getAddresses(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(address2, address1),
				(List<Address>)descPage.getItems());
		}
	}

	protected Address testGetAddresses_addAddress(Address address)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetAddresses() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"addresses",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject addressesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/addresses");

		long totalCount = addressesJSONObject.getLong("totalCount");

		Address address1 = testGraphQLAddress_addAddress();
		Address address2 = testGraphQLAddress_addAddress();

		addressesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/addresses");

		Assert.assertEquals(
			totalCount + 2, addressesJSONObject.getLong("totalCount"));

		assertContains(
			address1,
			Arrays.asList(
				AddressSerDes.toDTOs(addressesJSONObject.getString("items"))));
		assertContains(
			address2,
			Arrays.asList(
				AddressSerDes.toDTOs(addressesJSONObject.getString("items"))));
	}

	@Test
	public void testAddAddress() throws Exception {
		Address randomAddress = randomAddress();

		Address postAddress = testAddAddress_addAddress(randomAddress);

		assertEquals(randomAddress, postAddress);
		assertValid(postAddress);
	}

	protected Address testAddAddress_addAddress(Address address)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteAddressByExternalReferenceCode() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Address address = testDeleteAddressByExternalReferenceCode_addAddress();

		assertHttpResponseStatusCode(
			204,
			addressResource.deleteAddressByExternalReferenceCodeHttpResponse(
				address.getExternalReferenceCode()));

		assertHttpResponseStatusCode(
			404,
			addressResource.getAddressByExternalReferenceCodeHttpResponse(
				address.getExternalReferenceCode()));

		assertHttpResponseStatusCode(
			404,
			addressResource.getAddressByExternalReferenceCodeHttpResponse(
				address.getExternalReferenceCode()));
	}

	protected Address testDeleteAddressByExternalReferenceCode_addAddress()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetAddressByExternalReferenceCode() throws Exception {
		Address postAddress =
			testGetAddressByExternalReferenceCode_addAddress();

		Address getAddress = addressResource.getAddressByExternalReferenceCode(
			postAddress.getExternalReferenceCode());

		assertEquals(postAddress, getAddress);
		assertValid(getAddress);
	}

	protected Address testGetAddressByExternalReferenceCode_addAddress()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetAddressByExternalReferenceCode()
		throws Exception {

		Address address = testGraphQLAddress_addAddress();

		Assert.assertTrue(
			equals(
				address,
				AddressSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"addressByExternalReferenceCode",
								new HashMap<String, Object>() {
									{
										put(
											"externalReferenceCode",
											"\"" +
												address.
													getExternalReferenceCode() +
														"\"");
									}
								},
								getGraphQLFields())),
						"JSONObject/data",
						"Object/addressByExternalReferenceCode"))));
	}

	@Test
	public void testGraphQLGetAddressByExternalReferenceCodeNotFound()
		throws Exception {

		String irrelevantExternalReferenceCode =
			"\"" + RandomTestUtil.randomString() + "\"";

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"addressByExternalReferenceCode",
						new HashMap<String, Object>() {
							{
								put(
									"externalReferenceCode",
									irrelevantExternalReferenceCode);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutAddressByExternalReferenceCode() throws Exception {
		Address postAddress =
			testPutAddressByExternalReferenceCode_addAddress();

		Address randomAddress = randomAddress();

		Address putAddress = addressResource.putAddressByExternalReferenceCode(
			postAddress.getExternalReferenceCode(), randomAddress);

		assertEquals(randomAddress, putAddress);
		assertValid(putAddress);

		Address getAddress = addressResource.getAddressByExternalReferenceCode(
			putAddress.getExternalReferenceCode());

		assertEquals(randomAddress, getAddress);
		assertValid(getAddress);

		Address newAddress =
			testPutAddressByExternalReferenceCode_createAddress();

		putAddress = addressResource.putAddressByExternalReferenceCode(
			newAddress.getExternalReferenceCode(), newAddress);

		assertEquals(newAddress, putAddress);
		assertValid(putAddress);

		getAddress = addressResource.getAddressByExternalReferenceCode(
			putAddress.getExternalReferenceCode());

		assertEquals(newAddress, getAddress);

		Assert.assertEquals(
			newAddress.getExternalReferenceCode(),
			putAddress.getExternalReferenceCode());
	}

	protected Address testPutAddressByExternalReferenceCode_createAddress()
		throws Exception {

		return randomAddress();
	}

	protected Address testPutAddressByExternalReferenceCode_addAddress()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Address testGraphQLAddress_addAddress() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Address address, List<Address> addresses) {
		boolean contains = false;

		for (Address item : addresses) {
			if (equals(address, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(addresses + " does not contain " + address, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Address address1, Address address2) {
		Assert.assertTrue(
			address1 + " does not equal " + address2,
			equals(address1, address2));
	}

	protected void assertEquals(
		List<Address> addresses1, List<Address> addresses2) {

		Assert.assertEquals(addresses1.size(), addresses2.size());

		for (int i = 0; i < addresses1.size(); i++) {
			Address address1 = addresses1.get(i);
			Address address2 = addresses2.get(i);

			assertEquals(address1, address2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Address> addresses1, List<Address> addresses2) {

		Assert.assertEquals(addresses1.size(), addresses2.size());

		for (Address address1 : addresses1) {
			boolean contains = false;

			for (Address address2 : addresses2) {
				if (equals(address1, address2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				addresses2 + " does not contain " + address1, contains);
		}
	}

	protected void assertValid(Address address) throws Exception {
		boolean valid = true;

		if (address.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("country", additionalAssertFieldName)) {
				if (address.getCountry() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("countryCode", additionalAssertFieldName)) {
				if (address.getCountryCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("detail", additionalAssertFieldName)) {
				if (address.getDetail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("district", additionalAssertFieldName)) {
				if (address.getDistrict() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("districtCode", additionalAssertFieldName)) {
				if (address.getDistrictCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (address.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("postalCode", additionalAssertFieldName)) {
				if (address.getPostalCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("province", additionalAssertFieldName)) {
				if (address.getProvince() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("provinceCode", additionalAssertFieldName)) {
				if (address.getProvinceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (address.getTitle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("ward", additionalAssertFieldName)) {
				if (address.getWard() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("wardCode", additionalAssertFieldName)) {
				if (address.getWardCode() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Address> page) {
		boolean valid = false;

		java.util.Collection<Address> addresses = page.getItems();

		int size = addresses.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.dogoo.address.rest.dto.v2_0.Address.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Address address1, Address address2) {
		if (address1 == address2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("country", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getCountry(), address2.getCountry())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("countryCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getCountryCode(), address2.getCountryCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("detail", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getDetail(), address2.getDetail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("district", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getDistrict(), address2.getDistrict())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("districtCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getDistrictCode(),
						address2.getDistrictCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						address1.getExternalReferenceCode(),
						address2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(address1.getId(), address2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("postalCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getPostalCode(), address2.getPostalCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("province", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getProvince(), address2.getProvince())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("provinceCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getProvinceCode(),
						address2.getProvinceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getTitle(), address2.getTitle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("ward", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getWard(), address2.getWard())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("wardCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						address1.getWardCode(), address2.getWardCode())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_addressResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_addressResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Address address) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("country")) {
			sb.append("'");
			sb.append(String.valueOf(address.getCountry()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("countryCode")) {
			sb.append("'");
			sb.append(String.valueOf(address.getCountryCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("detail")) {
			sb.append("'");
			sb.append(String.valueOf(address.getDetail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("district")) {
			sb.append("'");
			sb.append(String.valueOf(address.getDistrict()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("districtCode")) {
			sb.append("'");
			sb.append(String.valueOf(address.getDistrictCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(address.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("postalCode")) {
			sb.append("'");
			sb.append(String.valueOf(address.getPostalCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("province")) {
			sb.append("'");
			sb.append(String.valueOf(address.getProvince()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("provinceCode")) {
			sb.append("'");
			sb.append(String.valueOf(address.getProvinceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("title")) {
			sb.append("'");
			sb.append(String.valueOf(address.getTitle()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("ward")) {
			sb.append("'");
			sb.append(String.valueOf(address.getWard()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("wardCode")) {
			sb.append("'");
			sb.append(String.valueOf(address.getWardCode()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Address randomAddress() throws Exception {
		return new Address() {
			{
				country = StringUtil.toLowerCase(RandomTestUtil.randomString());
				countryCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				detail = StringUtil.toLowerCase(RandomTestUtil.randomString());
				district = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				districtCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				postalCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				province = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				provinceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				title = StringUtil.toLowerCase(RandomTestUtil.randomString());
				ward = StringUtil.toLowerCase(RandomTestUtil.randomString());
				wardCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected Address randomIrrelevantAddress() throws Exception {
		Address randomIrrelevantAddress = randomAddress();

		return randomIrrelevantAddress;
	}

	protected Address randomPatchAddress() throws Exception {
		return randomAddress();
	}

	protected AddressResource addressResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseAddressResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.dogoo.address.rest.resource.v2_0.AddressResource
		_addressResource;

}