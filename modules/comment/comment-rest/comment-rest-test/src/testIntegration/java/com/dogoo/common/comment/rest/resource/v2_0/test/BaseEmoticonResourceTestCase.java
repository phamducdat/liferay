package com.dogoo.common.comment.rest.resource.v2_0.test;

import com.dogoo.common.comment.rest.client.dto.v2_0.Emoticon;
import com.dogoo.common.comment.rest.client.http.HttpInvoker;
import com.dogoo.common.comment.rest.client.pagination.Page;
import com.dogoo.common.comment.rest.client.resource.v2_0.EmoticonResource;
import com.dogoo.common.comment.rest.client.serdes.v2_0.EmoticonSerDes;

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
public abstract class BaseEmoticonResourceTestCase {

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

		_emoticonResource.setContextCompany(testCompany);

		EmoticonResource.Builder builder = EmoticonResource.builder();

		emoticonResource = builder.authentication(
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

		Emoticon emoticon1 = randomEmoticon();

		String json = objectMapper.writeValueAsString(emoticon1);

		Emoticon emoticon2 = EmoticonSerDes.toDTO(json);

		Assert.assertTrue(equals(emoticon1, emoticon2));
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

		Emoticon emoticon = randomEmoticon();

		String json1 = objectMapper.writeValueAsString(emoticon);
		String json2 = EmoticonSerDes.toJSON(emoticon);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Emoticon emoticon = randomEmoticon();

		emoticon.setClassPkName(regex);
		emoticon.setCreatorUserName(regex);
		emoticon.setEmoji(regex);

		String json = EmoticonSerDes.toJSON(emoticon);

		Assert.assertFalse(json.contains(regex));

		emoticon = EmoticonSerDes.toDTO(json);

		Assert.assertEquals(regex, emoticon.getClassPkName());
		Assert.assertEquals(regex, emoticon.getCreatorUserName());
		Assert.assertEquals(regex, emoticon.getEmoji());
	}

	@Test
	public void testGetEmoticons() throws Exception {
		Page<Emoticon> page = emoticonResource.getEmoticons(
			null, RandomTestUtil.randomString());

		long totalCount = page.getTotalCount();

		Emoticon emoticon1 = testGetEmoticons_addEmoticon(randomEmoticon());

		Emoticon emoticon2 = testGetEmoticons_addEmoticon(randomEmoticon());

		page = emoticonResource.getEmoticons(null, null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(emoticon1, (List<Emoticon>)page.getItems());
		assertContains(emoticon2, (List<Emoticon>)page.getItems());
		assertValid(page);
	}

	protected Emoticon testGetEmoticons_addEmoticon(Emoticon emoticon)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetEmoticons() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPostEmoticon() throws Exception {
		Emoticon randomEmoticon = randomEmoticon();

		Emoticon postEmoticon = testPostEmoticon_addEmoticon(randomEmoticon);

		assertEquals(randomEmoticon, postEmoticon);
		assertValid(postEmoticon);
	}

	protected Emoticon testPostEmoticon_addEmoticon(Emoticon emoticon)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteEmoticon() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteEmoticon() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetEmoticon() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetEmoticon() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetEmoticonNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutEmoticon() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetEmoticonByUser() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetEmoticonByUser() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetEmoticonByUserNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertContains(Emoticon emoticon, List<Emoticon> emoticons) {
		boolean contains = false;

		for (Emoticon item : emoticons) {
			if (equals(emoticon, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			emoticons + " does not contain " + emoticon, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Emoticon emoticon1, Emoticon emoticon2) {
		Assert.assertTrue(
			emoticon1 + " does not equal " + emoticon2,
			equals(emoticon1, emoticon2));
	}

	protected void assertEquals(
		List<Emoticon> emoticons1, List<Emoticon> emoticons2) {

		Assert.assertEquals(emoticons1.size(), emoticons2.size());

		for (int i = 0; i < emoticons1.size(); i++) {
			Emoticon emoticon1 = emoticons1.get(i);
			Emoticon emoticon2 = emoticons2.get(i);

			assertEquals(emoticon1, emoticon2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Emoticon> emoticons1, List<Emoticon> emoticons2) {

		Assert.assertEquals(emoticons1.size(), emoticons2.size());

		for (Emoticon emoticon1 : emoticons1) {
			boolean contains = false;

			for (Emoticon emoticon2 : emoticons2) {
				if (equals(emoticon1, emoticon2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				emoticons2 + " does not contain " + emoticon1, contains);
		}
	}

	protected void assertValid(Emoticon emoticon) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("classPkId", additionalAssertFieldName)) {
				if (emoticon.getClassPkId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("classPkName", additionalAssertFieldName)) {
				if (emoticon.getClassPkName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("creatorUserName", additionalAssertFieldName)) {
				if (emoticon.getCreatorUserName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("cretorUserId", additionalAssertFieldName)) {
				if (emoticon.getCretorUserId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("emoji", additionalAssertFieldName)) {
				if (emoticon.getEmoji() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("emoticonId", additionalAssertFieldName)) {
				if (emoticon.getEmoticonId() == null) {
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

	protected void assertValid(Page<Emoticon> page) {
		boolean valid = false;

		java.util.Collection<Emoticon> emoticons = page.getItems();

		int size = emoticons.size();

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
					com.dogoo.common.comment.rest.dto.v2_0.Emoticon.class)) {

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

	protected boolean equals(Emoticon emoticon1, Emoticon emoticon2) {
		if (emoticon1 == emoticon2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("classPkId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						emoticon1.getClassPkId(), emoticon2.getClassPkId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("classPkName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						emoticon1.getClassPkName(),
						emoticon2.getClassPkName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("creatorUserName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						emoticon1.getCreatorUserName(),
						emoticon2.getCreatorUserName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("cretorUserId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						emoticon1.getCretorUserId(),
						emoticon2.getCretorUserId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("emoji", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						emoticon1.getEmoji(), emoticon2.getEmoji())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("emoticonId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						emoticon1.getEmoticonId(), emoticon2.getEmoticonId())) {

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

		if (!(_emoticonResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_emoticonResource;

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
		EntityField entityField, String operator, Emoticon emoticon) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("classPkId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("classPkName")) {
			sb.append("'");
			sb.append(String.valueOf(emoticon.getClassPkName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("creatorUserName")) {
			sb.append("'");
			sb.append(String.valueOf(emoticon.getCreatorUserName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("cretorUserId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("emoji")) {
			sb.append("'");
			sb.append(String.valueOf(emoticon.getEmoji()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("emoticonId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
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

	protected Emoticon randomEmoticon() throws Exception {
		return new Emoticon() {
			{
				classPkId = RandomTestUtil.randomLong();
				classPkName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				creatorUserName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				cretorUserId = RandomTestUtil.randomLong();
				emoji = StringUtil.toLowerCase(RandomTestUtil.randomString());
				emoticonId = RandomTestUtil.randomLong();
			}
		};
	}

	protected Emoticon randomIrrelevantEmoticon() throws Exception {
		Emoticon randomIrrelevantEmoticon = randomEmoticon();

		return randomIrrelevantEmoticon;
	}

	protected Emoticon randomPatchEmoticon() throws Exception {
		return randomEmoticon();
	}

	protected EmoticonResource emoticonResource;
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
		LogFactoryUtil.getLog(BaseEmoticonResourceTestCase.class);

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
	private com.dogoo.common.comment.rest.resource.v2_0.EmoticonResource
		_emoticonResource;

}