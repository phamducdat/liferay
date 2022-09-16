package com.dogoo.common.comment.rest.client.serdes.v2_0;

import com.dogoo.common.comment.rest.client.dto.v2_0.Emoticon;
import com.dogoo.common.comment.rest.client.json.BaseJSONParser;

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
public class EmoticonSerDes {

	public static Emoticon toDTO(String json) {
		EmoticonJSONParser emoticonJSONParser = new EmoticonJSONParser();

		return emoticonJSONParser.parseToDTO(json);
	}

	public static Emoticon[] toDTOs(String json) {
		EmoticonJSONParser emoticonJSONParser = new EmoticonJSONParser();

		return emoticonJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Emoticon emoticon) {
		if (emoticon == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (emoticon.getClassPkId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPkId\": ");

			sb.append(emoticon.getClassPkId());
		}

		if (emoticon.getClassPkName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPkName\": ");

			sb.append("\"");

			sb.append(_escape(emoticon.getClassPkName()));

			sb.append("\"");
		}

		if (emoticon.getCreatorUserName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorUserName\": ");

			sb.append("\"");

			sb.append(_escape(emoticon.getCreatorUserName()));

			sb.append("\"");
		}

		if (emoticon.getCretorUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cretorUserId\": ");

			sb.append(emoticon.getCretorUserId());
		}

		if (emoticon.getEmoji() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emoji\": ");

			sb.append("\"");

			sb.append(_escape(emoticon.getEmoji()));

			sb.append("\"");
		}

		if (emoticon.getEmoticonId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emoticonId\": ");

			sb.append(emoticon.getEmoticonId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EmoticonJSONParser emoticonJSONParser = new EmoticonJSONParser();

		return emoticonJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Emoticon emoticon) {
		if (emoticon == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (emoticon.getClassPkId() == null) {
			map.put("classPkId", null);
		}
		else {
			map.put("classPkId", String.valueOf(emoticon.getClassPkId()));
		}

		if (emoticon.getClassPkName() == null) {
			map.put("classPkName", null);
		}
		else {
			map.put("classPkName", String.valueOf(emoticon.getClassPkName()));
		}

		if (emoticon.getCreatorUserName() == null) {
			map.put("creatorUserName", null);
		}
		else {
			map.put(
				"creatorUserName",
				String.valueOf(emoticon.getCreatorUserName()));
		}

		if (emoticon.getCretorUserId() == null) {
			map.put("cretorUserId", null);
		}
		else {
			map.put("cretorUserId", String.valueOf(emoticon.getCretorUserId()));
		}

		if (emoticon.getEmoji() == null) {
			map.put("emoji", null);
		}
		else {
			map.put("emoji", String.valueOf(emoticon.getEmoji()));
		}

		if (emoticon.getEmoticonId() == null) {
			map.put("emoticonId", null);
		}
		else {
			map.put("emoticonId", String.valueOf(emoticon.getEmoticonId()));
		}

		return map;
	}

	public static class EmoticonJSONParser extends BaseJSONParser<Emoticon> {

		@Override
		protected Emoticon createDTO() {
			return new Emoticon();
		}

		@Override
		protected Emoticon[] createDTOArray(int size) {
			return new Emoticon[size];
		}

		@Override
		protected void setField(
			Emoticon emoticon, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "classPkId")) {
				if (jsonParserFieldValue != null) {
					emoticon.setClassPkId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "classPkName")) {
				if (jsonParserFieldValue != null) {
					emoticon.setClassPkName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creatorUserName")) {
				if (jsonParserFieldValue != null) {
					emoticon.setCreatorUserName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "cretorUserId")) {
				if (jsonParserFieldValue != null) {
					emoticon.setCretorUserId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "emoji")) {
				if (jsonParserFieldValue != null) {
					emoticon.setEmoji((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "emoticonId")) {
				if (jsonParserFieldValue != null) {
					emoticon.setEmoticonId(
						Long.valueOf((String)jsonParserFieldValue));
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