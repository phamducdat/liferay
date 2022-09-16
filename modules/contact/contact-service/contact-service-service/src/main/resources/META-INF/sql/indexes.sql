create index IX_A55A09E9 on DG_ContactEntry (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_65D6F7C8 on DG_ContactEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_26CAD04A on DG_ContactEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8031E4ED on DG_EmailEntry (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_A6F96486 on DG_EmailEntry (customerId, contactId);
create index IX_14888C91 on DG_EmailEntry (customerId, emailAddress[$COLUMN_LENGTH:75$]);
create index IX_4D692AC1 on DG_EmailEntry (customerId, isDefaulted);
create index IX_B92D5ACC on DG_EmailEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_43A6244E on DG_EmailEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_62A1A75B on DG_PhoneEntry (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_D90ADAD8 on DG_PhoneEntry (customerId, contactId);
create index IX_40F65493 on DG_PhoneEntry (customerId, isDefaulted);
create index IX_CFC93FB3 on DG_PhoneEntry (customerId, number_[$COLUMN_LENGTH:75$]);
create index IX_2F1BB93A on DG_PhoneEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_48D5463C on DG_PhoneEntry (uuid_[$COLUMN_LENGTH:75$], groupId);