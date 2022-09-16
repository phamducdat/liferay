package com.dogoo.common.api.rest.resource.v2_0.test;

import com.dogoo.common.api.rest.client.dto.v2_0.EmployeeReference;
import com.dogoo.common.api.rest.client.http.HttpInvoker;
import com.dogoo.common.api.rest.client.pagination.Page;
import com.dogoo.common.api.rest.client.pagination.Pagination;
import com.dogoo.common.api.rest.client.resource.v2_0.EmployeeReferenceResource;
import com.dogoo.common.api.rest.client.serdes.v2_0.EmployeeReferenceSerDes;

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
public abstract class BaseEmployeeReferenceResourceTestCase {

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

		_employeeReferenceResource.setContextCompany(testCompany);

		EmployeeReferenceResource.Builder builder =
			EmployeeReferenceResource.builder();

		employeeReferenceResource = builder.authentication(
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

		EmployeeReference employeeReference1 = randomEmployeeReference();

		String json = objectMapper.writeValueAsString(employeeReference1);

		EmployeeReference employeeReference2 = EmployeeReferenceSerDes.toDTO(
			json);

		Assert.assertTrue(equals(employeeReference1, employeeReference2));
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

		EmployeeReference employeeReference = randomEmployeeReference();

		String json1 = objectMapper.writeValueAsString(employeeReference);
		String json2 = EmployeeReferenceSerDes.toJSON(employeeReference);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		EmployeeReference employeeReference = randomEmployeeReference();

		employeeReference.setExternalReferenceCode(regex);
		employeeReference.setName(regex);

		String json = EmployeeReferenceSerDes.toJSON(employeeReference);

		Assert.assertFalse(json.contains(regex));

		employeeReference = EmployeeReferenceSerDes.toDTO(json);

		Assert.assertEquals(
			regex, employeeReference.getExternalReferenceCode());
		Assert.assertEquals(regex, employeeReference.getName());
	}

