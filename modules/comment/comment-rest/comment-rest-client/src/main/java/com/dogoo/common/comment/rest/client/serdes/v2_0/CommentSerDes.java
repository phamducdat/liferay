package com.dogoo.common.comment.rest.client.serdes.v2_0;

import com.dogoo.common.comment.rest.client.dto.v2_0.Comment;
import com.dogoo.common.comment.rest.client.dto.v2_0.Mention;
import com.dogoo.common.comment.rest.client.json.BaseJSONParser;

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
public class CommentSerDes {

	public static Comment toDTO(String json) {
		CommentJSONParser commentJSONParser = new CommentJSONParser();

		return commentJSONParser.parseToDTO(json);
	}

	public static Comment[] toDTOs(String json) {
		CommentJSONParser commentJSONParser = new CommentJSONParser();

		return commentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Comment comment) {
		if (comment == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (comment.getClassPkId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPkId\": ");

			sb.append(comment.getClassPkId());
		}

		if (comment.getClassPkName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPkName\": ");

			sb.append("\"");

			sb.append(_escape(comment.getClassPkName()));

			sb.append("\"");
		}

		if (comment.getCommentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commentId\": ");

			sb.append(comment.getCommentId());
		}

		if (comment.getContent() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"content\": ");

			sb.append("\"");

			sb.append(_escape(comment.getContent()));

			sb.append("\"");
		}

		if (comment.getCreateDateNow() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDateNow\": ");

			sb.append("\"");

			sb.append(_escape(comment.getCreateDateNow()));

			sb.append("\"");
		}

		if (comment.getCreatorUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorUserId\": ");

			sb.append(comment.getCreatorUserId());
		}

		if (comment.getCreatorUserName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorUserName\": ");

			sb.append("\"");

			sb.append(_escape(comment.getCreatorUserName()));

			sb.append("\"");
		}

		if (comment.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(comment.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (comment.getMentions() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mentions\": ");

			sb.append("[");

			for (int i = 0; i < comment.getMentions().length; i++) {
				sb.append(String.valueOf(comment.getMentions()[i]));

				if ((i + 1) < comment.getMentions().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (comment.getParentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(comment.getParentId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CommentJSONParser commentJSONParser = new CommentJSONParser();

		return commentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Comment comment) {
		if (comment == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (comment.getClassPkId() == null) {
			map.put("classPkId", null);
		}
		else {
			map.put("classPkId", String.valueOf(comment.getClassPkId()));
		}

		if (comment.getClassPkName() == null) {
			map.put("classPkName", null);
		}
		else {
			map.put("classPkName", String.valueOf(comment.getClassPkName()));
		}

		if (comment.getCommentId() == null) {
			map.put("commentId", null);
		}
		else {
			map.put("commentId", String.valueOf(comment.getCommentId()));
		}

		if (comment.getContent() == null) {
			map.put("content", null);
		}
		else {
			map.put("content", String.valueOf(comment.getContent()));
		}

		if (comment.getCreateDateNow() == null) {
			map.put("createDateNow", null);
		}
		else {
			map.put(
				"createDateNow", String.valueOf(comment.getCreateDateNow()));
		}

		if (comment.getCreatorUserId() == null) {
			map.put("creatorUserId", null);
		}
		else {
			map.put(
				"creatorUserId", String.valueOf(comment.getCreatorUserId()));
		}

		if (comment.getCreatorUserName() == null) {
			map.put("creatorUserName", null);
		}
		else {
			map.put(
				"creatorUserName",
				String.valueOf(comment.getCreatorUserName()));
		}

		if (comment.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(comment.getExternalReferenceCode()));
		}

		if (comment.getMentions() == null) {
			map.put("mentions", null);
		}
		else {
			map.put("mentions", String.valueOf(comment.getMentions()));
		}

		if (comment.getParentId() == null) {
			map.put("parentId", null);
		}
		else {
			map.put("parentId", String.valueOf(comment.getParentId()));
		}

		return map;
	}

	public static class CommentJSONParser extends BaseJSONParser<Comment> {

		@Override
		protected Comment createDTO() {
			return new Comment();
		}

		@Override
		protected Comment[] createDTOArray(int size) {
			return new Comment[size];
		}

		@Override
		protected void setField(
			Comment comment, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "classPkId")) {
				if (jsonParserFieldValue != null) {
					comment.setClassPkId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "classPkName")) {
				if (jsonParserFieldValue != null) {
					comment.setClassPkName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "commentId")) {
				if (jsonParserFieldValue != null) {
					comment.setCommentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "content")) {
				if (jsonParserFieldValue != null) {
					comment.setContent((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createDateNow")) {
				if (jsonParserFieldValue != null) {
					comment.setCreateDateNow((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creatorUserId")) {
				if (jsonParserFieldValue != null) {
					comment.setCreatorUserId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creatorUserName")) {
				if (jsonParserFieldValue != null) {
					comment.setCreatorUserName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					comment.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mentions")) {
				if (jsonParserFieldValue != null) {
					comment.setMentions(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> MentionSerDes.toDTO((String)object)
						).toArray(
							size -> new Mention[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentId")) {
				if (jsonParserFieldValue != null) {
					comment.setParentId(
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