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
 * The table class for the &quot;DG_FileDepartmentPermission&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DGFileDepartmentPermissionEntry
 * @generated
 */
public class DGFileDepartmentPermissionEntryTable
	extends BaseTable<DGFileDepartmentPermissionEntryTable> {

	public static final DGFileDepartmentPermissionEntryTable INSTANCE =
		new DGFileDepartmentPermissionEntryTable();

	public final Column<DGFileDepartmentPermissionEntryTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, Long>
		fileDepartmentPermissionId = createColumn(
			"fileDepartmentPermissionId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DGFileDepartmentPermissionEntryTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, Date>
		modifiedDate = createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, Long> customerId =
		createColumn(
			"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, Long> creatorId =
		createColumn(
			"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, Long> fileId =
		createColumn("fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, Long>
		departmentId = createColumn(
			"departmentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, String> role =
		createColumn("role_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFileDepartmentPermissionEntryTable, String> type =
		createColumn("type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DGFileDepartmentPermissionEntryTable() {
		super(
			"DG_FileDepartmentPermission",
			DGFileDepartmentPermissionEntryTable::new);
	}

}