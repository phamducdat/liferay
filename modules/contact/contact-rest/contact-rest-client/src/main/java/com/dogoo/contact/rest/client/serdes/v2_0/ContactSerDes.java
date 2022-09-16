package com.dogoo.contact.rest.client.serdes.v2_0;

import com.dogoo.contact.rest.client.dto.v2_0.Contact;
import com.dogoo.contact.rest.client.dto.v2_0.Email;
import com.dogoo.contact.rest.client.dto.v2_0.Phone;
import com.dogoo.contact.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public class ContactSerDes {

	public static Contact toDTO(String json) {
		ContactJSONParser contactJSONParser = new ContactJSONParser();

		return contactJSONParser.parseToDTO(json);
	}

	public static Contact[] toDTOs(String json) {
		ContactJSONParser contactJSONParser = new ContactJSONParser();

		return contactJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Contact contact) {
		if (contact == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (contact.getEmails() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emails\": ");

			sb.append("[");

			for (int i = 0; i < contact.getEmails().length; i++) {
				sb.append(String.valueOf(contact.getEmails()[i]));

				if ((i + 1) < contact.getEmails().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (contact.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(contact.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (contact.getFacebook() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"facebook\": ");

			sb.append("\"");

			sb.append(_escape(contact.getFacebook()));

			sb.append("\"");
		}

		if (contact.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(contact.getId());
		}

		if (contact.getLinkedin() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"linkedin\": ");

			sb.append("\"");

			sb.append(_escape(contact.getLinkedin()));

			sb.append("\"");
		}

		if (contact.getPhones() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phones\": ");

			sb.append("[");

			for (int i = 0; i < contact.getPhones().length; i++) {
				sb.append(String.valueOf(contact.getPhones()[i]));

				if ((i + 1) < contact.getPhones().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (contact.getTwitter() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"twitter\": ");

			sb.append("\"");

			sb.append(_escape(contact.getTwitter()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ContactJSONParser contactJSONParser = new ContactJSONParser();

		return contactJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Contact contact) {
		if (contact == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (contact.getEmails() == null) {
			map.put("emails", null);
		}
		else {
			map.put("emails", String.valueOf(contact.getEmails()));
		}

		if (contact.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(contact.getExternalReferenceCode()));
		}

		if (contact.getFacebook() == null) {
			map.put("facebook", null);
		}
		else {
			map.put("facebook", String.valueOf(contact.getFacebook()));
		}

		if (contact.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(contact.getId()));
		}

		if (contact.getLinkedin() == null) {
			map.put("linkedin", null);
		}
		else {
			map.put("linkedin", String.valueOf(contact.getLinkedin()));
		}

		if (contact.getPhones() == null) {
			map.put("phones", null);
		}
		else {
			map.put("phones", String.valueOf(contact.getPhones()));
		}

		if (contact.getTwitter() == null) {
			map.put("twitter", null);
		}
		else {
			map.put("twitter", String.valueOf(contact.getTwitter()));
		}

		return map;
	}

	public static class ContactJSONParser extends BaseJSONParser<Contact> {

		@Override
		protected Contact createDTO() {
			return new Contact();
		}

		@Override
		protected Contact[] createDTOArray(int size) {
			return new Contact[size];
		}

		@Override
		protected void setField(
			Contact contact, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "emails")) {
				if (jsonParserFieldValue != null) {
					contact.setEmails(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> EmailSerDes.toDTO((String)object)
						).toArray(
							size -> new Email[size]
						));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					contact.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "facebook")) {
				if (jsonParserFieldValue != null) {
					contact.setFacebook((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					contact.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "linkedin")) {
				if (jsonParserFieldValue != null) {
					contact.setLinkedin((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phones")) {
				if (jsonParserFieldValue != null) {
					contact.setPhones(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> PhoneSerDes.toDTO((String)object)
						).toArray(
							size -> new Phone[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "twitter")) {
				if (jsonParserFieldValue != null) {
					contact.setTwitter((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}