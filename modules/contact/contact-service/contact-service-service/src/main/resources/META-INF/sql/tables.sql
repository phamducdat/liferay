create table DG_ContactEntry (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	contactId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	customerId LONG,
	facebook VARCHAR(75) null,
	twitter VARCHAR(75) null,
	linkedin VARCHAR(75) null
);

create table DG_EmailEntry (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	emailId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	customerId LONG,
	contactId LONG,
	emailAddress VARCHAR(75) null,
	isDefaulted BOOLEAN,
	description VARCHAR(75) null
);

create table DG_PhoneEntry (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	phoneId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	customerId LONG,
	contactId LONG,
	number_ VARCHAR(75) null,
	isDefaulted BOOLEAN,
	description VARCHAR(75) null
);