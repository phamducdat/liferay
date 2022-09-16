package com.dogoo.dataitems.rest.resource.v2_0.test;

import com.dogoo.dataitems.rest.client.dto.v2_0.DataItem;
import com.dogoo.dataitems.rest.client.http.HttpInvoker;
import com.dogoo.dataitems.rest.client.pagination.Page;
import com.dogoo.dataitems.rest.client.resource.v2_0.DataItemResource;
import com.dogoo.dataitems.rest.client.serdes.v2_0.DataItemSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

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
public abstract class BaseDataItemResourceTestCase {

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

		_dataItemResource.setContextCompany(testCompany);

		DataItemResource.Builder builder = DataItemResource.builder();

		dataItemResource = builder.authentication(
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

		DataItem dataItem1 = randomDataItem();

		String json = objectMapper.writeValueAsString(dataItem1);

		DataItem dataItem2 = DataItemSerDes.toDTO(json);

		Assert.assertTrue(equals(dataItem1, dataItem2));
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

		DataItem dataItem = randomDataItem();

		String json1 = objectMapper.writeValueAsString(dataItem);
		String json2 = DataItemSerDes.toJSON(dataItem);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		DataItem dataItem = randomDataItem();

		dataItem.setDescription(regex);
		dataItem.setExternalReferenceCode(regex);
		dataItem.setName(regex);
		dataItem.setType(regex);

		String json = DataItemSerDes.toJSON(dataItem);

		Assert.assertFalse(json.contains(regex));

		dataItem = DataItemSerDes.toDTO(json);

		Assert.assertEquals(regex, dataItem.getDescription());
		Assert.assertEquals(regex, dataItem.getExternalReferenceCode());
		Assert.assertEquals(regex, dataItem.getName());
		Assert.assertEquals(regex, dataItem.getType());
	}

	@Test
	public void testPostInitDataItem() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		DataItem dataItem = testPostInitDataItem_addDataItem();

		assertHttpResponseStatusCode(
			204, dataItemResource.postInitDataItemHttpResponse(null));

