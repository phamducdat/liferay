package com.dogoo.common.comment.rest.resource.v2_0.test;

import com.dogoo.common.comment.rest.client.dto.v2_0.TreeComment;
import com.dogoo.common.comment.rest.client.http.HttpInvoker;
import com.dogoo.common.comment.rest.client.pagination.Page;
import com.dogoo.common.comment.rest.client.resource.v2_0.TreeCommentResource;
import com.dogoo.common.comment.rest.client.serdes.v2_0.TreeCommentSerDes;

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
public abstract class BaseTreeCommentResourceTestCase {

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

		_treeCommentResource.setContextCompany(testCompany);

		TreeCommentResource.Builder builder = TreeCommentResource.builder();

		treeCommentResource = builder.authentication(
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

		TreeComment treeComment1 = randomTreeComment();

		String json = objectMapper.writeValueAsString(treeComment1);

		TreeComment treeComment2 = TreeCommentSerDes.toDTO(json);

		Assert.assertTrue(equals(treeComment1, treeComment2));
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

		TreeComment treeComment = randomTreeComment();

		String json1 = objectMapper.writeValueAsString(treeComment);
		String json2 = TreeCommentSerDes.toJSON(treeComment);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		TreeComment treeComment = randomTreeComment();

		treeComment.setClassPkName(regex);
		treeComment.setContent(regex);
		treeComment.setCreateDateNow(regex);
		treeComment.setCreatorUserName(regex);
		treeComment.setExternalReferenceCode(regex);

		String json = TreeCommentSerDes.toJSON(treeComment);

		Assert.assertFalse(json.contains(regex));

		treeComment = TreeCommentSerDes.toDTO(json);

		Assert.assertEquals(regex, treeComment.getClassPkName());
		Assert.assertEquals(regex, treeComment.getContent());
		Assert.assertEquals(regex, treeComment.getCreateDateNow());
		Assert.assertEquals(regex, treeComment.getCreatorUserName());
		Assert.assertEquals(regex, treeComment.getExternalReferenceCode());
	}

