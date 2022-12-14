create table DG_BusinessEntry (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	businessId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	customerId LONG,
	name VARCHAR(75) null
);

create table DG_DepartmentEntry (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	departmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	customerId LONG,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	parentId LONG,
	order_ INTEGER,
	type_ VARCHAR(75) null,
	businessId LONG,
	tax VARCHAR(75) null,
	address VARCHAR(75) null,
	headOffice VARCHAR(75) null,
	alias_ VARCHAR(75) null,
	description VARCHAR(75) null,
	status VARCHAR(75) null,
	statusDate DATE null
);