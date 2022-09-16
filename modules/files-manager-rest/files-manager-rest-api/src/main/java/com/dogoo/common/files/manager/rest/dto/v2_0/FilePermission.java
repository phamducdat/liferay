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

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author khoa
 * @generated
 */
@Generated("")
@GraphQLName("FilePermission")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "FilePermission")
public class FilePermission implements Serializable {

	public static FilePermission toDTO(String json) {
		return ObjectMapperUtil.readValue(FilePermission.class, json);
	}

	public static FilePermission unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(FilePermission.class, json);
	}

	@Schema
	@Valid
	public AttachPermission getAttachPermission() {
		return attachPermission;
	}

	public void setAttachPermission(AttachPermission attachPermission) {
		this.attachPermission = attachPermission;
	}

	@JsonIgnore
	public void setAttachPermission(
		UnsafeSupplier<AttachPermission, Exception>
			attachPermissionUnsafeSupplier) {

		try {
			attachPermission = attachPermissionUnsafeSupplier.get();
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
	protected AttachPermission attachPermission;

	@Schema
	@Valid
	public GeneralPermission getGeneralPermission() {
		return generalPermission;
	}

	public void setGeneralPermission(GeneralPermission generalPermission) {
		this.generalPermission = generalPermission;
	}

	@JsonIgnore
	public void setGeneralPermission(
		UnsafeSupplier<GeneralPermission, Exception>
			generalPermissionUnsafeSupplier) {

		try {
			generalPermission = generalPermissionUnsafeSupplier.get();
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
	protected GeneralPermission generalPermission;

	@Schema
	@Valid
	public SettingPermission getSettingPermission() {
		return settingPermission;
	}

	public void setSettingPermission(SettingPermission settingPermission) {
		this.settingPermission = settingPermission;
	}

	@JsonIgnore
	public void setSettingPermission(
		UnsafeSupplier<SettingPermission, Exception>
			settingPermissionUnsafeSupplier) {

		try {
			settingPermission = settingPermissionUnsafeSupplier.get();
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
	protected SettingPermission settingPermission;

	@Schema
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonIgnore
	public void setType(UnsafeSupplier<String, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
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
	protected String type;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FilePermission)) {
			return false;
		}

		FilePermission filePermission = (FilePermission)object;

		return Objects.equals(toString(), filePermission.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (attachPermission != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"attachPermission\": ");

			sb.append(String.valueOf(attachPermission));
		}

		if (generalPermission != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"generalPermission\": ");

			sb.append(String.valueOf(generalPermission));
		}

		if (settingPermission != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"settingPermission\": ");

			sb.append(String.valueOf(settingPermission));
		}

		if (type != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(_escape(type));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.common.files.manager.rest.dto.v2_0.FilePermission",
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