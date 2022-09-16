package com.dogoo.dataitems.rest.resource.v2_0.test;

import com.dogoo.dataitems.rest.client.dto.v2_0.Location;
import com.dogoo.dataitems.rest.client.http.HttpInvoker;
import com.dogoo.dataitems.rest.client.pagination.Page;
import com.dogoo.dataitems.rest.client.pagination.Pagination;
import com.dogoo.dataitems.rest.client.resource.v2_0.LocationResource;
import com.dogoo.dataitems.rest.client.serdes.v2_0.LocationSerDes;

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
 * @author khoa
 * @generated
 */
@Generated("")
public abstract class BaseLocationResourceTestCase {

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

		_locationResource.setContextCompany(testCompany);

		LocationResource.Builder builder = LocationResource.builder();

		locationResource = builder.authentication(
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

		Location location1 = randomLocation();

		String json = objectMapper.writeValueAsString(location1);

		Location location2 = LocationSerDes.toDTO(json);

		Assert.assertTrue(equals(location1, location2));
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

		Location location = randomLocation();

		String json1 = objectMapper.writeValueAsString(location);
		String json2 = LocationSerDes.toJSON(location);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Location location = randomLocation();

		location.setDistrict(regex);
		location.setDistrictCode(regex);
		location.setExternalReferenceCode(regex);
		location.setProvince(regex);
		location.setProvinceCode(regex);
		location.setTitle(regex);
		location.setWard(regex);
		location.setWardCode(regex);

		String json = LocationSerDes.toJSON(location);

		Assert.assertFalse(json.contains(regex));

		location = LocationSerDes.toDTO(json);

		Assert.assertEquals(regex, location.getDistrict());
		Assert.assertEquals(regex, location.getDistrictCode());
		Assert.assertEquals(regex, location.getExternalReferenceCode());
		Assert.assertEquals(regex, location.getProvince());
		Assert.assertEquals(regex, location.getProvinceCode());
		Assert.assertEquals(regex, location.getTitle());
		Assert.assertEquals(regex, location.getWard());
		Assert.assertEquals(regex, location.getWardCode());
	}

