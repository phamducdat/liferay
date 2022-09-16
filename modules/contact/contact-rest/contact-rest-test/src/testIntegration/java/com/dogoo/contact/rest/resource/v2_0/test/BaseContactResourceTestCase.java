package com.dogoo.contact.rest.resource.v2_0.test;

import com.dogoo.contact.rest.client.dto.v2_0.Contact;
import com.dogoo.contact.rest.client.http.HttpInvoker;
import com.dogoo.contact.rest.client.pagination.Page;
import com.dogoo.contact.rest.client.pagination.Pagination;
import com.dogoo.contact.rest.client.resource.v2_0.ContactResource;
import com.dogoo.contact.rest.client.serdes.v2_0.ContactSerDes;

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
public abstract class BaseContactResourceTestCase {

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

		_contactResource.setContextCompany(testCompany);

		ContactResource.Builder builder = ContactResource.builder();

		contactResource = builder.authentication(
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

		Contact contact1 = randomContact();

		String json = objectMapper.writeValueAsString(contact1);

		Contact contact2 = ContactSerDes.toDTO(json);

		Assert.assertTrue(equals(contact1, contact2));
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

		Contact contact = randomContact();

		String json1 = objectMapper.writeValueAsString(contact);
		String json2 = ContactSerDes.toJSON(contact);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Contact contact = randomContact();

		contact.setExternalReferenceCode(regex);
		contact.setFacebook(regex);
		contact.setLinkedin(regex);
		contact.setTwitter(regex);

		String json = ContactSerDes.toJSON(contact);

		Assert.assertFalse(json.contains(regex));

		contact = ContactSerDes.toDTO(json);

		Assert.assertEquals(regex, contact.getExternalReferenceCode());
		Assert.assertEquals(regex, contact.getFacebook());
		Assert.assertEquals(regex, contact.getLinkedin());
		Assert.assertEquals(regex, contact.getTwitter());
	}

	@Test
	public void testGetContactsPage() throws Exception {
		Page<Contact> page = contactResource.getContactsPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Contact contact1 = testGetContactsPage_addContact(randomContact());

		Contact contact2 = testGetContactsPage_addContact(randomContact());

		page = contactResource.getContactsPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(contact1, (List<Contact>)page.getItems());
		assertContains(contact2, (List<Contact>)page.getItems());
		assertValid(page);

		contactResource.deleteContact(contact1.getId());

		contactResource.deleteContact(contact2.getId());
	}

	@Test
	public void testGetContactsPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Contact contact1 = randomContact();

		contact1 = testGetContactsPage_addContact(contact1);

		for (EntityField entityField : entityFields) {
			Page<Contact> page = contactResource.getContactsPage(
				null, getFilterString(entityField, "between", contact1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(contact1),
				(List<Contact>)page.getItems());
		}
	}

	@Test
	public void testGetContactsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Contact contact1 = testGetContactsPage_addContact(randomContact());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Contact contact2 = testGetContactsPage_addContact(randomContact());

		for (EntityField entityField : entityFields) {
			Page<Contact> page = contactResource.getContactsPage(
				null, getFilterString(entityField, "eq", contact1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(contact1),
				(List<Contact>)page.getItems());
		}
	}

	@Test
	public void testGetContactsPageWithPagination() throws Exception {
		Page<Contact> totalPage = contactResource.getContactsPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Contact contact1 = testGetContactsPage_addContact(randomContact());

		Contact contact2 = testGetContactsPage_addContact(randomContact());

		Contact contact3 = testGetContactsPage_addContact(randomContact());

		Page<Contact> page1 = contactResource.getContactsPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Contact> contacts1 = (List<Contact>)page1.getItems();

		Assert.assertEquals(
			contacts1.toString(), totalCount + 2, contacts1.size());

		Page<Contact> page2 = contactResource.getContactsPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Contact> contacts2 = (List<Contact>)page2.getItems();

		Assert.assertEquals(contacts2.toString(), 1, contacts2.size());

		Page<Contact> page3 = contactResource.getContactsPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(contact1, (List<Contact>)page3.getItems());
		assertContains(contact2, (List<Contact>)page3.getItems());
		assertContains(contact3, (List<Contact>)page3.getItems());
	}

