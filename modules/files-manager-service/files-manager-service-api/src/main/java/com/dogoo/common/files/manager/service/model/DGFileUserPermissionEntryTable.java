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
 * The table class for the &quot;DG_FileUserPermission&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileUserPermissionEntry
 * @generated
 */
public class DGFileUserPermissionEntryTable
	extends BaseTable<DGFileUserPermissionEntryTable> {

	public static final DGFileUserPermissionEntryTable INSTANCE =
		new DGFileUserPermissionEntryTable();

	public final Column<DGFileUserPermissionEntryTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, Long>
		fileUserPermissionId = createColumn(
			"fileUserPermissionId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DGFileUserPermissionEntryTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, Long> customerId =
		createColumn(
			"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, Long> creatorId =
		createColumn(
			"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, Long> fileId =
		createColumn("fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, Long> userAllowedId =
		createColumn(
			"userAllowedId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, String> role =
		createColumn("role_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, String> status =
		createColumn(
			"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileUserPermissionEntryTable, String> type =
		createColumn("type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DGFileUserPermissionEntryTable() {
		super("DG_FileUserPermission", DGFileUserPermissionEntryTable::new);
	}

}