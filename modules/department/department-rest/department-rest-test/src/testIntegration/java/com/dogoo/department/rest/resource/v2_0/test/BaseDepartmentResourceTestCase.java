package com.dogoo.department.rest.resource.v2_0.test;

import com.dogoo.department.rest.client.dto.v2_0.Department;
import com.dogoo.department.rest.client.http.HttpInvoker;
import com.dogoo.department.rest.client.pagination.Page;
import com.dogoo.department.rest.client.pagination.Pagination;
import com.dogoo.department.rest.client.resource.v2_0.DepartmentResource;
import com.dogoo.department.rest.client.serdes.v2_0.DepartmentSerDes;

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
 * @author khoa
 * @generated
 */
@Generated("")
public abstract class BaseDepartmentResourceTestCase {

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

		_departmentResource.setContextCompany(testCompany);

		DepartmentResource.Builder builder = DepartmentResource.builder();

		departmentResource = builder.authentication(
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

		Department department1 = randomDepartment();

		String json = objectMapper.writeValueAsString(department1);

		Department department2 = DepartmentSerDes.toDTO(json);

		Assert.assertTrue(equals(department1, department2));
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

		Department department = randomDepartment();

		String json1 = objectMapper.writeValueAsString(department);
		String json2 = DepartmentSerDes.toJSON(department);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Department department = randomDepartment();

		department.setAddress(regex);
		department.setAlias(regex);
		department.setCode(regex);
		department.setDescription(regex);
		department.setExternalReferenceCode(regex);
		department.setHeadOffice(regex);
		department.setName(regex);
		department.setTax(regex);

		String json = DepartmentSerDes.toJSON(department);

		Assert.assertFalse(json.contains(regex));

		department = DepartmentSerDes.toDTO(json);

		Assert.assertEquals(regex, department.getAddress());
		Assert.assertEquals(regex, department.getAlias());
		Assert.assertEquals(regex, department.getCode());
		Assert.assertEquals(regex, department.getDescription());
		Assert.assertEquals(regex, department.getExternalReferenceCode());
		Assert.assertEquals(regex, department.getHeadOffice());
		Assert.assertEquals(regex, department.getName());
		Assert.assertEquals(regex, department.getTax());
	}

	@Test
	public void testGetDepartmentsPage() throws Exception {
		Page<Department> page = departmentResource.getDepartmentsPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Department department1 = testGetDepartmentsPage_addDepartment(
			randomDepartment());

		Department department2 = testGetDepartmentsPage_addDepartment(
			randomDepartment());

		page = departmentResource.getDepartmentsPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(department1, (List<Department>)page.getItems());
		assertContains(department2, (List<Department>)page.getItems());
		assertValid(page);

		departmentResource.deleteDepartment(department1.getId());

		departmentResource.deleteDepartment(department2.getId());
	}

	@Test
	public void testGetDepartmentsPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Department department1 = randomDepartment();

		department1 = testGetDepartmentsPage_addDepartment(department1);

		for (EntityField entityField : entityFields) {
			Page<Department> page = departmentResource.getDepartmentsPage(
				null, getFilterString(entityField, "between", department1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(department1),
				(List<Department>)page.getItems());
		}
	}

	@Test
	public void testGetDepartmentsPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Department department1 = testGetDepartmentsPage_addDepartment(
			randomDepartment());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Department department2 = testGetDepartmentsPage_addDepartment(
			randomDepartment());

		for (EntityField entityField : entityFields) {
			Page<Department> page = departmentResource.getDepartmentsPage(
				null, getFilterString(entityField, "eq", department1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(department1),
				(List<Department>)page.getItems());
		}
	}

	@Test
	public void testGetDepartmentsPageWithPagination() throws Exception {
		Page<Department> totalPage = departmentResource.getDepartmentsPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Department department1 = testGetDepartmentsPage_addDepartment(
			randomDepartment());

		Department department2 = testGetDepartmentsPage_addDepartment(
			randomDepartment());

		Department department3 = testGetDepartmentsPage_addDepartment(
			randomDepartment());

		Page<Department> page1 = departmentResource.getDepartmentsPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Department> departments1 = (List<Department>)page1.getItems();

		Assert.assertEquals(
			departments1.toString(), totalCount + 2, departments1.size());

		Page<Department> page2 = departmentResource.getDepartmentsPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Department> departments2 = (List<Department>)page2.getItems();

		Assert.assertEquals(departments2.toString(), 1, departments2.size());

		Page<Department> page3 = departmentResource.getDepartmentsPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(department1, (List<Department>)page3.getItems());
		assertContains(department2, (List<Department>)page3.getItems());
		assertContains(department3, (List<Department>)page3.getItems());
	}

