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

package com.dogoo.common.auditing.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DG_Auditing&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AuditingEntry
 * @generated
 */
public class AuditingEntryTable extends BaseTable<AuditingEntryTable> {

	public static final AuditingEntryTable INSTANCE = new AuditingEntryTable();

	public final Column<AuditingEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, Long> auditingId = createColumn(
		"auditingId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AuditingEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, Long> customerId = createColumn(
		"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, Long> creatorId = createColumn(
		"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, String> creatorName = createColumn(
		"creatorName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, String> eventType = createColumn(
		"eventType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, String> message = createColumn(
		"message", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, String> payload = createColumn(
		"payload", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, Long> classPkId = createColumn(
		"classPkId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, String> classPkName = createColumn(
		"classPkName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, Long> parentPkId = createColumn(
		"parentPkId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditingEntryTable, String> parentPkName = createColumn(
		"parentPkName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AuditingEntryTable() {
		super("DG_Auditing", AuditingEntryTable::new);
	}

}