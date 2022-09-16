/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dogoo.address.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DG_AddressEntry&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AddressEntry
 * @generated
 */
public class AddressEntryTable extends BaseTable<AddressEntryTable> {

	public static final AddressEntryTable INSTANCE = new AddressEntryTable();

	public final Column<AddressEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, Long> addressId = createColumn(
		"addressId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AddressEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, Long> creatorId = createColumn(
		"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, Long> customerId = createColumn(
		"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> detail = createColumn(
		"detail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> postalCode = createColumn(
		"postalCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> ward = createColumn(
		"ward", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> district = createColumn(
		"district", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> province = createColumn(
		"province", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> country = createColumn(
		"country", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> wardCode = createColumn(
		"wardCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> districtCode = createColumn(
		"districtCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> provinceCode = createColumn(
		"provinceCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> countryCode = createColumn(
		"countryCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressEntryTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AddressEntryTable() {
		super("DG_AddressEntry", AddressEntryTable::new);
	}

}