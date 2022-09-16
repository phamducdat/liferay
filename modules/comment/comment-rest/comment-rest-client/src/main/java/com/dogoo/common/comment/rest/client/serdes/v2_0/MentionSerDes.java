package com.dogoo.common.comment.rest.client.serdes.v2_0;

import com.dogoo.common.comment.rest.client.dto.v2_0.Mention;
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
public class MentionSerDes {

	public static Mention toDTO(String json) {
		MentionJSONParser mentionJSONParser = new MentionJSONParser();

		return mentionJSONParser.parseToDTO(json);
	}

	public static Mention[] toDTOs(String json) {
		MentionJSONParser mentionJSONParser = new MentionJSONParser();

		return mentionJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Mention mention) {
		if (mention == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (mention.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(mention.getId());
		}

		if (mention.getMentionChar() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mentionChar\": ");

			sb.append("\"");

			sb.append(_escape(mention.getMentionChar()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		MentionJSONParser mentionJSONParser = new MentionJSONParser();

		return mentionJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Mention mention) {
		if (mention == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (mention.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(mention.getId()));
		}

		if (mention.getMentionChar() == null) {
			map.put("mentionChar", null);
		}
		else {
			map.put("mentionChar", String.valueOf(mention.getMentionChar()));
		}

		return map;
	}

	public static class MentionJSONParser extends BaseJSONParser<Mention> {

		@Override
		protected Mention createDTO() {
			return new Mention();
		}

		@Override
		protected Mention[] createDTOArray(int size) {
			return new Mention[size];
		}

		@Override
		protected void setField(
			Mention mention, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					mention.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mentionChar")) {
				if (jsonParserFieldValue != null) {
					mention.setMentionChar((String)jsonParserFieldValue);
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