	@Test
	public void testGetLocationDatasPage() throws Exception {
		Page<Location> page = locationResource.getLocationDatasPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Location location1 = testGetLocationDatasPage_addLocation(
			randomLocation());

		Location location2 = testGetLocationDatasPage_addLocation(
			randomLocation());

		page = locationResource.getLocationDatasPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(location1, (List<Location>)page.getItems());
		assertContains(location2, (List<Location>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetLocationDatasPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Location location1 = randomLocation();

		location1 = testGetLocationDatasPage_addLocation(location1);

		for (EntityField entityField : entityFields) {
			Page<Location> page = locationResource.getLocationDatasPage(
				null, getFilterString(entityField, "between", location1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(location1),
				(List<Location>)page.getItems());
		}
	}

	@Test
	public void testGetLocationDatasPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Location location1 = testGetLocationDatasPage_addLocation(
			randomLocation());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Location location2 = testGetLocationDatasPage_addLocation(
			randomLocation());

		for (EntityField entityField : entityFields) {
			Page<Location> page = locationResource.getLocationDatasPage(
				null, getFilterString(entityField, "eq", location1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(location1),
				(List<Location>)page.getItems());
		}
	}

	@Test
	public void testGetLocationDatasPageWithPagination() throws Exception {
		Page<Location> totalPage = locationResource.getLocationDatasPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Location location1 = testGetLocationDatasPage_addLocation(
			randomLocation());

		Location location2 = testGetLocationDatasPage_addLocation(
			randomLocation());

		Location location3 = testGetLocationDatasPage_addLocation(
			randomLocation());

		Page<Location> page1 = locationResource.getLocationDatasPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Location> locations1 = (List<Location>)page1.getItems();

		Assert.assertEquals(
			locations1.toString(), totalCount + 2, locations1.size());

		Page<Location> page2 = locationResource.getLocationDatasPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Location> locations2 = (List<Location>)page2.getItems();

		Assert.assertEquals(locations2.toString(), 1, locations2.size());

		Page<Location> page3 = locationResource.getLocationDatasPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(location1, (List<Location>)page3.getItems());
		assertContains(location2, (List<Location>)page3.getItems());
		assertContains(location3, (List<Location>)page3.getItems());
	}

	@Test
	public void testGetLocationDatasPageWithSortDateTime() throws Exception {
		testGetLocationDatasPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, location1, location2) -> {
				BeanUtils.setProperty(
					location1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetLocationDatasPageWithSortInteger() throws Exception {
		testGetLocationDatasPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, location1, location2) -> {
				BeanUtils.setProperty(location1, entityField.getName(), 0);
				BeanUtils.setProperty(location2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetLocationDatasPageWithSortString() throws Exception {
		testGetLocationDatasPageWithSort(
			EntityField.Type.STRING,
			(entityField, location1, location2) -> {
				Class<?> clazz = location1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						location1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						location2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						location1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						location2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						location1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						location2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetLocationDatasPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Location, Location, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Location location1 = randomLocation();
		Location location2 = randomLocation();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, location1, location2);
		}

		location1 = testGetLocationDatasPage_addLocation(location1);

		location2 = testGetLocationDatasPage_addLocation(location2);

		for (EntityField entityField : entityFields) {
			Page<Location> ascPage = locationResource.getLocationDatasPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(location1, location2),
				(List<Location>)ascPage.getItems());

			Page<Location> descPage = locationResource.getLocationDatasPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(location2, location1),
				(List<Location>)descPage.getItems());
		}
	}

	protected Location testGetLocationDatasPage_addLocation(Location location)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Location testGraphQLLocation_addLocation() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Location location, List<Location> locations) {
		boolean contains = false;

		for (Location item : locations) {
			if (equals(location, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			locations + " does not contain " + location, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Location location1, Location location2) {
		Assert.assertTrue(
			location1 + " does not equal " + location2,
			equals(location1, location2));
	}

	protected void assertEquals(
		List<Location> locations1, List<Location> locations2) {

		Assert.assertEquals(locations1.size(), locations2.size());

		for (int i = 0; i < locations1.size(); i++) {
			Location location1 = locations1.get(i);
			Location location2 = locations2.get(i);

			assertEquals(location1, location2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Location> locations1, List<Location> locations2) {

		Assert.assertEquals(locations1.size(), locations2.size());

		for (Location location1 : locations1) {
			boolean contains = false;

			for (Location location2 : locations2) {
				if (equals(location1, location2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				locations2 + " does not contain " + location1, contains);
		}
	}

	protected void assertValid(Location location) throws Exception {
		boolean valid = true;

		if (location.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("district", additionalAssertFieldName)) {
				if (location.getDistrict() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("districtCode", additionalAssertFieldName)) {
				if (location.getDistrictCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (location.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("isDefault", additionalAssertFieldName)) {
				if (location.getIsDefault() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("province", additionalAssertFieldName)) {
				if (location.getProvince() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("provinceCode", additionalAssertFieldName)) {
				if (location.getProvinceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (location.getTitle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("ward", additionalAssertFieldName)) {
				if (location.getWard() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("wardCode", additionalAssertFieldName)) {
				if (location.getWardCode() == null) {
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

	protected void assertValid(Page<Location> page) {
		boolean valid = false;

		java.util.Collection<Location> locations = page.getItems();

		int size = locations.size();

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
					com.dogoo.dataitems.rest.dto.v2_0.Location.class)) {

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

	protected boolean equals(Location location1, Location location2) {
		if (location1 == location2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("district", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						location1.getDistrict(), location2.getDistrict())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("districtCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						location1.getDistrictCode(),
						location2.getDistrictCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						location1.getExternalReferenceCode(),
						location2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(location1.getId(), location2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("isDefault", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						location1.getIsDefault(), location2.getIsDefault())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("province", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						location1.getProvince(), location2.getProvince())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("provinceCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						location1.getProvinceCode(),
						location2.getProvinceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						location1.getTitle(), location2.getTitle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("ward", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						location1.getWard(), location2.getWard())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("wardCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						location1.getWardCode(), location2.getWardCode())) {

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

		if (!(_locationResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_locationResource;

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
		EntityField entityField, String operator, Location location) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("district")) {
			sb.append("'");
			sb.append(String.valueOf(location.getDistrict()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("districtCode")) {
			sb.append("'");
			sb.append(String.valueOf(location.getDistrictCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(location.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("isDefault")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("province")) {
			sb.append("'");
			sb.append(String.valueOf(location.getProvince()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("provinceCode")) {
			sb.append("'");
			sb.append(String.valueOf(location.getProvinceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("title")) {
			sb.append("'");
			sb.append(String.valueOf(location.getTitle()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("ward")) {
			sb.append("'");
			sb.append(String.valueOf(location.getWard()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("wardCode")) {
			sb.append("'");
			sb.append(String.valueOf(location.getWardCode()));
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

	protected Location randomLocation() throws Exception {
		return new Location() {
			{
				district = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				districtCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				isDefault = RandomTestUtil.randomBoolean();
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

	protected Location randomIrrelevantLocation() throws Exception {
		Location randomIrrelevantLocation = randomLocation();

		return randomIrrelevantLocation;
	}

	protected Location randomPatchLocation() throws Exception {
		return randomLocation();
	}

	protected LocationResource locationResource;
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
		LogFactoryUtil.getLog(BaseLocationResourceTestCase.class);

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
	private com.dogoo.dataitems.rest.resource.v2_0.LocationResource
		_locationResource;

}