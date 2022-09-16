create table DG_CommentEntry (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	commentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	creatorId LONG,
	classPkId LONG,
	classPkName VARCHAR(75) null,
	creatorFullName VARCHAR(75) null,
	content VARCHAR(75) null,
	parentId LONG
);

create table DG_EmoticonEntry (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	emoticonId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	creatorId LONG,
	classPkId LONG,
	classPkName VARCHAR(75) null,
	creatorFullName VARCHAR(75) null,
	emoji VARCHAR(75) null
);