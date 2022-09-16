package com.dogoo.common.files.manager.rest.dto.v2_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

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

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author khoa
 * @generated
 */
@Generated("")
@GraphQLName("GeneralPermission")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "GeneralPermission")
public class GeneralPermission implements Serializable {

	public static GeneralPermission toDTO(String json) {
		return ObjectMapperUtil.readValue(GeneralPermission.class, json);
	}

	public static GeneralPermission unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(GeneralPermission.class, json);
	}

	@Schema
	@Valid
	public Allowed getAllowed() {
		return allowed;
	}

	@JsonIgnore
	public String getAllowedAsString() {
		if (allowed == null) {
			return null;
		}

		return allowed.toString();
	}

	public void setAllowed(Allowed allowed) {
		this.allowed = allowed;
	}

	@JsonIgnore
	public void setAllowed(
		UnsafeSupplier<Allowed, Exception> allowedUnsafeSupplier) {

		try {
			allowed = allowedUnsafeSupplier.get();
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
	protected Allowed allowed;

	@Schema
	@Valid
	public Role getRole() {
		return role;
	}

	@JsonIgnore
	public String getRoleAsString() {
		if (role == null) {
			return null;
		}

		return role.toString();
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonIgnore
	public void setRole(UnsafeSupplier<Role, Exception> roleUnsafeSupplier) {
		try {
			role = roleUnsafeSupplier.get();
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
	protected Role role;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GeneralPermission)) {
			return false;
		}

		GeneralPermission generalPermission = (GeneralPermission)object;

		return Objects.equals(toString(), generalPermission.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (allowed != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"allowed\": ");

			sb.append("\"");

			sb.append(allowed);

			sb.append("\"");
		}

		if (role != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"role\": ");

			sb.append("\"");

			sb.append(role);

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.common.files.manager.rest.dto.v2_0.GeneralPermission",
		name = "x-class-name"
	)
	public String xClassName;

	@GraphQLName("Allowed")
	public static enum Allowed {

		ALL("all"), LIMIT("limit");

		@JsonCreator
		public static Allowed create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (Allowed allowed : values()) {
				if (Objects.equals(allowed.getValue(), value)) {
					return allowed;
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

		private Allowed(String value) {
			_value = value;
		}

		private final String _value;

	}

	@GraphQLName("Role")
	public static enum Role {

		VIEWER("viewer"), EDITOR("editor");

		@JsonCreator
		public static Role create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (Role role : values()) {
				if (Objects.equals(role.getValue(), value)) {
					return role;
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

		private Role(String value) {
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