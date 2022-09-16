package com.dogoo.common.comment.rest.client.serdes.v2_0;

import com.dogoo.common.comment.rest.client.dto.v2_0.Comment;
import com.dogoo.common.comment.rest.client.dto.v2_0.TreeComment;
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
public class TreeCommentSerDes {

	public static TreeComment toDTO(String json) {
		TreeCommentJSONParser treeCommentJSONParser =
			new TreeCommentJSONParser();

		return treeCommentJSONParser.parseToDTO(json);
	}

	public static TreeComment[] toDTOs(String json) {
		TreeCommentJSONParser treeCommentJSONParser =
			new TreeCommentJSONParser();

		return treeCommentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(TreeComment treeComment) {
		if (treeComment == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (treeComment.getClassPkId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPkId\": ");

			sb.append(treeComment.getClassPkId());
		}

		if (treeComment.getClassPkName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPkName\": ");

			sb.append("\"");

			sb.append(_escape(treeComment.getClassPkName()));

			sb.append("\"");
		}

		if (treeComment.getCommentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commentId\": ");

			sb.append(treeComment.getCommentId());
		}

		if (treeComment.getContent() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"content\": ");

			sb.append("\"");

			sb.append(_escape(treeComment.getContent()));

			sb.append("\"");
		}

		if (treeComment.getCreateDateNow() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDateNow\": ");

			sb.append("\"");

			sb.append(_escape(treeComment.getCreateDateNow()));

			sb.append("\"");
		}

		if (treeComment.getCreatorUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorUserId\": ");

			sb.append(treeComment.getCreatorUserId());
		}

		if (treeComment.getCreatorUserName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorUserName\": ");

			sb.append("\"");

			sb.append(_escape(treeComment.getCreatorUserName()));

			sb.append("\"");
		}

		if (treeComment.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(treeComment.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (treeComment.getParentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(treeComment.getParentId());
		}

		if (treeComment.getTreeComments() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"treeComments\": ");

			sb.append("[");

			for (int i = 0; i < treeComment.getTreeComments().length; i++) {
				sb.append(String.valueOf(treeComment.getTreeComments()[i]));

				if ((i + 1) < treeComment.getTreeComments().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TreeCommentJSONParser treeCommentJSONParser =
			new TreeCommentJSONParser();

		return treeCommentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(TreeComment treeComment) {
		if (treeComment == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (treeComment.getClassPkId() == null) {
			map.put("classPkId", null);
		}
		else {
			map.put("classPkId", String.valueOf(treeComment.getClassPkId()));
		}

		if (treeComment.getClassPkName() == null) {
			map.put("classPkName", null);
		}
		else {
			map.put(
				"classPkName", String.valueOf(treeComment.getClassPkName()));
		}

		if (treeComment.getCommentId() == null) {
			map.put("commentId", null);
		}
		else {
			map.put("commentId", String.valueOf(treeComment.getCommentId()));
		}

		if (treeComment.getContent() == null) {
			map.put("content", null);
		}
		else {
			map.put("content", String.valueOf(treeComment.getContent()));
		}

		if (treeComment.getCreateDateNow() == null) {
			map.put("createDateNow", null);
		}
		else {
			map.put(
				"createDateNow",
				String.valueOf(treeComment.getCreateDateNow()));
		}

		if (treeComment.getCreatorUserId() == null) {
			map.put("creatorUserId", null);
		}
		else {
			map.put(
				"creatorUserId",
				String.valueOf(treeComment.getCreatorUserId()));
		}

		if (treeComment.getCreatorUserName() == null) {
			map.put("creatorUserName", null);
		}
		else {
			map.put(
				"creatorUserName",
				String.valueOf(treeComment.getCreatorUserName()));
		}

		if (treeComment.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(treeComment.getExternalReferenceCode()));
		}

		if (treeComment.getParentId() == null) {
			map.put("parentId", null);
		}
		else {
			map.put("parentId", String.valueOf(treeComment.getParentId()));
		}

		if (treeComment.getTreeComments() == null) {
			map.put("treeComments", null);
		}
		else {
			map.put(
				"treeComments", String.valueOf(treeComment.getTreeComments()));
		}

		return map;
	}

	public static class TreeCommentJSONParser
		extends BaseJSONParser<TreeComment> {

		@Override
		protected TreeComment createDTO() {
			return new TreeComment();
		}

		@Override
		protected TreeComment[] createDTOArray(int size) {
			return new TreeComment[size];
		}

		@Override
		protected void setField(
			TreeComment treeComment, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "classPkId")) {
				if (jsonParserFieldValue != null) {
					treeComment.setClassPkId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "classPkName")) {
				if (jsonParserFieldValue != null) {
					treeComment.setClassPkName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "commentId")) {
				if (jsonParserFieldValue != null) {
					treeComment.setCommentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "content")) {
				if (jsonParserFieldValue != null) {
					treeComment.setContent((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createDateNow")) {
				if (jsonParserFieldValue != null) {
					treeComment.setCreateDateNow((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creatorUserId")) {
				if (jsonParserFieldValue != null) {
					treeComment.setCreatorUserId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creatorUserName")) {
				if (jsonParserFieldValue != null) {
					treeComment.setCreatorUserName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					treeComment.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentId")) {
				if (jsonParserFieldValue != null) {
					treeComment.setParentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "treeComments")) {
				if (jsonParserFieldValue != null) {
					treeComment.setTreeComments(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> CommentSerDes.toDTO((String)object)
						).toArray(
							size -> new Comment[size]
						));
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