		assertHttpResponseStatusCode(
			404, dataItemResource.postInitDataItemHttpResponse(null));
	}

	protected DataItem testPostInitDataItem_addDataItem() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostDataItem() throws Exception {
		DataItem randomDataItem = randomDataItem();

		DataItem postDataItem = testPostDataItem_addDataItem(randomDataItem);

		assertEquals(randomDataItem, postDataItem);
		assertValid(postDataItem);
	}

	protected DataItem testPostDataItem_addDataItem(DataItem dataItem)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteDataItem() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		DataItem dataItem = testDeleteDataItem_addDataItem();

		assertHttpResponseStatusCode(
			204, dataItemResource.deleteDataItemHttpResponse(dataItem.getId()));

		assertHttpResponseStatusCode(
			404, dataItemResource.getDataItemHttpResponse(dataItem.getId()));

		assertHttpResponseStatusCode(
			404, dataItemResource.getDataItemHttpResponse(0L));
	}

	protected DataItem testDeleteDataItem_addDataItem() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteDataItem() throws Exception {
		DataItem dataItem = testGraphQLDataItem_addDataItem();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteDataItem",
						new HashMap<String, Object>() {
							{
								put("dataItemId", dataItem.getId());
							}
						})),
				"JSONObject/data", "Object/deleteDataItem"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"dataItem",
					new HashMap<String, Object>() {
						{
							put("dataItemId", dataItem.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetDataItem() throws Exception {
		DataItem postDataItem = testGetDataItem_addDataItem();

		DataItem getDataItem = dataItemResource.getDataItem(
			postDataItem.getId());

		assertEquals(postDataItem, getDataItem);
		assertValid(getDataItem);
	}

	protected DataItem testGetDataItem_addDataItem() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetDataItem() throws Exception {
		DataItem dataItem = testGraphQLDataItem_addDataItem();

		Assert.assertTrue(
			equals(
				dataItem,
				DataItemSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"dataItem",
								new HashMap<String, Object>() {
									{
										put("dataItemId", dataItem.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/dataItem"))));
	}

	@Test
	public void testGraphQLGetDataItemNotFound() throws Exception {
		Long irrelevantDataItemId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"dataItem",
						new HashMap<String, Object>() {
							{
								put("dataItemId", irrelevantDataItemId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutDataItem() throws Exception {
		DataItem postDataItem = testPutDataItem_addDataItem();

		DataItem randomDataItem = randomDataItem();

		DataItem putDataItem = dataItemResource.putDataItem(
			postDataItem.getId(), randomDataItem);

		assertEquals(randomDataItem, putDataItem);
		assertValid(putDataItem);

		DataItem getDataItem = dataItemResource.getDataItem(
			putDataItem.getId());

		assertEquals(randomDataItem, getDataItem);
		assertValid(getDataItem);
	}

	protected DataItem testPutDataItem_addDataItem() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteDataItemByExternalReferenceCode() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		DataItem dataItem =
			testDeleteDataItemByExternalReferenceCode_addDataItem();

		assertHttpResponseStatusCode(
			204,
			dataItemResource.deleteDataItemByExternalReferenceCodeHttpResponse(
				dataItem.getExternalReferenceCode()));

		assertHttpResponseStatusCode(
			404,
			dataItemResource.getDataItemByExternalReferenceCodeHttpResponse(
				dataItem.getExternalReferenceCode()));

		assertHttpResponseStatusCode(
			404,
			dataItemResource.getDataItemByExternalReferenceCodeHttpResponse(
				dataItem.getExternalReferenceCode()));
	}

	protected DataItem testDeleteDataItemByExternalReferenceCode_addDataItem()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetDataItemByExternalReferenceCode() throws Exception {
		DataItem postDataItem =
			testGetDataItemByExternalReferenceCode_addDataItem();

		DataItem getDataItem =
			dataItemResource.getDataItemByExternalReferenceCode(
				postDataItem.getExternalReferenceCode());

		assertEquals(postDataItem, getDataItem);
		assertValid(getDataItem);
	}

	protected DataItem testGetDataItemByExternalReferenceCode_addDataItem()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetDataItemByExternalReferenceCode()
		throws Exception {

		DataItem dataItem = testGraphQLDataItem_addDataItem();

		Assert.assertTrue(
			equals(
				dataItem,
				DataItemSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"dataItemByExternalReferenceCode",
								new HashMap<String, Object>() {
									{
										put(
											"externalReferenceCode",
											"\"" +
												dataItem.
													getExternalReferenceCode() +
														"\"");
									}
								},
								getGraphQLFields())),
						"JSONObject/data",
						"Object/dataItemByExternalReferenceCode"))));
	}

	@Test
	public void testGraphQLGetDataItemByExternalReferenceCodeNotFound()
		throws Exception {

		String irrelevantExternalReferenceCode =
			"\"" + RandomTestUtil.randomString() + "\"";

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"dataItemByExternalReferenceCode",
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
	public void testPutDataItemByExternalReferenceCode() throws Exception {
		DataItem postDataItem =
			testPutDataItemByExternalReferenceCode_addDataItem();

		DataItem randomDataItem = randomDataItem();

		DataItem putDataItem =
			dataItemResource.putDataItemByExternalReferenceCode(
				postDataItem.getExternalReferenceCode(), randomDataItem);

		assertEquals(randomDataItem, putDataItem);
		assertValid(putDataItem);

		DataItem getDataItem =
			dataItemResource.getDataItemByExternalReferenceCode(
				putDataItem.getExternalReferenceCode());

		assertEquals(randomDataItem, getDataItem);
		assertValid(getDataItem);

		DataItem newDataItem =
			testPutDataItemByExternalReferenceCode_createDataItem();

		putDataItem = dataItemResource.putDataItemByExternalReferenceCode(
			newDataItem.getExternalReferenceCode(), newDataItem);

		assertEquals(newDataItem, putDataItem);
		assertValid(putDataItem);

		getDataItem = dataItemResource.getDataItemByExternalReferenceCode(
			putDataItem.getExternalReferenceCode());

		assertEquals(newDataItem, getDataItem);

		Assert.assertEquals(
			newDataItem.getExternalReferenceCode(),
			putDataItem.getExternalReferenceCode());
	}

	protected DataItem testPutDataItemByExternalReferenceCode_createDataItem()
		throws Exception {

		return randomDataItem();
	}

	protected DataItem testPutDataItemByExternalReferenceCode_addDataItem()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetDataItemByParentCode() throws Exception {
		String type = testGetDataItemByParentCode_getType();
		String irrelevantType = testGetDataItemByParentCode_getIrrelevantType();
		String parentCode = testGetDataItemByParentCode_getParentCode();
		String irrelevantParentCode =
			testGetDataItemByParentCode_getIrrelevantParentCode();

		Page<DataItem> page = dataItemResource.getDataItemByParentCode(
			type, parentCode, null);

		Assert.assertEquals(0, page.getTotalCount());

		if ((irrelevantType != null) && (irrelevantParentCode != null)) {
			DataItem irrelevantDataItem =
				testGetDataItemByParentCode_addDataItem(
					irrelevantType, irrelevantParentCode,
					randomIrrelevantDataItem());

			page = dataItemResource.getDataItemByParentCode(
				irrelevantType, irrelevantParentCode, null);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantDataItem),
				(List<DataItem>)page.getItems());
			assertValid(page);
		}

		DataItem dataItem1 = testGetDataItemByParentCode_addDataItem(
			type, parentCode, randomDataItem());

		DataItem dataItem2 = testGetDataItemByParentCode_addDataItem(
			type, parentCode, randomDataItem());

		page = dataItemResource.getDataItemByParentCode(type, parentCode, null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(dataItem1, dataItem2),
			(List<DataItem>)page.getItems());
		assertValid(page);

		dataItemResource.deleteDataItem(dataItem1.getId());

		dataItemResource.deleteDataItem(dataItem2.getId());
	}

	protected DataItem testGetDataItemByParentCode_addDataItem(
			String type, String parentCode, DataItem dataItem)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetDataItemByParentCode_getType() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetDataItemByParentCode_getIrrelevantType()
		throws Exception {

		return null;
	}

	protected String testGetDataItemByParentCode_getParentCode()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetDataItemByParentCode_getIrrelevantParentCode()
		throws Exception {

		return null;
	}

	protected DataItem testGraphQLDataItem_addDataItem() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(DataItem dataItem, List<DataItem> dataItems) {
		boolean contains = false;

		for (DataItem item : dataItems) {
			if (equals(dataItem, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			dataItems + " does not contain " + dataItem, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(DataItem dataItem1, DataItem dataItem2) {
		Assert.assertTrue(
			dataItem1 + " does not equal " + dataItem2,
			equals(dataItem1, dataItem2));
	}

	protected void assertEquals(
		List<DataItem> dataItems1, List<DataItem> dataItems2) {

		Assert.assertEquals(dataItems1.size(), dataItems2.size());

		for (int i = 0; i < dataItems1.size(); i++) {
			DataItem dataItem1 = dataItems1.get(i);
			DataItem dataItem2 = dataItems2.get(i);

			assertEquals(dataItem1, dataItem2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<DataItem> dataItems1, List<DataItem> dataItems2) {

		Assert.assertEquals(dataItems1.size(), dataItems2.size());

		for (DataItem dataItem1 : dataItems1) {
			boolean contains = false;

			for (DataItem dataItem2 : dataItems2) {
				if (equals(dataItem1, dataItem2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				dataItems2 + " does not contain " + dataItem1, contains);
		}
	}

	protected void assertValid(DataItem dataItem) throws Exception {
		boolean valid = true;

		if (dataItem.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("dataItems", additionalAssertFieldName)) {
				if (dataItem.getDataItems() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (dataItem.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (dataItem.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("isDefault", additionalAssertFieldName)) {
				if (dataItem.getIsDefault() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (dataItem.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("order", additionalAssertFieldName)) {
				if (dataItem.getOrder() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (dataItem.getParentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (dataItem.getType() == null) {
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

	protected void assertValid(Page<DataItem> page) {
		boolean valid = false;

		java.util.Collection<DataItem> dataItems = page.getItems();

		int size = dataItems.size();

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
					com.dogoo.dataitems.rest.dto.v2_0.DataItem.class)) {

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

	protected boolean equals(DataItem dataItem1, DataItem dataItem2) {
		if (dataItem1 == dataItem2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("dataItems", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						dataItem1.getDataItems(), dataItem2.getDataItems())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						dataItem1.getDescription(),
						dataItem2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						dataItem1.getExternalReferenceCode(),
						dataItem2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(dataItem1.getId(), dataItem2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("isDefault", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						dataItem1.getIsDefault(), dataItem2.getIsDefault())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						dataItem1.getName(), dataItem2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("order", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						dataItem1.getOrder(), dataItem2.getOrder())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						dataItem1.getParentId(), dataItem2.getParentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						dataItem1.getType(), dataItem2.getType())) {

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

		if (!(_dataItemResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_dataItemResource;

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
		EntityField entityField, String operator, DataItem dataItem) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("dataItems")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(dataItem.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(dataItem.getExternalReferenceCode()));
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

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(dataItem.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("order")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("parentId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("type")) {
			sb.append("'");
			sb.append(String.valueOf(dataItem.getType()));
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

	protected DataItem randomDataItem() throws Exception {
		return new DataItem() {
			{
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				isDefault = RandomTestUtil.randomBoolean();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				order = RandomTestUtil.randomLong();
				parentId = RandomTestUtil.randomLong();
				type = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected DataItem randomIrrelevantDataItem() throws Exception {
		DataItem randomIrrelevantDataItem = randomDataItem();

		return randomIrrelevantDataItem;
	}

	protected DataItem randomPatchDataItem() throws Exception {
		return randomDataItem();
	}

	protected DataItemResource dataItemResource;
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
		LogFactoryUtil.getLog(BaseDataItemResourceTestCase.class);

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
	private com.dogoo.dataitems.rest.resource.v2_0.DataItemResource
		_dataItemResource;

}