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
@GraphQLName("SettingPermission")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "SettingPermission")
public class SettingPermission implements Serializable {

	public static SettingPermission toDTO(String json) {
		return ObjectMapperUtil.readValue(SettingPermission.class, json);
	}

	public static SettingPermission unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(SettingPermission.class, json);
	}

	@Schema
	public Boolean getPermissionEditor() {
		return permissionEditor;
	}

	public void setPermissionEditor(Boolean permissionEditor) {
		this.permissionEditor = permissionEditor;
	}

	@JsonIgnore
	public void setPermissionEditor(
		UnsafeSupplier<Boolean, Exception> permissionEditorUnsafeSupplier) {

		try {
			permissionEditor = permissionEditorUnsafeSupplier.get();
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
	protected Boolean permissionEditor;

	@Schema
	public Boolean getPermissionViewer() {
		return permissionViewer;
	}

	public void setPermissionViewer(Boolean permissionViewer) {
		this.permissionViewer = permissionViewer;
	}

	@JsonIgnore
	public void setPermissionViewer(
		UnsafeSupplier<Boolean, Exception> permissionViewerUnsafeSupplier) {

		try {
			permissionViewer = permissionViewerUnsafeSupplier.get();
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
	protected Boolean permissionViewer;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SettingPermission)) {
			return false;
		}

		SettingPermission settingPermission = (SettingPermission)object;

		return Objects.equals(toString(), settingPermission.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (permissionEditor != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"permissionEditor\": ");

			sb.append(permissionEditor);
		}

		if (permissionViewer != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"permissionViewer\": ");

			sb.append(permissionViewer);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.common.files.manager.rest.dto.v2_0.SettingPermission",
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