	@Test
	public void testGetDepartmentsPageWithSortDateTime() throws Exception {
		testGetDepartmentsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, department1, department2) -> {
				BeanUtils.setProperty(
					department1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetDepartmentsPageWithSortInteger() throws Exception {
		testGetDepartmentsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, department1, department2) -> {
				BeanUtils.setProperty(department1, entityField.getName(), 0);
				BeanUtils.setProperty(department2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetDepartmentsPageWithSortString() throws Exception {
		testGetDepartmentsPageWithSort(
			EntityField.Type.STRING,
			(entityField, department1, department2) -> {
				Class<?> clazz = department1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						department1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						department2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						department1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						department2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						department1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						department2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetDepartmentsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Department, Department, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Department department1 = randomDepartment();
		Department department2 = randomDepartment();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, department1, department2);
		}

		department1 = testGetDepartmentsPage_addDepartment(department1);

		department2 = testGetDepartmentsPage_addDepartment(department2);

		for (EntityField entityField : entityFields) {
			Page<Department> ascPage = departmentResource.getDepartmentsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(department1, department2),
				(List<Department>)ascPage.getItems());

			Page<Department> descPage = departmentResource.getDepartmentsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(department2, department1),
				(List<Department>)descPage.getItems());
		}
	}

	protected Department testGetDepartmentsPage_addDepartment(
			Department department)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetDepartmentsPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"departments",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject departmentsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/departments");

		long totalCount = departmentsJSONObject.getLong("totalCount");

		Department department1 = testGraphQLDepartment_addDepartment();
		Department department2 = testGraphQLDepartment_addDepartment();

		departmentsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/departments");

		Assert.assertEquals(
			totalCount + 2, departmentsJSONObject.getLong("totalCount"));

		assertContains(
			department1,
			Arrays.asList(
				DepartmentSerDes.toDTOs(
					departmentsJSONObject.getString("items"))));
		assertContains(
			department2,
			Arrays.asList(
				DepartmentSerDes.toDTOs(
					departmentsJSONObject.getString("items"))));
	}

	@Test
	public void testPostDepartment() throws Exception {
		Department randomDepartment = randomDepartment();

		Department postDepartment = testPostDepartment_addDepartment(
			randomDepartment);

		assertEquals(randomDepartment, postDepartment);
		assertValid(postDepartment);
	}

	protected Department testPostDepartment_addDepartment(Department department)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteDepartment() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Department department = testDeleteDepartment_addDepartment();

		assertHttpResponseStatusCode(
			204,
			departmentResource.deleteDepartmentHttpResponse(
				department.getId()));

		assertHttpResponseStatusCode(
			404,
			departmentResource.getDepartmentHttpResponse(department.getId()));

		assertHttpResponseStatusCode(
			404, departmentResource.getDepartmentHttpResponse(0L));
	}

