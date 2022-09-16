create index IX_8B9AC511 on DG_BusinessEntry (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_D0BE3CC8 on DG_BusinessEntry (customerId, name[$COLUMN_LENGTH:75$]);
create index IX_3D0302F0 on DG_BusinessEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4C4F8572 on DG_BusinessEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_376BB4BF on DG_DepartmentEntry (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_7FD98C26 on DG_DepartmentEntry (customerId, businessId);
create index IX_A2FA086B on DG_DepartmentEntry (customerId, code_[$COLUMN_LENGTH:75$]);
create index IX_149C120F on DG_DepartmentEntry (customerId, name[$COLUMN_LENGTH:75$], parentId);
create index IX_DEA82A50 on DG_DepartmentEntry (customerId, parentId);
create index IX_8ECCF384 on DG_DepartmentEntry (customerId, tax[$COLUMN_LENGTH:75$]);
create index IX_1024EFB6 on DG_DepartmentEntry (name[$COLUMN_LENGTH:75$], customerId);
create index IX_724A0142 on DG_DepartmentEntry (name[$COLUMN_LENGTH:75$], parentId);
create index IX_ACD50E9E on DG_DepartmentEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EEECA4A0 on DG_DepartmentEntry (uuid_[$COLUMN_LENGTH:75$], groupId);