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
@GraphQLName("AttachPermission")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "AttachPermission")
public class AttachPermission implements Serializable {

	public static AttachPermission toDTO(String json) {
		return ObjectMapperUtil.readValue(AttachPermission.class, json);
	}

	public static AttachPermission unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(AttachPermission.class, json);
	}

	@Schema
	@Valid
	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	@JsonIgnore
	public void setDepartments(
		UnsafeSupplier<Departments, Exception> departmentsUnsafeSupplier) {

		try {
			departments = departmentsUnsafeSupplier.get();
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
	protected Departments departments;

	@Schema
	@Valid
	public DepartmentsResponse[] getDepartmentsResponse() {
		return departmentsResponse;
	}

	public void setDepartmentsResponse(
		DepartmentsResponse[] departmentsResponse) {

		this.departmentsResponse = departmentsResponse;
	}

	@JsonIgnore
	public void setDepartmentsResponse(
		UnsafeSupplier<DepartmentsResponse[], Exception>
			departmentsResponseUnsafeSupplier) {

		try {
			departmentsResponse = departmentsResponseUnsafeSupplier.get();
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
	protected DepartmentsResponse[] departmentsResponse;

	@Schema
	@Valid
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@JsonIgnore
	public void setUsers(UnsafeSupplier<Users, Exception> usersUnsafeSupplier) {
		try {
			users = usersUnsafeSupplier.get();
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
	protected Users users;

	@Schema
	@Valid
	public UsersResponse[] getUsersResponse() {
		return usersResponse;
	}

	public void setUsersResponse(UsersResponse[] usersResponse) {
		this.usersResponse = usersResponse;
	}

	@JsonIgnore
	public void setUsersResponse(
		UnsafeSupplier<UsersResponse[], Exception>
			usersResponseUnsafeSupplier) {

		try {
			usersResponse = usersResponseUnsafeSupplier.get();
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
	protected UsersResponse[] usersResponse;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AttachPermission)) {
			return false;
		}

		AttachPermission attachPermission = (AttachPermission)object;

		return Objects.equals(toString(), attachPermission.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (departments != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departments\": ");

			sb.append(String.valueOf(departments));
		}

		if (departmentsResponse != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departmentsResponse\": ");

			sb.append("[");

			for (int i = 0; i < departmentsResponse.length; i++) {
				sb.append(String.valueOf(departmentsResponse[i]));

				if ((i + 1) < departmentsResponse.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (users != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"users\": ");

			sb.append(String.valueOf(users));
		}

		if (usersResponse != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"usersResponse\": ");

			sb.append("[");

			for (int i = 0; i < usersResponse.length; i++) {
				sb.append(String.valueOf(usersResponse[i]));

				if ((i + 1) < usersResponse.length) {
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
		defaultValue = "com.dogoo.common.files.manager.rest.dto.v2_0.AttachPermission",
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