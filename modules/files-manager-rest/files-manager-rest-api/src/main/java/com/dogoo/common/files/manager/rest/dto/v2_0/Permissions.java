package com.dogoo.common.files.manager.rest.dto.v2_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author khoa
 * @generated
 */
@Generated("")
@GraphQLName("Permissions")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Permissions")
public class Permissions implements Serializable {

	public static Permissions toDTO(String json) {
		return ObjectMapperUtil.readValue(Permissions.class, json);
	}

	public static Permissions unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Permissions.class, json);
	}

	@Schema
	public Boolean getChat() {
		return chat;
	}

	public void setChat(Boolean chat) {
		this.chat = chat;
	}

	@JsonIgnore
	public void setChat(UnsafeSupplier<Boolean, Exception> chatUnsafeSupplier) {
		try {
			chat = chatUnsafeSupplier.get();
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
	protected Boolean chat;

	@Schema
	public Boolean getComment() {
		return comment;
	}

	public void setComment(Boolean comment) {
		this.comment = comment;
	}

	@JsonIgnore
	public void setComment(
		UnsafeSupplier<Boolean, Exception> commentUnsafeSupplier) {

		try {
			comment = commentUnsafeSupplier.get();
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
	protected Boolean comment;

	@Schema
	public Boolean getCopy() {
		return copy;
	}

	public void setCopy(Boolean copy) {
		this.copy = copy;
	}

	@JsonIgnore
	public void setCopy(UnsafeSupplier<Boolean, Exception> copyUnsafeSupplier) {
		try {
			copy = copyUnsafeSupplier.get();
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
	protected Boolean copy;

	@Schema
	public Boolean getDeleteCommentAuthorOnly() {
		return deleteCommentAuthorOnly;
	}

	public void setDeleteCommentAuthorOnly(Boolean deleteCommentAuthorOnly) {
		this.deleteCommentAuthorOnly = deleteCommentAuthorOnly;
	}

	@JsonIgnore
	public void setDeleteCommentAuthorOnly(
		UnsafeSupplier<Boolean, Exception>
			deleteCommentAuthorOnlyUnsafeSupplier) {

		try {
			deleteCommentAuthorOnly =
				deleteCommentAuthorOnlyUnsafeSupplier.get();
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
	protected Boolean deleteCommentAuthorOnly;

	@Schema
	public Boolean getDownload() {
		return download;
	}

	public void setDownload(Boolean download) {
		this.download = download;
	}

	@JsonIgnore
	public void setDownload(
		UnsafeSupplier<Boolean, Exception> downloadUnsafeSupplier) {

		try {
			download = downloadUnsafeSupplier.get();
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
	protected Boolean download;

	@Schema
	public Boolean getEdit() {
		return edit;
	}

	public void setEdit(Boolean edit) {
		this.edit = edit;
	}

	@JsonIgnore
	public void setEdit(UnsafeSupplier<Boolean, Exception> editUnsafeSupplier) {
		try {
			edit = editUnsafeSupplier.get();
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
	protected Boolean edit;

	@Schema
	public Boolean getEditCommentAuthorOnly() {
		return editCommentAuthorOnly;
	}

	public void setEditCommentAuthorOnly(Boolean editCommentAuthorOnly) {
		this.editCommentAuthorOnly = editCommentAuthorOnly;
	}

	@JsonIgnore
	public void setEditCommentAuthorOnly(
		UnsafeSupplier<Boolean, Exception>
			editCommentAuthorOnlyUnsafeSupplier) {

		try {
			editCommentAuthorOnly = editCommentAuthorOnlyUnsafeSupplier.get();
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
	protected Boolean editCommentAuthorOnly;

	@Schema
	public Boolean getFillForms() {
		return fillForms;
	}

	public void setFillForms(Boolean fillForms) {
		this.fillForms = fillForms;
	}

	@JsonIgnore
	public void setFillForms(
		UnsafeSupplier<Boolean, Exception> fillFormsUnsafeSupplier) {

		try {
			fillForms = fillFormsUnsafeSupplier.get();
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
	protected Boolean fillForms;

	@Schema
	public Boolean getModifyContentControl() {
		return modifyContentControl;
	}

	public void setModifyContentControl(Boolean modifyContentControl) {
		this.modifyContentControl = modifyContentControl;
	}

	@JsonIgnore
	public void setModifyContentControl(
		UnsafeSupplier<Boolean, Exception> modifyContentControlUnsafeSupplier) {

		try {
			modifyContentControl = modifyContentControlUnsafeSupplier.get();
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
	protected Boolean modifyContentControl;

	@Schema
	public Boolean getModifyFilter() {
		return modifyFilter;
	}

	public void setModifyFilter(Boolean modifyFilter) {
		this.modifyFilter = modifyFilter;
	}

	@JsonIgnore
	public void setModifyFilter(
		UnsafeSupplier<Boolean, Exception> modifyFilterUnsafeSupplier) {

		try {
			modifyFilter = modifyFilterUnsafeSupplier.get();
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
	protected Boolean modifyFilter;

	@Schema
	public Boolean getPrint() {
		return print;
	}

	public void setPrint(Boolean print) {
		this.print = print;
	}

	@JsonIgnore
	public void setPrint(
		UnsafeSupplier<Boolean, Exception> printUnsafeSupplier) {

		try {
			print = printUnsafeSupplier.get();
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
	protected Boolean print;

	@Schema
	public Boolean getProtect() {
		return protect;
	}

	public void setProtect(Boolean protect) {
		this.protect = protect;
	}

	@JsonIgnore
	public void setProtect(
		UnsafeSupplier<Boolean, Exception> protectUnsafeSupplier) {

		try {
			protect = protectUnsafeSupplier.get();
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
	protected Boolean protect;

	@Schema
	public Boolean getReview() {
		return review;
	}

	public void setReview(Boolean review) {
		this.review = review;
	}

	@JsonIgnore
	public void setReview(
		UnsafeSupplier<Boolean, Exception> reviewUnsafeSupplier) {

		try {
			review = reviewUnsafeSupplier.get();
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
	protected Boolean review;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Permissions)) {
			return false;
		}

		Permissions permissions = (Permissions)object;

		return Objects.equals(toString(), permissions.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (chat != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chat\": ");

			sb.append(chat);
		}

		if (comment != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"comment\": ");

			sb.append(comment);
		}

		if (copy != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"copy\": ");

			sb.append(copy);
		}

		if (deleteCommentAuthorOnly != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"deleteCommentAuthorOnly\": ");

			sb.append(deleteCommentAuthorOnly);
		}

		if (download != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"download\": ");

			sb.append(download);
		}

		if (edit != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"edit\": ");

			sb.append(edit);
		}

		if (editCommentAuthorOnly != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"editCommentAuthorOnly\": ");

			sb.append(editCommentAuthorOnly);
		}

		if (fillForms != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fillForms\": ");

			sb.append(fillForms);
		}

		if (modifyContentControl != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifyContentControl\": ");

			sb.append(modifyContentControl);
		}

		if (modifyFilter != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifyFilter\": ");

			sb.append(modifyFilter);
		}

		if (print != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"print\": ");

			sb.append(print);
		}

		if (protect != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"protect\": ");

			sb.append(protect);
		}

		if (review != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"review\": ");

			sb.append(review);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.common.files.manager.rest.dto.v2_0.Permissions",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
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
			sb.append(_escape(entry.getKey()));
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
				sb.append(_escape(value));
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

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}