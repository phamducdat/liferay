package com.dogoo.common.auditing.rest.client.serdes.v2_0;

import com.dogoo.common.auditing.rest.client.dto.v2_0.Auditing;
import com.dogoo.common.auditing.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class AuditingSerDes {

	public static Auditing toDTO(String json) {
		AuditingJSONParser auditingJSONParser = new AuditingJSONParser();

		return auditingJSONParser.parseToDTO(json);
	}

	public static Auditing[] toDTOs(String json) {
		AuditingJSONParser auditingJSONParser = new AuditingJSONParser();

		return auditingJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Auditing auditing) {
		if (auditing == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (auditing.getCreator() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append("\"");

			sb.append(_escape(auditing.getCreator()));

			sb.append("\"");
		}

		if (auditing.getDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(auditing.getDate()));

			sb.append("\"");
		}

		if (auditing.getEventType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"eventType\": ");

			sb.append("\"");

			sb.append(_escape(auditing.getEventType()));

			sb.append("\"");
		}

		if (auditing.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(auditing.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (auditing.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(auditing.getId());
		}

		if (auditing.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(auditing.getMessage()));

			sb.append("\"");
		}

		if (auditing.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(auditing.getName()));

			sb.append("\"");
		}

		if (auditing.getPayload() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"payload\": ");

			sb.append("\"");

			sb.append(_escape(auditing.getPayload()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AuditingJSONParser auditingJSONParser = new AuditingJSONParser();

		return auditingJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Auditing auditing) {
		if (auditing == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (auditing.getCreator() == null) {
			map.put("creator", null);
		}
		else {
			map.put("creator", String.valueOf(auditing.getCreator()));
		}

		if (auditing.getDate() == null) {
			map.put("date", null);
		}
		else {
			map.put("date", liferayToJSONDateFormat.format(auditing.getDate()));
		}

		if (auditing.getEventType() == null) {
			map.put("eventType", null);
		}
		else {
			map.put("eventType", String.valueOf(auditing.getEventType()));
		}

		if (auditing.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(auditing.getExternalReferenceCode()));
		}

		if (auditing.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(auditing.getId()));
		}

		if (auditing.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(auditing.getMessage()));
		}

		if (auditing.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(auditing.getName()));
		}

		if (auditing.getPayload() == null) {
			map.put("payload", null);
		}
		else {
			map.put("payload", String.valueOf(auditing.getPayload()));
		}

		return map;
	}

	public static class AuditingJSONParser extends BaseJSONParser<Auditing> {

		@Override
		protected Auditing createDTO() {
			return new Auditing();
		}

		@Override
		protected Auditing[] createDTOArray(int size) {
			return new Auditing[size];
		}

		@Override
		protected void setField(
			Auditing auditing, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "creator")) {
				if (jsonParserFieldValue != null) {
					auditing.setCreator((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "date")) {
				if (jsonParserFieldValue != null) {
					auditing.setDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "eventType")) {
				if (jsonParserFieldValue != null) {
					auditing.setEventType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					auditing.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					auditing.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					auditing.setMessage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					auditing.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "payload")) {
				if (jsonParserFieldValue != null) {
					auditing.setPayload((String)jsonParserFieldValue);
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