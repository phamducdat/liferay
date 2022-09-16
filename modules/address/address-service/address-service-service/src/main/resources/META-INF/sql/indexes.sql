create index IX_9FB7095 on DG_AddressEntry (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_6C933674 on DG_AddressEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D29EC9F6 on DG_AddressEntry (uuid_[$COLUMN_LENGTH:75$], groupId);