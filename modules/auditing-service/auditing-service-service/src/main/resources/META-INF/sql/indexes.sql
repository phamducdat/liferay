create index IX_209CBC79 on DG_Auditing (classPkId, classPkName[$COLUMN_LENGTH:75$]);
create index IX_A026A35E on DG_Auditing (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_61669661 on DG_Auditing (parentPkId, parentPkName[$COLUMN_LENGTH:75$]);
create index IX_E9A71B3D on DG_Auditing (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F7C74CFF on DG_Auditing (uuid_[$COLUMN_LENGTH:75$], groupId);