/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dogoo.common.files.manager.service.model.impl;

import com.dogoo.common.files.manager.service.model.DGFileVersionEntry;
import com.dogoo.common.files.manager.service.model.DGFileVersionEntryModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DGFileVersionEntry service. Represents a row in the &quot;DG_FileVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DGFileVersionEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DGFileVersionEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileVersionEntryImpl
 * @generated
 */
public class DGFileVersionEntryModelImpl
	extends BaseModelImpl<DGFileVersionEntry>
	implements DGFileVersionEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dg file version entry model instance should use the <code>DGFileVersionEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_FileVersion";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"fileVersionId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"customerId", Types.BIGINT},
		{"creatorId", Types.BIGINT}, {"fileId", Types.BIGINT},
		{"accountId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileVersionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("customerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("accountId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_FileVersion (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,fileVersionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,customerId LONG,creatorId LONG,fileId LONG,accountId LONG)";

	public static final String TABLE_SQL_DROP = "drop table DG_FileVersion";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgFileVersionEntry.fileVersionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DG_FileVersion.fileVersionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CUSTOMERID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FILEVERSIONID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public DGFileVersionEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fileVersionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileVersionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileVersionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DGFileVersionEntry.class;
	}

	@Override
	public String getModelClassName() {
		return DGFileVersionEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DGFileVersionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DGFileVersionEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileVersionEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DGFileVersionEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DGFileVersionEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DGFileVersionEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DGFileVersionEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DGFileVersionEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DGFileVersionEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DGFileVersionEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DGFileVersionEntry.class.getClassLoader(), DGFileVersionEntry.class,
			ModelWrapper.class);

		try {
			Constructor<DGFileVersionEntry> constructor =
				(Constructor<DGFileVersionEntry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<DGFileVersionEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DGFileVersionEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DGFileVersionEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DGFileVersionEntry, Object>>();
		Map<String, BiConsumer<DGFileVersionEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<DGFileVersionEntry, ?>>();

		attributeGetterFunctions.put("uuid", DGFileVersionEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<DGFileVersionEntry, String>)
				DGFileVersionEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode",
			DGFileVersionEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<DGFileVersionEntry, String>)
				DGFileVersionEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"fileVersionId", DGFileVersionEntry::getFileVersionId);
		attributeSetterBiConsumers.put(
			"fileVersionId",
			(BiConsumer<DGFileVersionEntry, Long>)
				DGFileVersionEntry::setFileVersionId);
		attributeGetterFunctions.put("groupId", DGFileVersionEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DGFileVersionEntry, Long>)
				DGFileVersionEntry::setGroupId);
		attributeGetterFunctions.put(
			"companyId", DGFileVersionEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DGFileVersionEntry, Long>)
				DGFileVersionEntry::setCompanyId);
		attributeGetterFunctions.put("userId", DGFileVersionEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DGFileVersionEntry, Long>)
				DGFileVersionEntry::setUserId);
		attributeGetterFunctions.put(
			"userName", DGFileVersionEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DGFileVersionEntry, String>)
				DGFileVersionEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", DGFileVersionEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DGFileVersionEntry, Date>)
				DGFileVersionEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", DGFileVersionEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DGFileVersionEntry, Date>)
				DGFileVersionEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"customerId", DGFileVersionEntry::getCustomerId);
		attributeSetterBiConsumers.put(
			"customerId",
			(BiConsumer<DGFileVersionEntry, Long>)
				DGFileVersionEntry::setCustomerId);
		attributeGetterFunctions.put(
			"creatorId", DGFileVersionEntry::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<DGFileVersionEntry, Long>)
				DGFileVersionEntry::setCreatorId);
		attributeGetterFunctions.put("fileId", DGFileVersionEntry::getFileId);
		attributeSetterBiConsumers.put(
			"fileId",
			(BiConsumer<DGFileVersionEntry, Long>)
				DGFileVersionEntry::setFileId);
		attributeGetterFunctions.put(
			"accountId", DGFileVersionEntry::getAccountId);
		attributeSetterBiConsumers.put(
			"accountId",
			(BiConsumer<DGFileVersionEntry, Long>)
				DGFileVersionEntry::setAccountId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public String getExternalReferenceCode() {
		if (_externalReferenceCode == null) {
			return "";
		}
		else {
			return _externalReferenceCode;
		}
	}

	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_externalReferenceCode = externalReferenceCode;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalExternalReferenceCode() {
		return getColumnOriginalValue("externalReferenceCode");
	}

	@Override
	public long getFileVersionId() {
		return _fileVersionId;
	}

	@Override
	public void setFileVersionId(long fileVersionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileVersionId = fileVersionId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalFileVersionId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("fileVersionId"));
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getCustomerId() {
		return _customerId;
	}

	@Override
	public void setCustomerId(long customerId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_customerId = customerId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCustomerId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("customerId"));
	}

	@Override
	public long getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(long creatorId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_creatorId = creatorId;
	}

	@Override
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileId = fileId;
	}

	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_accountId = accountId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(DGFileVersionEntry.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DGFileVersionEntry.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DGFileVersionEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DGFileVersionEntry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DGFileVersionEntryImpl dgFileVersionEntryImpl =
			new DGFileVersionEntryImpl();

		dgFileVersionEntryImpl.setUuid(getUuid());
		dgFileVersionEntryImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		dgFileVersionEntryImpl.setFileVersionId(getFileVersionId());
		dgFileVersionEntryImpl.setGroupId(getGroupId());
		dgFileVersionEntryImpl.setCompanyId(getCompanyId());
		dgFileVersionEntryImpl.setUserId(getUserId());
		dgFileVersionEntryImpl.setUserName(getUserName());
		dgFileVersionEntryImpl.setCreateDate(getCreateDate());
		dgFileVersionEntryImpl.setModifiedDate(getModifiedDate());
		dgFileVersionEntryImpl.setCustomerId(getCustomerId());
		dgFileVersionEntryImpl.setCreatorId(getCreatorId());
		dgFileVersionEntryImpl.setFileId(getFileId());
		dgFileVersionEntryImpl.setAccountId(getAccountId());

		dgFileVersionEntryImpl.resetOriginalValues();

		return dgFileVersionEntryImpl;
	}

	@Override
	public DGFileVersionEntry cloneWithOriginalValues() {
		DGFileVersionEntryImpl dgFileVersionEntryImpl =
			new DGFileVersionEntryImpl();

		dgFileVersionEntryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		dgFileVersionEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		dgFileVersionEntryImpl.setFileVersionId(
			this.<Long>getColumnOriginalValue("fileVersionId"));
		dgFileVersionEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		dgFileVersionEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		dgFileVersionEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		dgFileVersionEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		dgFileVersionEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		dgFileVersionEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		dgFileVersionEntryImpl.setCustomerId(
			this.<Long>getColumnOriginalValue("customerId"));
		dgFileVersionEntryImpl.setCreatorId(
			this.<Long>getColumnOriginalValue("creatorId"));
		dgFileVersionEntryImpl.setFileId(
			this.<Long>getColumnOriginalValue("fileId"));
		dgFileVersionEntryImpl.setAccountId(
			this.<Long>getColumnOriginalValue("accountId"));

		return dgFileVersionEntryImpl;
	}

	@Override
	public int compareTo(DGFileVersionEntry dgFileVersionEntry) {
		long primaryKey = dgFileVersionEntry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DGFileVersionEntry)) {
			return false;
		}

		DGFileVersionEntry dgFileVersionEntry = (DGFileVersionEntry)object;

		long primaryKey = dgFileVersionEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<DGFileVersionEntry> toCacheModel() {
		DGFileVersionEntryCacheModel dgFileVersionEntryCacheModel =
			new DGFileVersionEntryCacheModel();

		dgFileVersionEntryCacheModel.uuid = getUuid();

		String uuid = dgFileVersionEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dgFileVersionEntryCacheModel.uuid = null;
		}

		dgFileVersionEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			dgFileVersionEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			dgFileVersionEntryCacheModel.externalReferenceCode = null;
		}

		dgFileVersionEntryCacheModel.fileVersionId = getFileVersionId();

		dgFileVersionEntryCacheModel.groupId = getGroupId();

		dgFileVersionEntryCacheModel.companyId = getCompanyId();

		dgFileVersionEntryCacheModel.userId = getUserId();

		dgFileVersionEntryCacheModel.userName = getUserName();

		String userName = dgFileVersionEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dgFileVersionEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dgFileVersionEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			dgFileVersionEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dgFileVersionEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dgFileVersionEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dgFileVersionEntryCacheModel.customerId = getCustomerId();

		dgFileVersionEntryCacheModel.creatorId = getCreatorId();

		dgFileVersionEntryCacheModel.fileId = getFileId();

		dgFileVersionEntryCacheModel.accountId = getAccountId();

		return dgFileVersionEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DGFileVersionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DGFileVersionEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileVersionEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(DGFileVersionEntry)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<DGFileVersionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DGFileVersionEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileVersionEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DGFileVersionEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DGFileVersionEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _fileVersionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _customerId;
	private long _creatorId;
	private long _fileId;
	private long _accountId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DGFileVersionEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DGFileVersionEntry)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put(
			"externalReferenceCode", _externalReferenceCode);
		_columnOriginalValues.put("fileVersionId", _fileVersionId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("customerId", _customerId);
		_columnOriginalValues.put("creatorId", _creatorId);
		_columnOriginalValues.put("fileId", _fileId);
		_columnOriginalValues.put("accountId", _accountId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("externalReferenceCode", 2L);

		columnBitmasks.put("fileVersionId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("customerId", 512L);

		columnBitmasks.put("creatorId", 1024L);

		columnBitmasks.put("fileId", 2048L);

		columnBitmasks.put("accountId", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DGFileVersionEntry _escapedModel;

}