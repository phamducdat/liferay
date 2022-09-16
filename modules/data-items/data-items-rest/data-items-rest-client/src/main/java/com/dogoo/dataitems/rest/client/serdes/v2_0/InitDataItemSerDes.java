package com.dogoo.dataitems.rest.client.serdes.v2_0;

import com.dogoo.dataitems.rest.client.dto.v2_0.DataItem;
import com.dogoo.dataitems.rest.client.dto.v2_0.InitDataItem;
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
public class InitDataItemSerDes {

	public static InitDataItem toDTO(String json) {
		InitDataItemJSONParser initDataItemJSONParser =
			new InitDataItemJSONParser();

		return initDataItemJSONParser.parseToDTO(json);
	}

	public static InitDataItem[] toDTOs(String json) {
		InitDataItemJSONParser initDataItemJSONParser =
			new InitDataItemJSONParser();

		return initDataItemJSONParser.parseToDTOs(json);
	}

	public static String toJSON(InitDataItem initDataItem) {
		if (initDataItem == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (initDataItem.getCustomerId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"customerId\": ");

			sb.append(initDataItem.getCustomerId());
		}

		if (initDataItem.getDataItems() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataItems\": ");

			sb.append("[");

			for (int i = 0; i < initDataItem.getDataItems().length; i++) {
				sb.append(String.valueOf(initDataItem.getDataItems()[i]));

				if ((i + 1) < initDataItem.getDataItems().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		InitDataItemJSONParser initDataItemJSONParser =
			new InitDataItemJSONParser();

		return initDataItemJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(InitDataItem initDataItem) {
		if (initDataItem == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (initDataItem.getCustomerId() == null) {
			map.put("customerId", null);
		}
		else {
			map.put("customerId", String.valueOf(initDataItem.getCustomerId()));
		}

		if (initDataItem.getDataItems() == null) {
			map.put("dataItems", null);
		}
		else {
			map.put("dataItems", String.valueOf(initDataItem.getDataItems()));
		}

		return map;
	}

	public static class InitDataItemJSONParser
		extends BaseJSONParser<InitDataItem> {

		@Override
		protected InitDataItem createDTO() {
			return new InitDataItem();
		}

		@Override
		protected InitDataItem[] createDTOArray(int size) {
			return new InitDataItem[size];
		}

		@Override
		protected void setField(
			InitDataItem initDataItem, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "customerId")) {
				if (jsonParserFieldValue != null) {
					initDataItem.setCustomerId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dataItems")) {
				if (jsonParserFieldValue != null) {
					initDataItem.setDataItems(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> DataItemSerDes.toDTO((String)object)
						).toArray(
							size -> new DataItem[size]
						));
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