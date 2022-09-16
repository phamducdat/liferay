package com.dogoo.dataitems.rest.client.serdes.v2_0;

import com.dogoo.dataitems.rest.client.dto.v2_0.DataItem;
import com.dogoo.dataitems.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public class DataItemSerDes {

	public static DataItem toDTO(String json) {
		DataItemJSONParser dataItemJSONParser = new DataItemJSONParser();

		return dataItemJSONParser.parseToDTO(json);
	}

	public static DataItem[] toDTOs(String json) {
		DataItemJSONParser dataItemJSONParser = new DataItemJSONParser();

		return dataItemJSONParser.parseToDTOs(json);
	}

	public static String toJSON(DataItem dataItem) {
		if (dataItem == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (dataItem.getDataItems() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataItems\": ");

			sb.append("[");

			for (int i = 0; i < dataItem.getDataItems().length; i++) {
				sb.append(String.valueOf(dataItem.getDataItems()[i]));

				if ((i + 1) < dataItem.getDataItems().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (dataItem.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(dataItem.getDescription()));

			sb.append("\"");
		}

		if (dataItem.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(dataItem.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (dataItem.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(dataItem.getId());
		}

		if (dataItem.getIsDefault() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isDefault\": ");

			sb.append(dataItem.getIsDefault());
		}

		if (dataItem.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(dataItem.getName()));

			sb.append("\"");
		}

		if (dataItem.getOrder() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"order\": ");

			sb.append(dataItem.getOrder());
		}

		if (dataItem.getParentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(dataItem.getParentId());
		}

		if (dataItem.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(_escape(dataItem.getType()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DataItemJSONParser dataItemJSONParser = new DataItemJSONParser();

		return dataItemJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(DataItem dataItem) {
		if (dataItem == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (dataItem.getDataItems() == null) {
			map.put("dataItems", null);
		}
		else {
			map.put("dataItems", String.valueOf(dataItem.getDataItems()));
		}

		if (dataItem.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(dataItem.getDescription()));
		}

		if (dataItem.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(dataItem.getExternalReferenceCode()));
		}

		if (dataItem.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(dataItem.getId()));
		}

		if (dataItem.getIsDefault() == null) {
			map.put("isDefault", null);
		}
		else {
			map.put("isDefault", String.valueOf(dataItem.getIsDefault()));
		}

		if (dataItem.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(dataItem.getName()));
		}

		if (dataItem.getOrder() == null) {
			map.put("order", null);
		}
		else {
			map.put("order", String.valueOf(dataItem.getOrder()));
		}

		if (dataItem.getParentId() == null) {
			map.put("parentId", null);
		}
		else {
			map.put("parentId", String.valueOf(dataItem.getParentId()));
		}

		if (dataItem.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(dataItem.getType()));
		}

		return map;
	}

	public static class DataItemJSONParser extends BaseJSONParser<DataItem> {

		@Override
		protected DataItem createDTO() {
			return new DataItem();
		}

		@Override
		protected DataItem[] createDTOArray(int size) {
			return new DataItem[size];
		}

		@Override
		protected void setField(
			DataItem dataItem, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "dataItems")) {
				if (jsonParserFieldValue != null) {
					dataItem.setDataItems(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> DataItemSerDes.toDTO((String)object)
						).toArray(
							size -> new DataItem[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					dataItem.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					dataItem.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					dataItem.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isDefault")) {
				if (jsonParserFieldValue != null) {
					dataItem.setIsDefault((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					dataItem.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "order")) {
				if (jsonParserFieldValue != null) {
					dataItem.setOrder(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentId")) {
				if (jsonParserFieldValue != null) {
					dataItem.setParentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					dataItem.setType((String)jsonParserFieldValue);
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