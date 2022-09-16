package com.dogoo.contact.rest.client.serdes.v2_0;

import com.dogoo.contact.rest.client.dto.v2_0.Email;
import com.dogoo.contact.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public class EmailSerDes {

	public static Email toDTO(String json) {
		EmailJSONParser emailJSONParser = new EmailJSONParser();

		return emailJSONParser.parseToDTO(json);
	}

	public static Email[] toDTOs(String json) {
		EmailJSONParser emailJSONParser = new EmailJSONParser();

		return emailJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Email email) {
		if (email == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (email.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(email.getDescription()));

			sb.append("\"");
		}

		if (email.getEmailAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailAddress\": ");

			sb.append("\"");

			sb.append(_escape(email.getEmailAddress()));

			sb.append("\"");
		}

		if (email.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(email.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (email.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(email.getId());
		}

		if (email.getIsDefaulted() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isDefaulted\": ");

			sb.append(email.getIsDefaulted());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EmailJSONParser emailJSONParser = new EmailJSONParser();

		return emailJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Email email) {
		if (email == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (email.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(email.getDescription()));
		}

		if (email.getEmailAddress() == null) {
			map.put("emailAddress", null);
		}
		else {
			map.put("emailAddress", String.valueOf(email.getEmailAddress()));
		}

		if (email.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(email.getExternalReferenceCode()));
		}

		if (email.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(email.getId()));
		}

		if (email.getIsDefaulted() == null) {
			map.put("isDefaulted", null);
		}
		else {
			map.put("isDefaulted", String.valueOf(email.getIsDefaulted()));
		}

		return map;
	}

	public static class EmailJSONParser extends BaseJSONParser<Email> {

		@Override
		protected Email createDTO() {
			return new Email();
		}

		@Override
		protected Email[] createDTOArray(int size) {
			return new Email[size];
		}

		@Override
		protected void setField(
			Email email, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					email.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "emailAddress")) {
				if (jsonParserFieldValue != null) {
					email.setEmailAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					email.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					email.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isDefaulted")) {
				if (jsonParserFieldValue != null) {
					email.setIsDefaulted((Boolean)jsonParserFieldValue);
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