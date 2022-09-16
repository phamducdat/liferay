package com.dogoo.common.api.rest.client.serdes.v2_0;

import com.dogoo.common.api.rest.client.dto.v2_0.EmployeeReference;
import com.dogoo.common.api.rest.client.json.BaseJSONParser;

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
public class EmployeeReferenceSerDes {

	public static EmployeeReference toDTO(String json) {
		EmployeeReferenceJSONParser employeeReferenceJSONParser =
			new EmployeeReferenceJSONParser();

		return employeeReferenceJSONParser.parseToDTO(json);
	}

	public static EmployeeReference[] toDTOs(String json) {
		EmployeeReferenceJSONParser employeeReferenceJSONParser =
			new EmployeeReferenceJSONParser();

		return employeeReferenceJSONParser.parseToDTOs(json);
	}

	public static String toJSON(EmployeeReference employeeReference) {
		if (employeeReference == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (employeeReference.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(employeeReference.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (employeeReference.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(employeeReference.getId());
		}

		if (employeeReference.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(employeeReference.getName()));

			sb.append("\"");
		}

		if (employeeReference.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(employeeReference.getType());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EmployeeReferenceJSONParser employeeReferenceJSONParser =
			new EmployeeReferenceJSONParser();

		return employeeReferenceJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		EmployeeReference employeeReference) {

		if (employeeReference == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (employeeReference.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(employeeReference.getExternalReferenceCode()));
		}

		if (employeeReference.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(employeeReference.getId()));
		}

		if (employeeReference.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(employeeReference.getName()));
		}

		if (employeeReference.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(employeeReference.getType()));
		}

		return map;
	}

	public static class EmployeeReferenceJSONParser
		extends BaseJSONParser<EmployeeReference> {

		@Override
		protected EmployeeReference createDTO() {
			return new EmployeeReference();
		}

		@Override
		protected EmployeeReference[] createDTOArray(int size) {
			return new EmployeeReference[size];
		}

		@Override
		protected void setField(
			EmployeeReference employeeReference, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "externalReferenceCode")) {
				if (jsonParserFieldValue != null) {
					employeeReference.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					employeeReference.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					employeeReference.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					employeeReference.setType(
						EmployeeReference.Type.create(
							(String)jsonParserFieldValue));
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