	@Test
	public void testGetAllTreeComment() throws Exception {
		Page<TreeComment> page = treeCommentResource.getAllTreeComment(
			null, RandomTestUtil.randomString(), null);

		long totalCount = page.getTotalCount();

		TreeComment treeComment1 = testGetAllTreeComment_addTreeComment(
			randomTreeComment());

		TreeComment treeComment2 = testGetAllTreeComment_addTreeComment(
			randomTreeComment());

		page = treeCommentResource.getAllTreeComment(null, null, null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(treeComment1, (List<TreeComment>)page.getItems());
		assertContains(treeComment2, (List<TreeComment>)page.getItems());
		assertValid(page);
	}

	protected TreeComment testGetAllTreeComment_addTreeComment(
			TreeComment treeComment)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		TreeComment treeComment, List<TreeComment> treeComments) {

		boolean contains = false;

		for (TreeComment item : treeComments) {
			if (equals(treeComment, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			treeComments + " does not contain " + treeComment, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		TreeComment treeComment1, TreeComment treeComment2) {

		Assert.assertTrue(
			treeComment1 + " does not equal " + treeComment2,
			equals(treeComment1, treeComment2));
	}

	protected void assertEquals(
		List<TreeComment> treeComments1, List<TreeComment> treeComments2) {

		Assert.assertEquals(treeComments1.size(), treeComments2.size());

		for (int i = 0; i < treeComments1.size(); i++) {
			TreeComment treeComment1 = treeComments1.get(i);
			TreeComment treeComment2 = treeComments2.get(i);

			assertEquals(treeComment1, treeComment2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<TreeComment> treeComments1, List<TreeComment> treeComments2) {

		Assert.assertEquals(treeComments1.size(), treeComments2.size());

		for (TreeComment treeComment1 : treeComments1) {
			boolean contains = false;

			for (TreeComment treeComment2 : treeComments2) {
				if (equals(treeComment1, treeComment2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				treeComments2 + " does not contain " + treeComment1, contains);
		}
	}

	protected void assertValid(TreeComment treeComment) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("classPkId", additionalAssertFieldName)) {
				if (treeComment.getClassPkId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("classPkName", additionalAssertFieldName)) {
				if (treeComment.getClassPkName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("commentId", additionalAssertFieldName)) {
				if (treeComment.getCommentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("content", additionalAssertFieldName)) {
				if (treeComment.getContent() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createDateNow", additionalAssertFieldName)) {
				if (treeComment.getCreateDateNow() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("creatorUserId", additionalAssertFieldName)) {
				if (treeComment.getCreatorUserId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("creatorUserName", additionalAssertFieldName)) {
				if (treeComment.getCreatorUserName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (treeComment.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (treeComment.getParentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("treeComments", additionalAssertFieldName)) {
				if (treeComment.getTreeComments() == null) {
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

	protected void assertValid(Page<TreeComment> page) {
		boolean valid = false;

		java.util.Collection<TreeComment> treeComments = page.getItems();

		int size = treeComments.size();

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
					com.dogoo.common.comment.rest.dto.v2_0.TreeComment.class)) {

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

	protected boolean equals(
		TreeComment treeComment1, TreeComment treeComment2) {

		if (treeComment1 == treeComment2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("classPkId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						treeComment1.getClassPkId(),
						treeComment2.getClassPkId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("classPkName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						treeComment1.getClassPkName(),
						treeComment2.getClassPkName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("commentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						treeComment1.getCommentId(),
						treeComment2.getCommentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("content", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						treeComment1.getContent(), treeComment2.getContent())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createDateNow", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						treeComment1.getCreateDateNow(),
						treeComment2.getCreateDateNow())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("creatorUserId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						treeComment1.getCreatorUserId(),
						treeComment2.getCreatorUserId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("creatorUserName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						treeComment1.getCreatorUserName(),
						treeComment2.getCreatorUserName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						treeComment1.getExternalReferenceCode(),
						treeComment2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						treeComment1.getParentId(),
						treeComment2.getParentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("treeComments", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						treeComment1.getTreeComments(),
						treeComment2.getTreeComments())) {

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

		if (!(_treeCommentResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_treeCommentResource;

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
		EntityField entityField, String operator, TreeComment treeComment) {

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
			sb.append(String.valueOf(treeComment.getClassPkName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("commentId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("content")) {
			sb.append("'");
			sb.append(String.valueOf(treeComment.getContent()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("createDateNow")) {
			sb.append("'");
			sb.append(String.valueOf(treeComment.getCreateDateNow()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("creatorUserId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("creatorUserName")) {
			sb.append("'");
			sb.append(String.valueOf(treeComment.getCreatorUserName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(treeComment.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("parentId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("treeComments")) {
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

	protected TreeComment randomTreeComment() throws Exception {
		return new TreeComment() {
			{
				classPkId = RandomTestUtil.randomLong();
				classPkName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				commentId = RandomTestUtil.randomLong();
				content = StringUtil.toLowerCase(RandomTestUtil.randomString());
				createDateNow = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				creatorUserId = RandomTestUtil.randomLong();
				creatorUserName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				parentId = RandomTestUtil.randomLong();
			}
		};
	}

	protected TreeComment randomIrrelevantTreeComment() throws Exception {
		TreeComment randomIrrelevantTreeComment = randomTreeComment();

		return randomIrrelevantTreeComment;
	}

	protected TreeComment randomPatchTreeComment() throws Exception {
		return randomTreeComment();
	}

	protected TreeCommentResource treeCommentResource;
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
		LogFactoryUtil.getLog(BaseTreeCommentResourceTestCase.class);

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
	private com.dogoo.common.comment.rest.resource.v2_0.TreeCommentResource
		_treeCommentResource;

}