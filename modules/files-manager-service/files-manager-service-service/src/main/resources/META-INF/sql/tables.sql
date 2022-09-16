create table DG_DocumentManager (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	documentManagerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	creatorId LONG,
	pkCode VARCHAR(75) null,
	parentId LONG,
	name VARCHAR(500) null,
	category VARCHAR(75) null,
	type_ VARCHAR(75) null,
	fileId LONG,
	fileSize VARCHAR(75) null,
	fileExtension VARCHAR(75) null,
	mineType VARCHAR(75) null,
	path_ VARCHAR(75) null,
	moduleId VARCHAR(75) null,
	appId VARCHAR(75) null,
	departmentId LONG,
	isPrivate BOOLEAN
);

create table DG_FileDepartmentPermission (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	fileDepartmentPermissionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	creatorId LONG,
	fileId LONG,
	departmentId LONG,
	role_ VARCHAR(75) null,
	type_ VARCHAR(75) null
);

create table DG_FileGeneralPermission (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	fileGeneralPermissionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	creatorId LONG,
	fileId LONG,
	allowed VARCHAR(75) null,
	role_ VARCHAR(75) null,
	type_ VARCHAR(75) null
);

create table DG_FileManager (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	fileManagerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	creatorId LONG,
	fileId LONG,
	parentCode VARCHAR(75) null,
	fileType VARCHAR(75) null,
	type_ VARCHAR(75) null,
	pkType VARCHAR(75) null,
	fileName VARCHAR(500) null,
	fileSize VARCHAR(75) null,
	moduleId VARCHAR(75) null,
	appId VARCHAR(75) null
);

create table DG_FilePermission (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	filePermissionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	creatorId LONG,
	fileId LONG,
	generalPermission VARCHAR(75) null,
	role_ VARCHAR(75) null,
	allowActionForEditor BOOLEAN,
	allowActionForViewer BOOLEAN
);

create table DG_FileSettingPermission (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	fileSettingPermissionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	creatorId LONG,
	fileId LONG,
	permissionEditor BOOLEAN,
	permissionViewer BOOLEAN,
	type_ VARCHAR(75) null
);

create table DG_FileUserPermission (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	fileUserPermissionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	creatorId LONG,
	fileId LONG,
	userAllowedId LONG,
	role_ VARCHAR(75) null,
	status VARCHAR(75) null,
	type_ VARCHAR(75) null
);

create table DG_FileVersion (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	fileVersionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	creatorId LONG,
	fileId LONG,
	accountId LONG
);