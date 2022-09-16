create index IX_96FE928A on DG_CommentEntry (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_E90E8C8B on DG_CommentEntry (customerId, classPkId, classPkName[$COLUMN_LENGTH:75$], parentId);
create index IX_40CA0A8E on DG_CommentEntry (parentId);
create index IX_7DBAE269 on DG_CommentEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5A3AEF2B on DG_CommentEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_99209D0B on DG_EmoticonEntry (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_71DC6E44 on DG_EmoticonEntry (customerId, classPkId, classPkName[$COLUMN_LENGTH:75$], creatorId);
create index IX_8A1C0EEA on DG_EmoticonEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1A4F47EC on DG_EmoticonEntry (uuid_[$COLUMN_LENGTH:75$], groupId);