create index IX_5E550D91 on DG_DocumentManager (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_E1655E7 on DG_DocumentManager (fileId);
create index IX_232FC691 on DG_DocumentManager (name[$COLUMN_LENGTH:500$], parentId, category[$COLUMN_LENGTH:75$], creatorId);
create index IX_32A915FB on DG_DocumentManager (name[$COLUMN_LENGTH:500$], parentId, fileExtension[$COLUMN_LENGTH:75$], pkCode[$COLUMN_LENGTH:75$]);
create index IX_BBB4ABB2 on DG_DocumentManager (name[$COLUMN_LENGTH:500$], type_[$COLUMN_LENGTH:75$], parentId, category[$COLUMN_LENGTH:75$], creatorId);
create index IX_EAFD6A36 on DG_DocumentManager (name[$COLUMN_LENGTH:500$], type_[$COLUMN_LENGTH:75$], pkCode[$COLUMN_LENGTH:75$], parentId, category[$COLUMN_LENGTH:75$], creatorId);
create index IX_79EE6A95 on DG_DocumentManager (parentId);
create index IX_FACC3F91 on DG_DocumentManager (pkCode[$COLUMN_LENGTH:75$], parentId);
create index IX_A5E4B70 on DG_DocumentManager (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F0E2EDF2 on DG_DocumentManager (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_116E5894 on DG_FileDepartmentPermission (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_247A111D on DG_FileDepartmentPermission (customerId, departmentId, fileId, type_[$COLUMN_LENGTH:75$]);
create index IX_1ED153E8 on DG_FileDepartmentPermission (customerId, departmentId, type_[$COLUMN_LENGTH:75$]);
create index IX_3982A0FE on DG_FileDepartmentPermission (customerId, fileId, type_[$COLUMN_LENGTH:75$]);
create index IX_32FBFC73 on DG_FileDepartmentPermission (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BC2F03B5 on DG_FileDepartmentPermission (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D6892ABA on DG_FileGeneralPermission (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_6C034D98 on DG_FileGeneralPermission (customerId, fileId, type_[$COLUMN_LENGTH:75$]);
create index IX_4E5BDA99 on DG_FileGeneralPermission (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9E1C335B on DG_FileGeneralPermission (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2C9C0890 on DG_FileManager (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_8A570273 on DG_FileManager (fileId, customerId);
create index IX_F021246F on DG_FileManager (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1F35FAB1 on DG_FileManager (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D6B3DEA2 on DG_FilePermission (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_65FB5E81 on DG_FilePermission (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_381B9143 on DG_FilePermission (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_DB8DFA22 on DG_FileSettingPermission (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_4BFB8330 on DG_FileSettingPermission (customerId, fileId, type_[$COLUMN_LENGTH:75$]);
create index IX_4D7C7A01 on DG_FileSettingPermission (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DC2D8CC3 on DG_FileSettingPermission (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C7EE6F4D on DG_FileUserPermission (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_CB027ABF on DG_FileUserPermission (customerId, fileId, status[$COLUMN_LENGTH:75$], type_[$COLUMN_LENGTH:75$]);
create index IX_1683B865 on DG_FileUserPermission (customerId, fileId, type_[$COLUMN_LENGTH:75$]);
create index IX_F8C0DD47 on DG_FileUserPermission (customerId, userAllowedId, fileId, type_[$COLUMN_LENGTH:75$]);
create index IX_58D0AF6C on DG_FileUserPermission (customerId, userAllowedId, status[$COLUMN_LENGTH:75$], type_[$COLUMN_LENGTH:75$]);
create index IX_A8D3EA12 on DG_FileUserPermission (customerId, userAllowedId, type_[$COLUMN_LENGTH:75$]);
create index IX_10AA52C on DG_FileUserPermission (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_351286AE on DG_FileUserPermission (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_BCB61C3B on DG_FileVersion (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_E2112E14 on DG_FileVersion (customerId, fileVersionId);
create index IX_6775EE1A on DG_FileVersion (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_41F7331C on DG_FileVersion (uuid_[$COLUMN_LENGTH:75$], groupId);