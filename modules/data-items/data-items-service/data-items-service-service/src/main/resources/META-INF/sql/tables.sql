create table DG_DATAITEMENTRY (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	dataItemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	customerId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	order_ LONG,
	type_ VARCHAR(75) null,
	parentId LONG,
	isDefaultValue BOOLEAN
);