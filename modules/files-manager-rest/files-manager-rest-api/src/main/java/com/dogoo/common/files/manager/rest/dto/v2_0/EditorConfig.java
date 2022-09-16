package com.dogoo.common.files.manager.rest.dto.v2_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
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

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author khoa
 * @generated
 */
@Generated("")
@GraphQLName("EditorConfig")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "EditorConfig")
public class EditorConfig implements Serializable {

	public static EditorConfig toDTO(String json) {
		return ObjectMapperUtil.readValue(EditorConfig.class, json);
	}

	public static EditorConfig unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(EditorConfig.class, json);
	}

	@Schema
	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	@JsonIgnore
	public void setCallbackUrl(
		UnsafeSupplier<String, Exception> callbackUrlUnsafeSupplier) {

		try {
			callbackUrl = callbackUrlUnsafeSupplier.get();
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
	protected String callbackUrl;

	@Schema
	@Valid
	public CoEditing getCoEditing() {
		return coEditing;
	}

	public void setCoEditing(CoEditing coEditing) {
		this.coEditing = coEditing;
	}

	@JsonIgnore
	public void setCoEditing(
		UnsafeSupplier<CoEditing, Exception> coEditingUnsafeSupplier) {

		try {
			coEditing = coEditingUnsafeSupplier.get();
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
	protected CoEditing coEditing;

	@Schema
	@Valid
	public Object getEmbedded() {
		return embedded;
	}

	public void setEmbedded(Object embedded) {
		this.embedded = embedded;
	}

	@JsonIgnore
	public void setEmbedded(
		UnsafeSupplier<Object, Exception> embeddedUnsafeSupplier) {

		try {
			embedded = embeddedUnsafeSupplier.get();
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
	protected Object embedded;

	@Schema
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@JsonIgnore
	public void setLang(UnsafeSupplier<String, Exception> langUnsafeSupplier) {
		try {
			lang = langUnsafeSupplier.get();
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
	protected String lang;

	@Schema
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@JsonIgnore
	public void setLocation(
		UnsafeSupplier<String, Exception> locationUnsafeSupplier) {

		try {
			location = locationUnsafeSupplier.get();
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
	protected String location;

	@Schema
	@Valid
	public Mode getMode() {
		return mode;
	}

	@JsonIgnore
	public String getModeAsString() {
		if (mode == null) {
			return null;
		}

		return mode.toString();
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	@JsonIgnore
	public void setMode(UnsafeSupplier<Mode, Exception> modeUnsafeSupplier) {
		try {
			mode = modeUnsafeSupplier.get();
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
	protected Mode mode;

	@Schema
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@JsonIgnore
	public void setToken(
		UnsafeSupplier<String, Exception> tokenUnsafeSupplier) {

		try {
			token = tokenUnsafeSupplier.get();
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
	protected String token;

	@Schema
	@Valid
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	public void setUser(UnsafeSupplier<User, Exception> userUnsafeSupplier) {
		try {
			user = userUnsafeSupplier.get();
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
	protected User user;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EditorConfig)) {
			return false;
		}

		EditorConfig editorConfig = (EditorConfig)object;

		return Objects.equals(toString(), editorConfig.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (callbackUrl != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"callbackUrl\": ");

			sb.append("\"");

			sb.append(_escape(callbackUrl));

			sb.append("\"");
		}

		if (coEditing != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"coEditing\": ");

			sb.append(String.valueOf(coEditing));
		}

		if (embedded != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"embedded\": ");

			if (embedded instanceof Map) {
				sb.append(
					JSONFactoryUtil.createJSONObject((Map<?, ?>)embedded));
			}
			else if (embedded instanceof String) {
				sb.append("\"");
				sb.append(_escape((String)embedded));
				sb.append("\"");
			}
			else {
				sb.append(embedded);
			}
		}

		if (lang != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lang\": ");

			sb.append("\"");

			sb.append(_escape(lang));

			sb.append("\"");
		}

		if (location != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"location\": ");

			sb.append("\"");

			sb.append(_escape(location));

			sb.append("\"");
		}

		if (mode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mode\": ");

			sb.append("\"");

			sb.append(mode);

			sb.append("\"");
		}

		if (token != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"token\": ");

			sb.append("\"");

			sb.append(_escape(token));

			sb.append("\"");
		}

		if (user != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"user\": ");

			sb.append(String.valueOf(user));
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.common.files.manager.rest.dto.v2_0.EditorConfig",
		name = "x-class-name"
	)
	public String xClassName;

	@GraphQLName("Mode")
	public static enum Mode {

		EDIT("edit"), VIEW("view");

		@JsonCreator
		public static Mode create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (Mode mode : values()) {
				if (Objects.equals(mode.getValue(), value)) {
					return mode;
				}
			}

			throw new IllegalArgumentException("Invalid enum value: " + value);
		}

		@JsonValue
		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Mode(String value) {
			_value = value;
		}

		private final String _value;

	}

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