	protected Department testDeleteDepartment_addDepartment() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteDepartment() throws Exception {
		Department department = testGraphQLDepartment_addDepartment();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteDepartment",
						new HashMap<String, Object>() {
							{
								put("departmentId", department.getId());
							}
						})),
				"JSONObject/data", "Object/deleteDepartment"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"department",
					new HashMap<String, Object>() {
						{
							put("departmentId", department.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetDepartment() throws Exception {
		Department postDepartment = testGetDepartment_addDepartment();

		Department getDepartment = departmentResource.getDepartment(
			postDepartment.getId());

		assertEquals(postDepartment, getDepartment);
		assertValid(getDepartment);
	}

	protected Department testGetDepartment_addDepartment() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetDepartment() throws Exception {
		Department department = testGraphQLDepartment_addDepartment();

		Assert.assertTrue(
			equals(
				department,
				DepartmentSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"department",
								new HashMap<String, Object>() {
									{
										put("departmentId", department.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/department"))));
	}

	@Test
	public void testGraphQLGetDepartmentNotFound() throws Exception {
		Long irrelevantDepartmentId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"department",
						new HashMap<String, Object>() {
							{
								put("departmentId", irrelevantDepartmentId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutDepartment() throws Exception {
		Department postDepartment = testPutDepartment_addDepartment();

		Department randomDepartment = randomDepartment();

		Department putDepartment = departmentResource.putDepartment(
			postDepartment.getId(), randomDepartment);

		assertEquals(randomDepartment, putDepartment);
		assertValid(putDepartment);

		Department getDepartment = departmentResource.getDepartment(
			putDepartment.getId());

		assertEquals(randomDepartment, getDepartment);
		assertValid(getDepartment);
	}

	protected Department testPutDepartment_addDepartment() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteDepartmentByExternalReferenceCode() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Department department =
			testDeleteDepartmentByExternalReferenceCode_addDepartment();

		assertHttpResponseStatusCode(
			204,
			departmentResource.
				deleteDepartmentByExternalReferenceCodeHttpResponse(
					department.getExternalReferenceCode()));

		assertHttpResponseStatusCode(
			404,
			departmentResource.getDepartmentByExternalReferenceCodeHttpResponse(
				department.getExternalReferenceCode()));

		assertHttpResponseStatusCode(
			404,
			departmentResource.getDepartmentByExternalReferenceCodeHttpResponse(
				department.getExternalReferenceCode()));
	}

	protected Department
			testDeleteDepartmentByExternalReferenceCode_addDepartment()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetDepartmentByExternalReferenceCode() throws Exception {
		Department postDepartment =
			testGetDepartmentByExternalReferenceCode_addDepartment();

		Department getDepartment =
			departmentResource.getDepartmentByExternalReferenceCode(
				postDepartment.getExternalReferenceCode());

		assertEquals(postDepartment, getDepartment);
		assertValid(getDepartment);
	}

	protected Department
			testGetDepartmentByExternalReferenceCode_addDepartment()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetDepartmentByExternalReferenceCode()
		throws Exception {

		Department department = testGraphQLDepartment_addDepartment();

		Assert.assertTrue(
			equals(
				department,
				DepartmentSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"departmentByExternalReferenceCode",
								new HashMap<String, Object>() {
									{
										put(
											"externalReferenceCode",
											"\"" +
												department.
													getExternalReferenceCode() +
														"\"");
									}
								},
								getGraphQLFields())),
						"JSONObject/data",
						"Object/departmentByExternalReferenceCode"))));
	}

	@Test
	public void testGraphQLGetDepartmentByExternalReferenceCodeNotFound()
		throws Exception {

		String irrelevantExternalReferenceCode =
			"\"" + RandomTestUtil.randomString() + "\"";

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"departmentByExternalReferenceCode",
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
	public void testPutDepartmentByExternalReferenceCode() throws Exception {
		Department postDepartment =
			testPutDepartmentByExternalReferenceCode_addDepartment();

		Department randomDepartment = randomDepartment();

		Department putDepartment =
			departmentResource.putDepartmentByExternalReferenceCode(
				postDepartment.getExternalReferenceCode(), randomDepartment);

		assertEquals(randomDepartment, putDepartment);
		assertValid(putDepartment);

		Department getDepartment =
			departmentResource.getDepartmentByExternalReferenceCode(
				putDepartment.getExternalReferenceCode());

		assertEquals(randomDepartment, getDepartment);
		assertValid(getDepartment);

		Department newDepartment =
			testPutDepartmentByExternalReferenceCode_createDepartment();

		putDepartment = departmentResource.putDepartmentByExternalReferenceCode(
			newDepartment.getExternalReferenceCode(), newDepartment);

		assertEquals(newDepartment, putDepartment);
		assertValid(putDepartment);

		getDepartment = departmentResource.getDepartmentByExternalReferenceCode(
			putDepartment.getExternalReferenceCode());

		assertEquals(newDepartment, getDepartment);

		Assert.assertEquals(
			newDepartment.getExternalReferenceCode(),
			putDepartment.getExternalReferenceCode());
	}

	protected Department
			testPutDepartmentByExternalReferenceCode_createDepartment()
		throws Exception {

		return randomDepartment();
	}

	protected Department
			testPutDepartmentByExternalReferenceCode_addDepartment()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Department testGraphQLDepartment_addDepartment()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		Department department, List<Department> departments) {

		boolean contains = false;

		for (Department item : departments) {
			if (equals(department, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			departments + " does not contain " + department, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Department department1, Department department2) {

		Assert.assertTrue(
			department1 + " does not equal " + department2,
			equals(department1, department2));
	}

	protected void assertEquals(
		List<Department> departments1, List<Department> departments2) {

		Assert.assertEquals(departments1.size(), departments2.size());

		for (int i = 0; i < departments1.size(); i++) {
			Department department1 = departments1.get(i);
			Department department2 = departments2.get(i);

			assertEquals(department1, department2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Department> departments1, List<Department> departments2) {

		Assert.assertEquals(departments1.size(), departments2.size());

		for (Department department1 : departments1) {
			boolean contains = false;

			for (Department department2 : departments2) {
				if (equals(department1, department2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				departments2 + " does not contain " + department1, contains);
		}
	}

	protected void assertValid(Department department) throws Exception {
		boolean valid = true;

		if (department.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (department.getAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("alias", additionalAssertFieldName)) {
				if (department.getAlias() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("business", additionalAssertFieldName)) {
				if (department.getBusiness() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("businessId", additionalAssertFieldName)) {
				if (department.getBusinessId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (department.getCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (department.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (department.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("headOffice", additionalAssertFieldName)) {
				if (department.getHeadOffice() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("isDeleted", additionalAssertFieldName)) {
				if (department.getIsDeleted() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (department.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("order", additionalAssertFieldName)) {
				if (department.getOrder() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (department.getParentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (department.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("statusDate", additionalAssertFieldName)) {
				if (department.getStatusDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tax", additionalAssertFieldName)) {
				if (department.getTax() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (department.getType() == null) {
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

	protected void assertValid(Page<Department> page) {
		boolean valid = false;

		java.util.Collection<Department> departments = page.getItems();

		int size = departments.size();

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
					com.dogoo.department.rest.dto.v2_0.Department.class)) {

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

	protected boolean equals(Department department1, Department department2) {
		if (department1 == department2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getAddress(), department2.getAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("alias", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getAlias(), department2.getAlias())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("business", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getBusiness(), department2.getBusiness())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("businessId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getBusinessId(),
						department2.getBusinessId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getCode(), department2.getCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getDescription(),
						department2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						department1.getExternalReferenceCode(),
						department2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("headOffice", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getHeadOffice(),
						department2.getHeadOffice())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getId(), department2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("isDeleted", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getIsDeleted(),
						department2.getIsDeleted())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getName(), department2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("order", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getOrder(), department2.getOrder())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getParentId(), department2.getParentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getStatus(), department2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("statusDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getStatusDate(),
						department2.getStatusDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tax", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getTax(), department2.getTax())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						department1.getType(), department2.getType())) {

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

		if (!(_departmentResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_departmentResource;

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
		EntityField entityField, String operator, Department department) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("address")) {
			sb.append("'");
			sb.append(String.valueOf(department.getAddress()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("alias")) {
			sb.append("'");
			sb.append(String.valueOf(department.getAlias()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("business")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("businessId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("code")) {
			sb.append("'");
			sb.append(String.valueOf(department.getCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(department.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(department.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("headOffice")) {
			sb.append("'");
			sb.append(String.valueOf(department.getHeadOffice()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("isDeleted")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(department.getName()));
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

		if (entityFieldName.equals("status")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("statusDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(department.getStatusDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(department.getStatusDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(department.getStatusDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("tax")) {
			sb.append("'");
			sb.append(String.valueOf(department.getTax()));
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

	protected Department randomDepartment() throws Exception {
		return new Department() {
			{
				address = StringUtil.toLowerCase(RandomTestUtil.randomString());
				alias = StringUtil.toLowerCase(RandomTestUtil.randomString());
				businessId = RandomTestUtil.randomLong();
				code = StringUtil.toLowerCase(RandomTestUtil.randomString());
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				headOffice = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				isDeleted = RandomTestUtil.randomBoolean();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				order = RandomTestUtil.randomInt();
				parentId = RandomTestUtil.randomLong();
				statusDate = RandomTestUtil.nextDate();
				tax = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Department randomIrrelevantDepartment() throws Exception {
		Department randomIrrelevantDepartment = randomDepartment();

		return randomIrrelevantDepartment;
	}

	protected Department randomPatchDepartment() throws Exception {
		return randomDepartment();
	}

	protected DepartmentResource departmentResource;
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
		LogFactoryUtil.getLog(BaseDepartmentResourceTestCase.class);

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
	private com.dogoo.department.rest.resource.v2_0.DepartmentResource
		_departmentResource;

}