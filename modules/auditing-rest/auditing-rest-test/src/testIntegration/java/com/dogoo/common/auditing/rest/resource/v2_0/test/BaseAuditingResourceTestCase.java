package com.dogoo.common.auditing.rest.resource.v2_0.test;

import com.dogoo.common.auditing.rest.client.dto.v2_0.Auditing;
import com.dogoo.common.auditing.rest.client.http.HttpInvoker;
import com.dogoo.common.auditing.rest.client.pagination.Page;
import com.dogoo.common.auditing.rest.client.resource.v2_0.AuditingResource;
import com.dogoo.common.auditing.rest.client.serdes.v2_0.AuditingSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

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
public abstract class BaseAuditingResourceTestCase {

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

		_auditingResource.setContextCompany(testCompany);

		AuditingResource.Builder builder = AuditingResource.builder();

		auditingResource = builder.authentication(
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

		Auditing auditing1 = randomAuditing();

		String json = objectMapper.writeValueAsString(auditing1);

		Auditing auditing2 = AuditingSerDes.toDTO(json);

		Assert.assertTrue(equals(auditing1, auditing2));
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

		Auditing auditing = randomAuditing();

		String json1 = objectMapper.writeValueAsString(auditing);
		String json2 = AuditingSerDes.toJSON(auditing);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Auditing auditing = randomAuditing();

		auditing.setCreator(regex);
		auditing.setEventType(regex);
		auditing.setExternalReferenceCode(regex);
		auditing.setMessage(regex);
		auditing.setName(regex);
		auditing.setPayload(regex);

		String json = AuditingSerDes.toJSON(auditing);

		Assert.assertFalse(json.contains(regex));

		auditing = AuditingSerDes.toDTO(json);

		Assert.assertEquals(regex, auditing.getCreator());
		Assert.assertEquals(regex, auditing.getEventType());
		Assert.assertEquals(regex, auditing.getExternalReferenceCode());
		Assert.assertEquals(regex, auditing.getMessage());
		Assert.assertEquals(regex, auditing.getName());
		Assert.assertEquals(regex, auditing.getPayload());
	}

