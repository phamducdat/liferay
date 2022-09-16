package com.dogoo.department.rest.client.serdes.v2_0;

import com.dogoo.department.rest.client.dto.v2_0.Department;
import com.dogoo.department.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public class DepartmentSerDes {

	public static Department toDTO(String json) {
		DepartmentJSONParser departmentJSONParser = new DepartmentJSONParser();

		return departmentJSONParser.parseToDTO(json);
	}

	public static Department[] toDTOs(String json) {
		DepartmentJSONParser departmentJSONParser = new DepartmentJSONParser();

		return departmentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Department department) {
		if (department == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (department.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(department.getAddress()));

			sb.append("\"");
		}

		if (department.getAlias() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"alias\": ");

			sb.append("\"");

			sb.append(_escape(department.getAlias()));

			sb.append("\"");
		}

		if (department.getBusiness() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"business\": ");

			sb.append(String.valueOf(department.getBusiness()));
		}

		if (department.getBusinessId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"businessId\": ");

			sb.append(department.getBusinessId());
		}

		if (department.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(department.getCode()));

			sb.append("\"");
		}

		if (department.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(department.getDescription()));

			sb.append("\"");
		}

		if (department.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(department.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (department.getHeadOffice() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"headOffice\": ");

			sb.append("\"");

			sb.append(_escape(department.getHeadOffice()));

			sb.append("\"");
		}

		if (department.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(department.getId());
		}

		if (department.getIsDeleted() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isDeleted\": ");

			sb.append(department.getIsDeleted());
		}

		if (department.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(department.getName()));

			sb.append("\"");
		}

		if (department.getOrder() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"order\": ");

			sb.append(department.getOrder());
		}

		if (department.getParentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(department.getParentId());
		}

		if (department.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(department.getStatus());

			sb.append("\"");
		}

		if (department.getStatusDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statusDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(department.getStatusDate()));

			sb.append("\"");
		}

		if (department.getTax() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tax\": ");

			sb.append("\"");

			sb.append(_escape(department.getTax()));

			sb.append("\"");
		}

		if (department.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(department.getType());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DepartmentJSONParser departmentJSONParser = new DepartmentJSONParser();

		return departmentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Department department) {
		if (department == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (department.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(department.getAddress()));
		}

		if (department.getAlias() == null) {
			map.put("alias", null);
		}
		else {
			map.put("alias", String.valueOf(department.getAlias()));
		}

		if (department.getBusiness() == null) {
			map.put("business", null);
		}
		else {
			map.put("business", String.valueOf(department.getBusiness()));
		}

		if (department.getBusinessId() == null) {
			map.put("businessId", null);
		}
		else {
			map.put("businessId", String.valueOf(department.getBusinessId()));
		}

		if (department.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(department.getCode()));
		}

		if (department.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(department.getDescription()));
		}

		if (department.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(department.getExternalReferenceCode()));
		}

		if (department.getHeadOffice() == null) {
			map.put("headOffice", null);
		}
		else {
			map.put("headOffice", String.valueOf(department.getHeadOffice()));
		}

		if (department.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(department.getId()));
		}

		if (department.getIsDeleted() == null) {
			map.put("isDeleted", null);
		}
		else {
			map.put("isDeleted", String.valueOf(department.getIsDeleted()));
		}

		if (department.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(department.getName()));
		}

		if (department.getOrder() == null) {
			map.put("order", null);
		}
		else {
			map.put("order", String.valueOf(department.getOrder()));
		}

		if (department.getParentId() == null) {
			map.put("parentId", null);
		}
		else {
			map.put("parentId", String.valueOf(department.getParentId()));
		}

		if (department.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(department.getStatus()));
		}

		if (department.getStatusDate() == null) {
			map.put("statusDate", null);
		}
		else {
			map.put(
				"statusDate",
				liferayToJSONDateFormat.format(department.getStatusDate()));
		}

		if (department.getTax() == null) {
			map.put("tax", null);
		}
		else {
			map.put("tax", String.valueOf(department.getTax()));
		}

		if (department.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(department.getType()));
		}

		return map;
	}

	public static class DepartmentJSONParser
		extends BaseJSONParser<Department> {

		@Override
		protected Department createDTO() {
			return new Department();
		}

		@Override
		protected Department[] createDTOArray(int size) {
			return new Department[size];
		}

		@Override
		protected void setField(
			Department department, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					department.setAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "alias")) {
				if (jsonParserFieldValue != null) {
					department.setAlias((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "business")) {
				if (jsonParserFieldValue != null) {
					department.setBusiness(
						BusinessSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "businessId")) {
				if (jsonParserFieldValue != null) {
					department.setBusinessId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					department.setCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					department.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					department.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "headOffice")) {
				if (jsonParserFieldValue != null) {
					department.setHeadOffice((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					department.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isDeleted")) {
				if (jsonParserFieldValue != null) {
					department.setIsDeleted((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					department.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "order")) {
				if (jsonParserFieldValue != null) {
					department.setOrder(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentId")) {
				if (jsonParserFieldValue != null) {
					department.setParentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					department.setStatus(
						Department.Status.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statusDate")) {
				if (jsonParserFieldValue != null) {
					department.setStatusDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tax")) {
				if (jsonParserFieldValue != null) {
					department.setTax((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					department.setType(
						Department.Type.create((String)jsonParserFieldValue));
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