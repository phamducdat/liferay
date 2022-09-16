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

package com.dogoo.common.files.manager.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DG_FileManager&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileManagerEntry
 * @generated
 */
public class DGFileManagerEntryTable
	extends BaseTable<DGFileManagerEntryTable> {

	public static final DGFileManagerEntryTable INSTANCE =
		new DGFileManagerEntryTable();

	public final Column<DGFileManagerEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, Long> fileManagerId =
		createColumn(
			"fileManagerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DGFileManagerEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, Long> customerId =
		createColumn(
			"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, Long> creatorId = createColumn(
		"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, Long> fileId = createColumn(
		"fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, String> parentCode =
		createColumn(
			"parentCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, String> fileType =
		createColumn(
			"fileType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, String> pkType = createColumn(
		"pkType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, String> fileName =
		createColumn(
			"fileName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, String> fileSize =
		createColumn(
			"fileSize", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, String> moduleId =
		createColumn(
			"moduleId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileManagerEntryTable, String> appId = createColumn(
		"appId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DGFileManagerEntryTable() {
		super("DG_FileManager", DGFileManagerEntryTable::new);
	}

}