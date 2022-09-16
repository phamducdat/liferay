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
 * The table class for the &quot;DG_FilePermission&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DGFilePermissionEntry
 * @generated
 */
public class DGFilePermissionEntryTable
	extends BaseTable<DGFilePermissionEntryTable> {

	public static final DGFilePermissionEntryTable INSTANCE =
		new DGFilePermissionEntryTable();

	public final Column<DGFilePermissionEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, Long> filePermissionId =
		createColumn(
			"filePermissionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DGFilePermissionEntryTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, Long> customerId =
		createColumn(
			"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, Long> creatorId =
		createColumn(
			"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, Long> fileId = createColumn(
		"fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, String> generalPermission =
		createColumn(
			"generalPermission", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, String> role = createColumn(
		"role_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, Boolean>
		allowActionForEditor = createColumn(
			"allowActionForEditor", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionEntryTable, Boolean>
		allowActionForViewer = createColumn(
			"allowActionForViewer", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);

	private DGFilePermissionEntryTable() {
		super("DG_FilePermission", DGFilePermissionEntryTable::new);
	}

}