	@Test
	public void testGetEmployeeReferencesPage() throws Exception {
		Page<EmployeeReference> page =
			employeeReferenceResource.getEmployeeReferencesPage(
				null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		EmployeeReference employeeReference1 =
			testGetEmployeeReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		EmployeeReference employeeReference2 =
			testGetEmployeeReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		page = employeeReferenceResource.getEmployeeReferencesPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			employeeReference1, (List<EmployeeReference>)page.getItems());
		assertContains(
			employeeReference2, (List<EmployeeReference>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetEmployeeReferencesPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		EmployeeReference employeeReference1 = randomEmployeeReference();

		employeeReference1 = testGetEmployeeReferencesPage_addEmployeeReference(
			employeeReference1);

		for (EntityField entityField : entityFields) {
			Page<EmployeeReference> page =
				employeeReferenceResource.getEmployeeReferencesPage(
					null,
					getFilterString(entityField, "between", employeeReference1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(employeeReference1),
				(List<EmployeeReference>)page.getItems());
		}
	}

	@Test
	public void testGetEmployeeReferencesPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		EmployeeReference employeeReference1 =
			testGetEmployeeReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		EmployeeReference employeeReference2 =
			testGetEmployeeReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		for (EntityField entityField : entityFields) {
			Page<EmployeeReference> page =
				employeeReferenceResource.getEmployeeReferencesPage(
					null,
					getFilterString(entityField, "eq", employeeReference1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(employeeReference1),
				(List<EmployeeReference>)page.getItems());
		}
	}

	@Test
	public void testGetEmployeeReferencesPageWithPagination() throws Exception {
		Page<EmployeeReference> totalPage =
			employeeReferenceResource.getEmployeeReferencesPage(
				null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		EmployeeReference employeeReference1 =
			testGetEmployeeReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		EmployeeReference employeeReference2 =
			testGetEmployeeReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		EmployeeReference employeeReference3 =
			testGetEmployeeReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		Page<EmployeeReference> page1 =
			employeeReferenceResource.getEmployeeReferencesPage(
				null, null, Pagination.of(1, totalCount + 2), null);

		List<EmployeeReference> employeeReferences1 =
			(List<EmployeeReference>)page1.getItems();

		Assert.assertEquals(
			employeeReferences1.toString(), totalCount + 2,
			employeeReferences1.size());

		Page<EmployeeReference> page2 =
			employeeReferenceResource.getEmployeeReferencesPage(
				null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<EmployeeReference> employeeReferences2 =
			(List<EmployeeReference>)page2.getItems();

		Assert.assertEquals(
			employeeReferences2.toString(), 1, employeeReferences2.size());

		Page<EmployeeReference> page3 =
			employeeReferenceResource.getEmployeeReferencesPage(
				null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(
			employeeReference1, (List<EmployeeReference>)page3.getItems());
		assertContains(
			employeeReference2, (List<EmployeeReference>)page3.getItems());
		assertContains(
			employeeReference3, (List<EmployeeReference>)page3.getItems());
	}

	@Test
	public void testGetEmployeeReferencesPageWithSortDateTime()
		throws Exception {

		testGetEmployeeReferencesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, employeeReference1, employeeReference2) -> {
				BeanUtils.setProperty(
					employeeReference1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetEmployeeReferencesPageWithSortInteger()
		throws Exception {

		testGetEmployeeReferencesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, employeeReference1, employeeReference2) -> {
				BeanUtils.setProperty(
					employeeReference1, entityField.getName(), 0);
				BeanUtils.setProperty(
					employeeReference2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetEmployeeReferencesPageWithSortString() throws Exception {
		testGetEmployeeReferencesPageWithSort(
			EntityField.Type.STRING,
			(entityField, employeeReference1, employeeReference2) -> {
				Class<?> clazz = employeeReference1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						employeeReference1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						employeeReference2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						employeeReference1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						employeeReference2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						employeeReference1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						employeeReference2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetEmployeeReferencesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer
				<EntityField, EmployeeReference, EmployeeReference, Exception>
					unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		EmployeeReference employeeReference1 = randomEmployeeReference();
		EmployeeReference employeeReference2 = randomEmployeeReference();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(
				entityField, employeeReference1, employeeReference2);
		}

		employeeReference1 = testGetEmployeeReferencesPage_addEmployeeReference(
			employeeReference1);

		employeeReference2 = testGetEmployeeReferencesPage_addEmployeeReference(
			employeeReference2);

		for (EntityField entityField : entityFields) {
			Page<EmployeeReference> ascPage =
				employeeReferenceResource.getEmployeeReferencesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(employeeReference1, employeeReference2),
				(List<EmployeeReference>)ascPage.getItems());

			Page<EmployeeReference> descPage =
				employeeReferenceResource.getEmployeeReferencesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(employeeReference2, employeeReference1),
				(List<EmployeeReference>)descPage.getItems());
		}
	}

	protected EmployeeReference
			testGetEmployeeReferencesPage_addEmployeeReference(
				EmployeeReference employeeReference)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetEmployeeReferencesPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"employeeReferences",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject employeeReferencesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/employeeReferences");

		long totalCount = employeeReferencesJSONObject.getLong("totalCount");

		EmployeeReference employeeReference1 =
			testGraphQLEmployeeReference_addEmployeeReference();
		EmployeeReference employeeReference2 =
			testGraphQLEmployeeReference_addEmployeeReference();

		employeeReferencesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/employeeReferences");

		Assert.assertEquals(
			totalCount + 2, employeeReferencesJSONObject.getLong("totalCount"));

		assertContains(
			employeeReference1,
			Arrays.asList(
				EmployeeReferenceSerDes.toDTOs(
					employeeReferencesJSONObject.getString("items"))));
		assertContains(
			employeeReference2,
			Arrays.asList(
				EmployeeReferenceSerDes.toDTOs(
					employeeReferencesJSONObject.getString("items"))));
	}

	@Test
	public void testGetEmployeeExternalReferencesPage() throws Exception {
		Page<EmployeeReference> page =
			employeeReferenceResource.getEmployeeExternalReferencesPage(
				null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		EmployeeReference employeeReference1 =
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		EmployeeReference employeeReference2 =
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		page = employeeReferenceResource.getEmployeeExternalReferencesPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			employeeReference1, (List<EmployeeReference>)page.getItems());
		assertContains(
			employeeReference2, (List<EmployeeReference>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetEmployeeExternalReferencesPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		EmployeeReference employeeReference1 = randomEmployeeReference();

		employeeReference1 =
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				employeeReference1);

		for (EntityField entityField : entityFields) {
			Page<EmployeeReference> page =
				employeeReferenceResource.getEmployeeExternalReferencesPage(
					null,
					getFilterString(entityField, "between", employeeReference1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(employeeReference1),
				(List<EmployeeReference>)page.getItems());
		}
	}

	@Test
	public void testGetEmployeeExternalReferencesPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		EmployeeReference employeeReference1 =
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		EmployeeReference employeeReference2 =
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		for (EntityField entityField : entityFields) {
			Page<EmployeeReference> page =
				employeeReferenceResource.getEmployeeExternalReferencesPage(
					null,
					getFilterString(entityField, "eq", employeeReference1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(employeeReference1),
				(List<EmployeeReference>)page.getItems());
		}
	}

	@Test
	public void testGetEmployeeExternalReferencesPageWithPagination()
		throws Exception {

		Page<EmployeeReference> totalPage =
			employeeReferenceResource.getEmployeeExternalReferencesPage(
				null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		EmployeeReference employeeReference1 =
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		EmployeeReference employeeReference2 =
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		EmployeeReference employeeReference3 =
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				randomEmployeeReference());

		Page<EmployeeReference> page1 =
			employeeReferenceResource.getEmployeeExternalReferencesPage(
				null, null, Pagination.of(1, totalCount + 2), null);

		List<EmployeeReference> employeeReferences1 =
			(List<EmployeeReference>)page1.getItems();

		Assert.assertEquals(
			employeeReferences1.toString(), totalCount + 2,
			employeeReferences1.size());

		Page<EmployeeReference> page2 =
			employeeReferenceResource.getEmployeeExternalReferencesPage(
				null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<EmployeeReference> employeeReferences2 =
			(List<EmployeeReference>)page2.getItems();

		Assert.assertEquals(
			employeeReferences2.toString(), 1, employeeReferences2.size());

		Page<EmployeeReference> page3 =
			employeeReferenceResource.getEmployeeExternalReferencesPage(
				null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(
			employeeReference1, (List<EmployeeReference>)page3.getItems());
		assertContains(
			employeeReference2, (List<EmployeeReference>)page3.getItems());
		assertContains(
			employeeReference3, (List<EmployeeReference>)page3.getItems());
	}

	@Test
	public void testGetEmployeeExternalReferencesPageWithSortDateTime()
		throws Exception {

		testGetEmployeeExternalReferencesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, employeeReference1, employeeReference2) -> {
				BeanUtils.setProperty(
					employeeReference1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetEmployeeExternalReferencesPageWithSortInteger()
		throws Exception {

		testGetEmployeeExternalReferencesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, employeeReference1, employeeReference2) -> {
				BeanUtils.setProperty(
					employeeReference1, entityField.getName(), 0);
				BeanUtils.setProperty(
					employeeReference2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetEmployeeExternalReferencesPageWithSortString()
		throws Exception {

		testGetEmployeeExternalReferencesPageWithSort(
			EntityField.Type.STRING,
			(entityField, employeeReference1, employeeReference2) -> {
				Class<?> clazz = employeeReference1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						employeeReference1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						employeeReference2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						employeeReference1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						employeeReference2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						employeeReference1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						employeeReference2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetEmployeeExternalReferencesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer
				<EntityField, EmployeeReference, EmployeeReference, Exception>
					unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		EmployeeReference employeeReference1 = randomEmployeeReference();
		EmployeeReference employeeReference2 = randomEmployeeReference();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(
				entityField, employeeReference1, employeeReference2);
		}

		employeeReference1 =
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				employeeReference1);

		employeeReference2 =
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				employeeReference2);

		for (EntityField entityField : entityFields) {
			Page<EmployeeReference> ascPage =
				employeeReferenceResource.getEmployeeExternalReferencesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(employeeReference1, employeeReference2),
				(List<EmployeeReference>)ascPage.getItems());

			Page<EmployeeReference> descPage =
				employeeReferenceResource.getEmployeeExternalReferencesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(employeeReference2, employeeReference1),
				(List<EmployeeReference>)descPage.getItems());
		}
	}

	protected EmployeeReference
			testGetEmployeeExternalReferencesPage_addEmployeeReference(
				EmployeeReference employeeReference)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected EmployeeReference
			testGraphQLEmployeeReference_addEmployeeReference()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		EmployeeReference employeeReference,
		List<EmployeeReference> employeeReferences) {

		boolean contains = false;

		for (EmployeeReference item : employeeReferences) {
			if (equals(employeeReference, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			employeeReferences + " does not contain " + employeeReference,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		EmployeeReference employeeReference1,
		EmployeeReference employeeReference2) {

		Assert.assertTrue(
			employeeReference1 + " does not equal " + employeeReference2,
			equals(employeeReference1, employeeReference2));
	}

	protected void assertEquals(
		List<EmployeeReference> employeeReferences1,
		List<EmployeeReference> employeeReferences2) {

		Assert.assertEquals(
			employeeReferences1.size(), employeeReferences2.size());

		for (int i = 0; i < employeeReferences1.size(); i++) {
			EmployeeReference employeeReference1 = employeeReferences1.get(i);
			EmployeeReference employeeReference2 = employeeReferences2.get(i);

			assertEquals(employeeReference1, employeeReference2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<EmployeeReference> employeeReferences1,
		List<EmployeeReference> employeeReferences2) {

		Assert.assertEquals(
			employeeReferences1.size(), employeeReferences2.size());

		for (EmployeeReference employeeReference1 : employeeReferences1) {
			boolean contains = false;

			for (EmployeeReference employeeReference2 : employeeReferences2) {
				if (equals(employeeReference1, employeeReference2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				employeeReferences2 + " does not contain " + employeeReference1,
				contains);
		}
	}

	protected void assertValid(EmployeeReference employeeReference)
		throws Exception {

		boolean valid = true;

		if (employeeReference.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (employeeReference.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (employeeReference.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (employeeReference.getType() == null) {
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

	protected void assertValid(Page<EmployeeReference> page) {
		boolean valid = false;

		java.util.Collection<EmployeeReference> employeeReferences =
			page.getItems();

		int size = employeeReferences.size();

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
					com.dogoo.common.api.rest.dto.v2_0.EmployeeReference.
						class)) {

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
		EmployeeReference employeeReference1,
		EmployeeReference employeeReference2) {

		if (employeeReference1 == employeeReference2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						employeeReference1.getExternalReferenceCode(),
						employeeReference2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeReference1.getId(),
						employeeReference2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeReference1.getName(),
						employeeReference2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeReference1.getType(),
						employeeReference2.getType())) {

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

		if (!(_employeeReferenceResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_employeeReferenceResource;

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
		EntityField entityField, String operator,
		EmployeeReference employeeReference) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(
				String.valueOf(employeeReference.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(employeeReference.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("type")) {
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

	protected EmployeeReference randomEmployeeReference() throws Exception {
		return new EmployeeReference() {
			{
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected EmployeeReference randomIrrelevantEmployeeReference()
		throws Exception {

		EmployeeReference randomIrrelevantEmployeeReference =
			randomEmployeeReference();

		return randomIrrelevantEmployeeReference;
	}

	protected EmployeeReference randomPatchEmployeeReference()
		throws Exception {

		return randomEmployeeReference();
	}

	protected EmployeeReferenceResource employeeReferenceResource;
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
		LogFactoryUtil.getLog(BaseEmployeeReferenceResourceTestCase.class);

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
	private com.dogoo.common.api.rest.resource.v2_0.EmployeeReferenceResource
		_employeeReferenceResource;

}