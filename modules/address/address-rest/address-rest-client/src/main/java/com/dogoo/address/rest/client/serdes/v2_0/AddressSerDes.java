package com.dogoo.address.rest.client.serdes.v2_0;

import com.dogoo.address.rest.client.dto.v2_0.Address;
import com.dogoo.address.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author datdt
 * @generated
 */
@Generated("")
public class AddressSerDes {

	public static Address toDTO(String json) {
		AddressJSONParser addressJSONParser = new AddressJSONParser();

		return addressJSONParser.parseToDTO(json);
	}

	public static Address[] toDTOs(String json) {
		AddressJSONParser addressJSONParser = new AddressJSONParser();

		return addressJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Address address) {
		if (address == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (address.getCountry() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"country\": ");

			sb.append("\"");

			sb.append(_escape(address.getCountry()));

			sb.append("\"");
		}

		if (address.getCountryCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"countryCode\": ");

			sb.append("\"");

			sb.append(_escape(address.getCountryCode()));

			sb.append("\"");
		}

		if (address.getDetail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"detail\": ");

			sb.append("\"");

			sb.append(_escape(address.getDetail()));

			sb.append("\"");
		}

		if (address.getDistrict() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"district\": ");

			sb.append("\"");

			sb.append(_escape(address.getDistrict()));

			sb.append("\"");
		}

		if (address.getDistrictCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"districtCode\": ");

			sb.append("\"");

			sb.append(_escape(address.getDistrictCode()));

			sb.append("\"");
		}

		if (address.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(address.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (address.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(address.getId());
		}

		if (address.getPostalCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"postalCode\": ");

			sb.append("\"");

			sb.append(_escape(address.getPostalCode()));

			sb.append("\"");
		}

		if (address.getProvince() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"province\": ");

			sb.append("\"");

			sb.append(_escape(address.getProvince()));

			sb.append("\"");
		}

		if (address.getProvinceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"provinceCode\": ");

			sb.append("\"");

			sb.append(_escape(address.getProvinceCode()));

			sb.append("\"");
		}

		if (address.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(address.getTitle()));

			sb.append("\"");
		}

		if (address.getWard() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ward\": ");

			sb.append("\"");

			sb.append(_escape(address.getWard()));

			sb.append("\"");
		}

		if (address.getWardCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"wardCode\": ");

			sb.append("\"");

			sb.append(_escape(address.getWardCode()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AddressJSONParser addressJSONParser = new AddressJSONParser();

		return addressJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Address address) {
		if (address == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (address.getCountry() == null) {
			map.put("country", null);
		}
		else {
			map.put("country", String.valueOf(address.getCountry()));
		}

		if (address.getCountryCode() == null) {
			map.put("countryCode", null);
		}
		else {
			map.put("countryCode", String.valueOf(address.getCountryCode()));
		}

		if (address.getDetail() == null) {
			map.put("detail", null);
		}
		else {
			map.put("detail", String.valueOf(address.getDetail()));
		}

		if (address.getDistrict() == null) {
			map.put("district", null);
		}
		else {
			map.put("district", String.valueOf(address.getDistrict()));
		}

		if (address.getDistrictCode() == null) {
			map.put("districtCode", null);
		}
		else {
			map.put("districtCode", String.valueOf(address.getDistrictCode()));
		}

		if (address.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(address.getExternalReferenceCode()));
		}

		if (address.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(address.getId()));
		}

		if (address.getPostalCode() == null) {
			map.put("postalCode", null);
		}
		else {
			map.put("postalCode", String.valueOf(address.getPostalCode()));
		}

		if (address.getProvince() == null) {
			map.put("province", null);
		}
		else {
			map.put("province", String.valueOf(address.getProvince()));
		}

		if (address.getProvinceCode() == null) {
			map.put("provinceCode", null);
		}
		else {
			map.put("provinceCode", String.valueOf(address.getProvinceCode()));
		}

		if (address.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(address.getTitle()));
		}

		if (address.getWard() == null) {
			map.put("ward", null);
		}
		else {
			map.put("ward", String.valueOf(address.getWard()));
		}

		if (address.getWardCode() == null) {
			map.put("wardCode", null);
		}
		else {
			map.put("wardCode", String.valueOf(address.getWardCode()));
		}

		return map;
	}

	public static class AddressJSONParser extends BaseJSONParser<Address> {

		@Override
		protected Address createDTO() {
			return new Address();
		}

		@Override
		protected Address[] createDTOArray(int size) {
			return new Address[size];
		}

		@Override
		protected void setField(
			Address address, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "country")) {
				if (jsonParserFieldValue != null) {
					address.setCountry((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "countryCode")) {
				if (jsonParserFieldValue != null) {
					address.setCountryCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "detail")) {
				if (jsonParserFieldValue != null) {
					address.setDetail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "district")) {
				if (jsonParserFieldValue != null) {
					address.setDistrict((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "districtCode")) {
				if (jsonParserFieldValue != null) {
					address.setDistrictCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					address.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					address.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "postalCode")) {
				if (jsonParserFieldValue != null) {
					address.setPostalCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "province")) {
				if (jsonParserFieldValue != null) {
					address.setProvince((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "provinceCode")) {
				if (jsonParserFieldValue != null) {
					address.setProvinceCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					address.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "ward")) {
				if (jsonParserFieldValue != null) {
					address.setWard((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "wardCode")) {
				if (jsonParserFieldValue != null) {
					address.setWardCode((String)jsonParserFieldValue);
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