package com.dogoo.dataitems.rest.client.dto.v2_0;

import com.dogoo.dataitems.rest.client.function.UnsafeSupplier;
import com.dogoo.dataitems.rest.client.serdes.v2_0.InitDataItemSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author khoa
 * @generated
 */
@Generated("")
public class InitDataItem implements Cloneable, Serializable {

	public static InitDataItem toDTO(String json) {
		return InitDataItemSerDes.toDTO(json);
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerId(
		UnsafeSupplier<Long, Exception> customerIdUnsafeSupplier) {

		try {
			customerId = customerIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long customerId;

	public DataItem[] getDataItems() {
		return dataItems;
	}

	public void setDataItems(DataItem[] dataItems) {
		this.dataItems = dataItems;
	}

	public void setDataItems(
		UnsafeSupplier<DataItem[], Exception> dataItemsUnsafeSupplier) {

		try {
			dataItems = dataItemsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected DataItem[] dataItems;

	@Override
	public InitDataItem clone() throws CloneNotSupportedException {
		return (InitDataItem)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InitDataItem)) {
			return false;
		}

		InitDataItem initDataItem = (InitDataItem)object;

		return Objects.equals(toString(), initDataItem.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return InitDataItemSerDes.toJSON(this);
	}

}