	@Test
	public void testGetContactsPageWithSortDateTime() throws Exception {
		testGetContactsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, contact1, contact2) -> {
				BeanUtils.setProperty(
					contact1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetContactsPageWithSortInteger() throws Exception {
		testGetContactsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, contact1, contact2) -> {
				BeanUtils.setProperty(contact1, entityField.getName(), 0);
				BeanUtils.setProperty(contact2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetContactsPageWithSortString() throws Exception {
		testGetContactsPageWithSort(
			EntityField.Type.STRING,
			(entityField, contact1, contact2) -> {
				Class<?> clazz = contact1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						contact1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						contact2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						contact1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						contact2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						contact1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						contact2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetContactsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Contact, Contact, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Contact contact1 = randomContact();
		Contact contact2 = randomContact();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, contact1, contact2);
		}

		contact1 = testGetContactsPage_addContact(contact1);

		contact2 = testGetContactsPage_addContact(contact2);

		for (EntityField entityField : entityFields) {
			Page<Contact> ascPage = contactResource.getContactsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(contact1, contact2),
				(List<Contact>)ascPage.getItems());

			Page<Contact> descPage = contactResource.getContactsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(contact2, contact1),
				(List<Contact>)descPage.getItems());
		}
	}

	protected Contact testGetContactsPage_addContact(Contact contact)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetContactsPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"contacts",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject contactsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/contacts");

		long totalCount = contactsJSONObject.getLong("totalCount");

		Contact contact1 = testGraphQLContact_addContact();
		Contact contact2 = testGraphQLContact_addContact();

		contactsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/contacts");

		Assert.assertEquals(
			totalCount + 2, contactsJSONObject.getLong("totalCount"));

		assertContains(
			contact1,
			Arrays.asList(
				ContactSerDes.toDTOs(contactsJSONObject.getString("items"))));
		assertContains(
			contact2,
			Arrays.asList(
				ContactSerDes.toDTOs(contactsJSONObject.getString("items"))));
	}

	@Test
	public void testPostContact() throws Exception {
		Contact randomContact = randomContact();

		Contact postContact = testPostContact_addContact(randomContact);

		assertEquals(randomContact, postContact);
		assertValid(postContact);
	}

	protected Contact testPostContact_addContact(Contact contact)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteContact() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Contact contact = testDeleteContact_addContact();

		assertHttpResponseStatusCode(
			204, contactResource.deleteContactHttpResponse(contact.getId()));

		assertHttpResponseStatusCode(
			404, contactResource.getContactHttpResponse(contact.getId()));

		assertHttpResponseStatusCode(
			404, contactResource.getContactHttpResponse(0L));
	}

