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
@GraphQLName("Events")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Events")
public class Events implements Serializable {

	public static Events toDTO(String json) {
		return ObjectMapperUtil.readValue(Events.class, json);
	}

	public static Events unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Events.class, json);
	}

	@Schema
	@Valid
	public RefreshHistory getRefreshHistory() {
		return refreshHistory;
	}

	public void setRefreshHistory(RefreshHistory refreshHistory) {
		this.refreshHistory = refreshHistory;
	}

	@JsonIgnore
	public void setRefreshHistory(
		UnsafeSupplier<RefreshHistory, Exception>
			refreshHistoryUnsafeSupplier) {

		try {
			refreshHistory = refreshHistoryUnsafeSupplier.get();
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
	protected RefreshHistory refreshHistory;

	@Schema
	@Valid
	public SetHistoryData[] getSetHistoryData() {
		return setHistoryData;
	}

	public void setSetHistoryData(SetHistoryData[] setHistoryData) {
		this.setHistoryData = setHistoryData;
	}

	@JsonIgnore
	public void setSetHistoryData(
		UnsafeSupplier<SetHistoryData[], Exception>
			setHistoryDataUnsafeSupplier) {

		try {
			setHistoryData = setHistoryDataUnsafeSupplier.get();
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
	protected SetHistoryData[] setHistoryData;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Events)) {
			return false;
		}

		Events events = (Events)object;

		return Objects.equals(toString(), events.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (refreshHistory != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"refreshHistory\": ");

			sb.append(String.valueOf(refreshHistory));
		}

		if (setHistoryData != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"setHistoryData\": ");

			sb.append("[");

			for (int i = 0; i < setHistoryData.length; i++) {
				sb.append(String.valueOf(setHistoryData[i]));

				if ((i + 1) < setHistoryData.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.dogoo.common.files.manager.rest.dto.v2_0.Events",
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