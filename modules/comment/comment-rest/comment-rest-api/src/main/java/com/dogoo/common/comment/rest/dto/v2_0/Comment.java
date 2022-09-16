package com.dogoo.common.comment.rest.dto.v2_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author khoa
 * @generated
 */
@Generated("")
@GraphQLName(description = "Comment", value = "Comment")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Comment")
public class Comment implements Serializable {

	public static Comment toDTO(String json) {
		return ObjectMapperUtil.readValue(Comment.class, json);
	}

	public static Comment unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Comment.class, json);
	}

	@Schema
	public Long getClassPkId() {
		return classPkId;
	}

	public void setClassPkId(Long classPkId) {
		this.classPkId = classPkId;
	}

	@JsonIgnore
	public void setClassPkId(
		UnsafeSupplier<Long, Exception> classPkIdUnsafeSupplier) {

		try {
			classPkId = classPkIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long classPkId;

	@Schema
	public String getClassPkName() {
		return classPkName;
	}

	public void setClassPkName(String classPkName) {
		this.classPkName = classPkName;
	}

	@JsonIgnore
	public void setClassPkName(
		UnsafeSupplier<String, Exception> classPkNameUnsafeSupplier) {

		try {
			classPkName = classPkNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String classPkName;

	@Schema
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	@JsonIgnore
	public void setCommentId(
		UnsafeSupplier<Long, Exception> commentIdUnsafeSupplier) {

		try {
			commentId = commentIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long commentId;

	@Schema
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonIgnore
	public void setContent(
		UnsafeSupplier<String, Exception> contentUnsafeSupplier) {

		try {
			content = contentUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String content;

	@Schema
	public String getCreateDateNow() {
		return createDateNow;
	}

	public void setCreateDateNow(String createDateNow) {
		this.createDateNow = createDateNow;
	}

	@JsonIgnore
	public void setCreateDateNow(
		UnsafeSupplier<String, Exception> createDateNowUnsafeSupplier) {

		try {
			createDateNow = createDateNowUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String createDateNow;

	@Schema
	public Long getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Long creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	@JsonIgnore
	public void setCreatorUserId(
		UnsafeSupplier<Long, Exception> creatorUserIdUnsafeSupplier) {

		try {
			creatorUserId = creatorUserIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long creatorUserId;

	@Schema
	public String getCreatorUserName() {
		return creatorUserName;
	}

	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}

	@JsonIgnore
	public void setCreatorUserName(
		UnsafeSupplier<String, Exception> creatorUserNameUnsafeSupplier) {

		try {
			creatorUserName = creatorUserNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String creatorUserName;

	@Schema
	public String getExternalReferenceCode() {
		return externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		this.externalReferenceCode = externalReferenceCode;
	}

	@JsonIgnore
	public void setExternalReferenceCode(
		UnsafeSupplier<String, Exception> externalReferenceCodeUnsafeSupplier) {

		try {
			externalReferenceCode = externalReferenceCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String externalReferenceCode;

	@Schema
	@Valid
	public Mention[] getMentions() {
		return mentions;
	}

	public void setMentions(Mention[] mentions) {
		this.mentions = mentions;
	}

	@JsonIgnore
	public void setMentions(
		UnsafeSupplier<Mention[], Exception> mentionsUnsafeSupplier) {

		try {
			mentions = mentionsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	protected Mention[] mentions;

	@Schema
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@JsonIgnore
	public void setParentId(
		UnsafeSupplier<Long, Exception> parentIdUnsafeSupplier) {

		try {
			parentId = parentIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long parentId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Comment)) {
			return false;
		}

		Comment comment = (Comment)object;

		return Objects.equals(toString(), comment.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (classPkId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPkId\": ");

			sb.append(classPkId);
		}

		if (classPkName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPkName\": ");

			sb.append("\"");

			sb.append(_escape(classPkName));

			sb.append("\"");
		}

		if (commentId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commentId\": ");

			sb.append(commentId);
		}

		if (content != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"content\": ");

			sb.append("\"");

			sb.append(_escape(content));

			sb.append("\"");
		}

		if (createDateNow != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDateNow\": ");

			sb.append("\"");

			sb.append(_escape(createDateNow));

			sb.append("\"");
		}

		if (creatorUserId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorUserId\": ");

			sb.append(creatorUserId);
		}

		if (creatorUserName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorUserName\": ");

			sb.append("\"");

			sb.append(_escape(creatorUserName));

			sb.append("\"");
		}

		if (externalReferenceCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(externalReferenceCode));

			sb.append("\"");
		}

		if (mentions != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mentions\": ");

			sb.append("[");

			for (int i = 0; i < mentions.length; i++) {
				sb.append(String.valueOf(mentions[i]));

				if ((i + 1) < mentions.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (parentId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(parentId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.common.comment.rest.dto.v2_0.Comment",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}