	protected Contact testDeleteContact_addContact() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteContact() throws Exception {
		Contact contact = testGraphQLContact_addContact();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteContact",
						new HashMap<String, Object>() {
							{
								put("contactId", contact.getId());
							}
						})),
				"JSONObject/data", "Object/deleteContact"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"contact",
					new HashMap<String, Object>() {
						{
							put("contactId", contact.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetContact() throws Exception {
		Contact postContact = testGetContact_addContact();

		Contact getContact = contactResource.getContact(postContact.getId());

		assertEquals(postContact, getContact);
		assertValid(getContact);
	}

	protected Contact testGetContact_addContact() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetContact() throws Exception {
		Contact contact = testGraphQLContact_addContact();

		Assert.assertTrue(
			equals(
				contact,
				ContactSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"contact",
								new HashMap<String, Object>() {
									{
										put("contactId", contact.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/contact"))));
	}

	@Test
	public void testGraphQLGetContactNotFound() throws Exception {
		Long irrelevantContactId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"contact",
						new HashMap<String, Object>() {
							{
								put("contactId", irrelevantContactId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutContact() throws Exception {
		Contact postContact = testPutContact_addContact();

		Contact randomContact = randomContact();

		Contact putContact = contactResource.putContact(
			postContact.getId(), randomContact);

		assertEquals(randomContact, putContact);
		assertValid(putContact);

		Contact getContact = contactResource.getContact(putContact.getId());

		assertEquals(randomContact, getContact);
		assertValid(getContact);
	}

	protected Contact testPutContact_addContact() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteContactByExternalReferenceCode() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Contact contact = testDeleteContactByExternalReferenceCode_addContact();

		assertHttpResponseStatusCode(
			204,
			contactResource.deleteContactByExternalReferenceCodeHttpResponse(
				contact.getExternalReferenceCode()));

		assertHttpResponseStatusCode(
			404,
			contactResource.getContactByExternalReferenceCodeHttpResponse(
				contact.getExternalReferenceCode()));

		assertHttpResponseStatusCode(
			404,
			contactResource.getContactByExternalReferenceCodeHttpResponse(
				contact.getExternalReferenceCode()));
	}

	protected Contact testDeleteContactByExternalReferenceCode_addContact()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetContactByExternalReferenceCode() throws Exception {
		Contact postContact =
			testGetContactByExternalReferenceCode_addContact();

		Contact getContact = contactResource.getContactByExternalReferenceCode(
			postContact.getExternalReferenceCode());

		assertEquals(postContact, getContact);
		assertValid(getContact);
	}

	protected Contact testGetContactByExternalReferenceCode_addContact()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetContactByExternalReferenceCode()
		throws Exception {

		Contact contact = testGraphQLContact_addContact();

		Assert.assertTrue(
			equals(
				contact,
				ContactSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"contactByExternalReferenceCode",
								new HashMap<String, Object>() {
									{
										put(
											"externalReferenceCode",
											"\"" +
												contact.
													getExternalReferenceCode() +
														"\"");
									}
								},
								getGraphQLFields())),
						"JSONObject/data",
						"Object/contactByExternalReferenceCode"))));
	}

	@Test
	public void testGraphQLGetContactByExternalReferenceCodeNotFound()
		throws Exception {

		String irrelevantExternalReferenceCode =
			"\"" + RandomTestUtil.randomString() + "\"";

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"contactByExternalReferenceCode",
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
	public void testPutContactByExternalReferenceCode() throws Exception {
		Contact postContact =
			testPutContactByExternalReferenceCode_addContact();

		Contact randomContact = randomContact();

		Contact putContact = contactResource.putContactByExternalReferenceCode(
			postContact.getExternalReferenceCode(), randomContact);

		assertEquals(randomContact, putContact);
		assertValid(putContact);

		Contact getContact = contactResource.getContactByExternalReferenceCode(
			putContact.getExternalReferenceCode());

		assertEquals(randomContact, getContact);
		assertValid(getContact);

		Contact newContact =
			testPutContactByExternalReferenceCode_createContact();

		putContact = contactResource.putContactByExternalReferenceCode(
			newContact.getExternalReferenceCode(), newContact);

		assertEquals(newContact, putContact);
		assertValid(putContact);

		getContact = contactResource.getContactByExternalReferenceCode(
			putContact.getExternalReferenceCode());

		assertEquals(newContact, getContact);

		Assert.assertEquals(
			newContact.getExternalReferenceCode(),
			putContact.getExternalReferenceCode());
	}

	protected Contact testPutContactByExternalReferenceCode_createContact()
		throws Exception {

		return randomContact();
	}

	protected Contact testPutContactByExternalReferenceCode_addContact()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Contact testGraphQLContact_addContact() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Contact contact, List<Contact> contacts) {
		boolean contains = false;

		for (Contact item : contacts) {
			if (equals(contact, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(contacts + " does not contain " + contact, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Contact contact1, Contact contact2) {
		Assert.assertTrue(
			contact1 + " does not equal " + contact2,
			equals(contact1, contact2));
	}

	protected void assertEquals(
		List<Contact> contacts1, List<Contact> contacts2) {

		Assert.assertEquals(contacts1.size(), contacts2.size());

		for (int i = 0; i < contacts1.size(); i++) {
			Contact contact1 = contacts1.get(i);
			Contact contact2 = contacts2.get(i);

			assertEquals(contact1, contact2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Contact> contacts1, List<Contact> contacts2) {

		Assert.assertEquals(contacts1.size(), contacts2.size());

		for (Contact contact1 : contacts1) {
			boolean contains = false;

			for (Contact contact2 : contacts2) {
				if (equals(contact1, contact2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				contacts2 + " does not contain " + contact1, contains);
		}
	}

	protected void assertValid(Contact contact) throws Exception {
		boolean valid = true;

		if (contact.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("emails", additionalAssertFieldName)) {
				if (contact.getEmails() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (contact.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("facebook", additionalAssertFieldName)) {
				if (contact.getFacebook() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("linkedin", additionalAssertFieldName)) {
				if (contact.getLinkedin() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phones", additionalAssertFieldName)) {
				if (contact.getPhones() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("twitter", additionalAssertFieldName)) {
				if (contact.getTwitter() == null) {
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

	protected void assertValid(Page<Contact> page) {
		boolean valid = false;

		java.util.Collection<Contact> contacts = page.getItems();

		int size = contacts.size();

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
					com.dogoo.contact.rest.dto.v2_0.Contact.class)) {

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

	protected boolean equals(Contact contact1, Contact contact2) {
		if (contact1 == contact2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("emails", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getEmails(), contact2.getEmails())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						contact1.getExternalReferenceCode(),
						contact2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("facebook", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getFacebook(), contact2.getFacebook())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(contact1.getId(), contact2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("linkedin", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getLinkedin(), contact2.getLinkedin())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phones", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getPhones(), contact2.getPhones())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("twitter", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contact1.getTwitter(), contact2.getTwitter())) {

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

		if (!(_contactResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_contactResource;

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
		EntityField entityField, String operator, Contact contact) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("emails")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(String.valueOf(contact.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("facebook")) {
			sb.append("'");
			sb.append(String.valueOf(contact.getFacebook()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("linkedin")) {
			sb.append("'");
			sb.append(String.valueOf(contact.getLinkedin()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("phones")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("twitter")) {
			sb.append("'");
			sb.append(String.valueOf(contact.getTwitter()));
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

	protected Contact randomContact() throws Exception {
		return new Contact() {
			{
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				facebook = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				linkedin = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				twitter = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Contact randomIrrelevantContact() throws Exception {
		Contact randomIrrelevantContact = randomContact();

		return randomIrrelevantContact;
	}

	protected Contact randomPatchContact() throws Exception {
		return randomContact();
	}

	protected ContactResource contactResource;
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
		LogFactoryUtil.getLog(BaseContactResourceTestCase.class);

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
	private com.dogoo.contact.rest.resource.v2_0.ContactResource
		_contactResource;

}