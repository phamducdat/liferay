create index IX_602A67D4 on DG_DATAITEMENTRY (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_C7067C71 on DG_DATAITEMENTRY (customerId, parentId, name[$COLUMN_LENGTH:75$], type_[$COLUMN_LENGTH:75$]);
create index IX_998FF950 on DG_DATAITEMENTRY (customerId, parentId, type_[$COLUMN_LENGTH:75$]);
create index IX_383E8BB3 on DG_DATAITEMENTRY (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_134C62F5 on DG_DATAITEMENTRY (uuid_[$COLUMN_LENGTH:75$], groupId);