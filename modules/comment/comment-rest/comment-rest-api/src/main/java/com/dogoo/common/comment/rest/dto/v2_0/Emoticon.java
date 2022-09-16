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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author khoa
 * @generated
 */
@Generated("")
@GraphQLName(description = "Emoticon", value = "Emoticon")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Emoticon")
public class Emoticon implements Serializable {

	public static Emoticon toDTO(String json) {
		return ObjectMapperUtil.readValue(Emoticon.class, json);
	}

	public static Emoticon unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Emoticon.class, json);
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
	public Long getCretorUserId() {
		return cretorUserId;
	}

	public void setCretorUserId(Long cretorUserId) {
		this.cretorUserId = cretorUserId;
	}

	@JsonIgnore
	public void setCretorUserId(
		UnsafeSupplier<Long, Exception> cretorUserIdUnsafeSupplier) {

		try {
			cretorUserId = cretorUserIdUnsafeSupplier.get();
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
	protected Long cretorUserId;

	@Schema
	public String getEmoji() {
		return emoji;
	}

	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}

	@JsonIgnore
	public void setEmoji(
		UnsafeSupplier<String, Exception> emojiUnsafeSupplier) {

		try {
			emoji = emojiUnsafeSupplier.get();
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
	protected String emoji;

	@Schema
	public Long getEmoticonId() {
		return emoticonId;
	}

	public void setEmoticonId(Long emoticonId) {
		this.emoticonId = emoticonId;
	}

	@JsonIgnore
	public void setEmoticonId(
		UnsafeSupplier<Long, Exception> emoticonIdUnsafeSupplier) {

		try {
			emoticonId = emoticonIdUnsafeSupplier.get();
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
	protected Long emoticonId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Emoticon)) {
			return false;
		}

		Emoticon emoticon = (Emoticon)object;

		return Objects.equals(toString(), emoticon.toString());
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

		if (creatorUserName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorUserName\": ");

			sb.append("\"");

			sb.append(_escape(creatorUserName));

			sb.append("\"");
		}

		if (cretorUserId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cretorUserId\": ");

			sb.append(cretorUserId);
		}

		if (emoji != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emoji\": ");

			sb.append("\"");

			sb.append(_escape(emoji));

			sb.append("\"");
		}

		if (emoticonId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emoticonId\": ");

			sb.append(emoticonId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.common.comment.rest.dto.v2_0.Emoticon",
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