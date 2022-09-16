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
 * The table class for the &quot;DG_FileGeneralPermission&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileGeneralPermissionEntry
 * @generated
 */
public class DGFileGeneralPermissionEntryTable
	extends BaseTable<DGFileGeneralPermissionEntryTable> {

	public static final DGFileGeneralPermissionEntryTable INSTANCE =
		new DGFileGeneralPermissionEntryTable();

	public final Column<DGFileGeneralPermissionEntryTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, Long>
		fileGeneralPermissionId = createColumn(
			"fileGeneralPermissionId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DGFileGeneralPermissionEntryTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, Long> customerId =
		createColumn(
			"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, Long> creatorId =
		createColumn(
			"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, Long> fileId =
		createColumn("fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, String> allowed =
		createColumn(
			"allowed", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, String> role =
		createColumn("role_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileGeneralPermissionEntryTable, String> type =
		createColumn("type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DGFileGeneralPermissionEntryTable() {
		super(
			"DG_FileGeneralPermission", DGFileGeneralPermissionEntryTable::new);
	}

}