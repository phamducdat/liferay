package com.dogoo.contact.rest.client.serdes.v2_0;

import com.dogoo.contact.rest.client.dto.v2_0.Phone;
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
public class PhoneSerDes {

	public static Phone toDTO(String json) {
		PhoneJSONParser phoneJSONParser = new PhoneJSONParser();

		return phoneJSONParser.parseToDTO(json);
	}

	public static Phone[] toDTOs(String json) {
		PhoneJSONParser phoneJSONParser = new PhoneJSONParser();

		return phoneJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Phone phone) {
		if (phone == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (phone.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(phone.getDescription()));

			sb.append("\"");
		}

		if (phone.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(phone.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (phone.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(phone.getId());
		}

		if (phone.getIsDefaulted() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isDefaulted\": ");

			sb.append(phone.getIsDefaulted());
		}

		if (phone.getNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"number\": ");

			sb.append("\"");

			sb.append(_escape(phone.getNumber()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PhoneJSONParser phoneJSONParser = new PhoneJSONParser();

		return phoneJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Phone phone) {
		if (phone == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (phone.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(phone.getDescription()));
		}

		if (phone.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(phone.getExternalReferenceCode()));
		}

		if (phone.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(phone.getId()));
		}

		if (phone.getIsDefaulted() == null) {
			map.put("isDefaulted", null);
		}
		else {
			map.put("isDefaulted", String.valueOf(phone.getIsDefaulted()));
		}

		if (phone.getNumber() == null) {
			map.put("number", null);
		}
		else {
			map.put("number", String.valueOf(phone.getNumber()));
		}

		return map;
	}

	public static class PhoneJSONParser extends BaseJSONParser<Phone> {

		@Override
		protected Phone createDTO() {
			return new Phone();
		}

		@Override
		protected Phone[] createDTOArray(int size) {
			return new Phone[size];
		}

		@Override
		protected void setField(
			Phone phone, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					phone.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					phone.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					phone.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isDefaulted")) {
				if (jsonParserFieldValue != null) {
					phone.setIsDefaulted((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "number")) {
				if (jsonParserFieldValue != null) {
					phone.setNumber((String)jsonParserFieldValue);
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