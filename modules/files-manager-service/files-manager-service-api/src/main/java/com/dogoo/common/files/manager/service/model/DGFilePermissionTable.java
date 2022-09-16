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
 * @see DGFilePermission
 * @generated
 */
public class DGFilePermissionTable extends BaseTable<DGFilePermissionTable> {

	public static final DGFilePermissionTable INSTANCE =
		new DGFilePermissionTable();

	public final Column<DGFilePermissionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, Long> filePermissionId =
		createColumn(
			"filePermissionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DGFilePermissionTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, Long> customerId = createColumn(
		"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, Long> creatorId = createColumn(
		"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, Long> fileId = createColumn(
		"fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, String> generalPermission =
		createColumn(
			"generalPermission", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, String> role = createColumn(
		"role_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, Boolean> allowActionForEditor =
		createColumn(
			"allowActionForEditor", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<DGFilePermissionTable, Boolean> allowActionForViewer =
		createColumn(
			"allowActionForViewer", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);

	private DGFilePermissionTable() {
		super("DG_FilePermission", DGFilePermissionTable::new);
	}

}