	@Test
	public void testGetAuditings() throws Exception {
		Page<Auditing> page = auditingResource.getAuditings(
			null, RandomTestUtil.randomString(), RandomTestUtil.nextDate(),
			RandomTestUtil.nextDate(), null);

		long totalCount = page.getTotalCount();

		Auditing auditing1 = testGetAuditings_addAuditing(randomAuditing());

		Auditing auditing2 = testGetAuditings_addAuditing(randomAuditing());

		page = auditingResource.getAuditings(null, null, null, null, null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(auditing1, (List<Auditing>)page.getItems());
		assertContains(auditing2, (List<Auditing>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAuditingsWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Auditing auditing1 = randomAuditing();

		auditing1 = testGetAuditings_addAuditing(auditing1);

		for (EntityField entityField : entityFields) {
			Page<Auditing> page = auditingResource.getAuditings(
				null, null, null, null,
				getFilterString(entityField, "between", auditing1));

			assertEquals(
				Collections.singletonList(auditing1),
				(List<Auditing>)page.getItems());
		}
	}

	@Test
	public void testGetAuditingsWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Auditing auditing1 = testGetAuditings_addAuditing(randomAuditing());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Auditing auditing2 = testGetAuditings_addAuditing(randomAuditing());

		for (EntityField entityField : entityFields) {
			Page<Auditing> page = auditingResource.getAuditings(
				null, null, null, null,
				getFilterString(entityField, "eq", auditing1));

			assertEquals(
				Collections.singletonList(auditing1),
				(List<Auditing>)page.getItems());
		}
	}

	protected Auditing testGetAuditings_addAuditing(Auditing auditing)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetAuditings() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"auditings",
			new HashMap<String, Object>() {
				{
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject auditingsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/auditings");

		long totalCount = auditingsJSONObject.getLong("totalCount");

		Auditing auditing1 = testGraphQLAuditing_addAuditing();
		Auditing auditing2 = testGraphQLAuditing_addAuditing();

		auditingsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/auditings");

		Assert.assertEquals(
			totalCount + 2, auditingsJSONObject.getLong("totalCount"));

		assertContains(
			auditing1,
			Arrays.asList(
				AuditingSerDes.toDTOs(auditingsJSONObject.getString("items"))));
		assertContains(
			auditing2,
			Arrays.asList(
				AuditingSerDes.toDTOs(auditingsJSONObject.getString("items"))));
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Auditing testGraphQLAuditing_addAuditing() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Auditing auditing, List<Auditing> auditings) {
		boolean contains = false;

		for (Auditing item : auditings) {
			if (equals(auditing, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			auditings + " does not contain " + auditing, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Auditing auditing1, Auditing auditing2) {
		Assert.assertTrue(
			auditing1 + " does not equal " + auditing2,
			equals(auditing1, auditing2));
	}

	protected void assertEquals(
		List<Auditing> auditings1, List<Auditing> auditings2) {

		Assert.assertEquals(auditings1.size(), auditings2.size());

		for (int i = 0; i < auditings1.size(); i++) {
			Auditing auditing1 = auditings1.get(i);
			Auditing auditing2 = auditings2.get(i);

			assertEquals(auditing1, auditing2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Auditing> auditings1, List<Auditing> auditings2) {

		Assert.assertEquals(auditings1.size(), auditings2.size());

		for (Auditing auditing1 : auditings1) {
			boolean contains = false;

			for (Auditing auditing2 : auditings2) {
				if (equals(auditing1, auditing2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				auditings2 + " does not contain " + auditing1, contains);
		}
	}

	protected void assertValid(Auditing auditing) throws Exception {
		boolean valid = true;

		if (auditing.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (auditing.getCreator() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (auditing.getDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("eventType", additionalAssertFieldName)) {
				if (auditing.getEventType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (auditing.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("message", additionalAssertFieldName)) {
				if (auditing.getMessage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (auditing.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("payload", additionalAssertFieldName)) {
				if (auditing.getPayload() == null) {
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

	protected void assertValid(Page<Auditing> page) {
		boolean valid = false;

		java.util.Collection<Auditing> auditings = page.getItems();

		int size = auditings.size();

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
					com.dogoo.common.auditing.rest.dto.v2_0.Auditing.class)) {

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

	protected boolean equals(Auditing auditing1, Auditing auditing2) {
		if (auditing1 == auditing2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditing1.getCreator(), auditing2.getCreator())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditing1.getDate(), auditing2.getDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("eventType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditing1.getEventType(), auditing2.getEventType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						auditing1.getExternalReferenceCode(),
						auditing2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(auditing1.getId(), auditing2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("message", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditing1.getMessage(), auditing2.getMessage())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditing1.getName(), auditing2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("payload", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						auditing1.getPayload(), auditing2.getPayload())) {

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

		if (!(_auditingResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_auditingResource;

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
		EntityField entityField, String operator, Auditing auditing) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("creator")) {
			sb.append("'");
			sb.append(String.valueOf(auditing.getCreator()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("date")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(auditing.getDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(auditing.getDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(auditing.getDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("eventType")) {
			sb.append("'");
			sb.append(String.valueOf(auditing.getEventType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(auditing.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("message")) {
			sb.append("'");
			sb.append(String.valueOf(auditing.getMessage()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(auditing.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("payload")) {
			sb.append("'");
			sb.append(String.valueOf(auditing.getPayload()));
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

	protected Auditing randomAuditing() throws Exception {
		return new Auditing() {
			{
				creator = StringUtil.toLowerCase(RandomTestUtil.randomString());
				date = RandomTestUtil.nextDate();
				eventType = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				message = StringUtil.toLowerCase(RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				payload = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Auditing randomIrrelevantAuditing() throws Exception {
		Auditing randomIrrelevantAuditing = randomAuditing();

		return randomIrrelevantAuditing;
	}

	protected Auditing randomPatchAuditing() throws Exception {
		return randomAuditing();
	}

	protected AuditingResource auditingResource;
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
		LogFactoryUtil.getLog(BaseAuditingResourceTestCase.class);

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
	private com.dogoo.common.auditing.rest.resource.v2_0.AuditingResource
		_auditingResource;

}