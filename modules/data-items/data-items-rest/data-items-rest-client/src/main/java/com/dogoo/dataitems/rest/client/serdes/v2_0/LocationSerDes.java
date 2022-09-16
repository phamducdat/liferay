package com.dogoo.dataitems.rest.client.serdes.v2_0;

import com.dogoo.dataitems.rest.client.dto.v2_0.Location;
import com.dogoo.dataitems.rest.client.json.BaseJSONParser;

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
public class LocationSerDes {

	public static Location toDTO(String json) {
		LocationJSONParser locationJSONParser = new LocationJSONParser();

		return locationJSONParser.parseToDTO(json);
	}

	public static Location[] toDTOs(String json) {
		LocationJSONParser locationJSONParser = new LocationJSONParser();

		return locationJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Location location) {
		if (location == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (location.getDistrict() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"district\": ");

			sb.append("\"");

			sb.append(_escape(location.getDistrict()));

			sb.append("\"");
		}

		if (location.getDistrictCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"districtCode\": ");

			sb.append("\"");

			sb.append(_escape(location.getDistrictCode()));

			sb.append("\"");
		}

		if (location.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(location.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (location.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(location.getId());
		}

		if (location.getIsDefault() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isDefault\": ");

			sb.append(location.getIsDefault());
		}

		if (location.getProvince() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"province\": ");

			sb.append("\"");

			sb.append(_escape(location.getProvince()));

			sb.append("\"");
		}

		if (location.getProvinceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"provinceCode\": ");

			sb.append("\"");

			sb.append(_escape(location.getProvinceCode()));

			sb.append("\"");
		}

		if (location.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(location.getTitle()));

			sb.append("\"");
		}

		if (location.getWard() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ward\": ");

			sb.append("\"");

			sb.append(_escape(location.getWard()));

			sb.append("\"");
		}

		if (location.getWardCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"wardCode\": ");

			sb.append("\"");

			sb.append(_escape(location.getWardCode()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		LocationJSONParser locationJSONParser = new LocationJSONParser();

		return locationJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Location location) {
		if (location == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (location.getDistrict() == null) {
			map.put("district", null);
		}
		else {
			map.put("district", String.valueOf(location.getDistrict()));
		}

		if (location.getDistrictCode() == null) {
			map.put("districtCode", null);
		}
		else {
			map.put("districtCode", String.valueOf(location.getDistrictCode()));
		}

		if (location.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(location.getExternalReferenceCode()));
		}

		if (location.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(location.getId()));
		}

		if (location.getIsDefault() == null) {
			map.put("isDefault", null);
		}
		else {
			map.put("isDefault", String.valueOf(location.getIsDefault()));
		}

		if (location.getProvince() == null) {
			map.put("province", null);
		}
		else {
			map.put("province", String.valueOf(location.getProvince()));
		}

		if (location.getProvinceCode() == null) {
			map.put("provinceCode", null);
		}
		else {
			map.put("provinceCode", String.valueOf(location.getProvinceCode()));
		}

		if (location.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(location.getTitle()));
		}

		if (location.getWard() == null) {
			map.put("ward", null);
		}
		else {
			map.put("ward", String.valueOf(location.getWard()));
		}

		if (location.getWardCode() == null) {
			map.put("wardCode", null);
		}
		else {
			map.put("wardCode", String.valueOf(location.getWardCode()));
		}

		return map;
	}

	public static class LocationJSONParser extends BaseJSONParser<Location> {

		@Override
		protected Location createDTO() {
			return new Location();
		}

		@Override
		protected Location[] createDTOArray(int size) {
			return new Location[size];
		}

		@Override
		protected void setField(
			Location location, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "district")) {
				if (jsonParserFieldValue != null) {
					location.setDistrict((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "districtCode")) {
				if (jsonParserFieldValue != null) {
					location.setDistrictCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					location.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					location.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isDefault")) {
				if (jsonParserFieldValue != null) {
					location.setIsDefault((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "province")) {
				if (jsonParserFieldValue != null) {
					location.setProvince((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "provinceCode")) {
				if (jsonParserFieldValue != null) {
					location.setProvinceCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					location.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "ward")) {
				if (jsonParserFieldValue != null) {
					location.setWard((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "wardCode")) {
				if (jsonParserFieldValue != null) {
					location.setWardCode((String)jsonParserFieldValue);
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