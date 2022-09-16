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
 * The table class for the &quot;DG_DocumentManager&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DGDocumentManagerEntry
 * @generated
 */
public class DGDocumentManagerEntryTable
	extends BaseTable<DGDocumentManagerEntryTable> {

	public static final DGDocumentManagerEntryTable INSTANCE =
		new DGDocumentManagerEntryTable();

	public final Column<DGDocumentManagerEntryTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Long> documentManagerId =
		createColumn(
			"documentManagerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DGDocumentManagerEntryTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Long> customerId =
		createColumn(
			"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Long> creatorId =
		createColumn(
			"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> pkCode =
		createColumn(
			"pkCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Long> parentId =
		createColumn("parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> name =
		createColumn("name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> category =
		createColumn(
			"category", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> type =
		createColumn("type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Long> fileId =
		createColumn("fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> fileSize =
		createColumn(
			"fileSize", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> fileExtension =
		createColumn(
			"fileExtension", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> mineType =
		createColumn(
			"mineType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> path =
		createColumn("path_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> moduleId =
		createColumn(
			"moduleId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, String> appId =
		createColumn("appId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Long> departmentId =
		createColumn(
			"departmentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DGDocumentManagerEntryTable, Boolean> isPrivate =
		createColumn(
			"isPrivate", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private DGDocumentManagerEntryTable() {
		super("DG_DocumentManager", DGDocumentManagerEntryTable::new);
	}

}