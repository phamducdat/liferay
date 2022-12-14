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

import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileUserPermissionEntryModel;

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
 * The base model implementation for the DGFileUserPermissionEntry service. Represents a row in the &quot;DG_FileUserPermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DGFileUserPermissionEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DGFileUserPermissionEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileUserPermissionEntryImpl
 * @generated
 */
public class DGFileUserPermissionEntryModelImpl
	extends BaseModelImpl<DGFileUserPermissionEntry>
	implements DGFileUserPermissionEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dg file user permission entry model instance should use the <code>DGFileUserPermissionEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_FileUserPermission";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"fileUserPermissionId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"customerId", Types.BIGINT},
		{"creatorId", Types.BIGINT}, {"fileId", Types.BIGINT},
		{"userAllowedId", Types.BIGINT}, {"role_", Types.VARCHAR},
		{"status", Types.VARCHAR}, {"type_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileUserPermissionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("customerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userAllowedId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("role_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_FileUserPermission (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,fileUserPermissionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,customerId LONG,creatorId LONG,fileId LONG,userAllowedId LONG,role_ VARCHAR(75) null,status VARCHAR(75) null,type_ VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table DG_FileUserPermission";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgFileUserPermissionEntry.fileUserPermissionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DG_FileUserPermission.fileUserPermissionId ASC";

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
	public static final long FILEID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TYPE_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERALLOWEDID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 256L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FILEUSERPERMISSIONID_COLUMN_BITMASK = 512L;

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

	public DGFileUserPermissionEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fileUserPermissionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileUserPermissionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileUserPermissionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DGFileUserPermissionEntry.class;
	}

	@Override
	public String getModelClassName() {
		return DGFileUserPermissionEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DGFileUserPermissionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DGFileUserPermissionEntry, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileUserPermissionEntry, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DGFileUserPermissionEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DGFileUserPermissionEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DGFileUserPermissionEntry, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DGFileUserPermissionEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DGFileUserPermissionEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DGFileUserPermissionEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DGFileUserPermissionEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DGFileUserPermissionEntry.class.getClassLoader(),
			DGFileUserPermissionEntry.class, ModelWrapper.class);

		try {
			Constructor<DGFileUserPermissionEntry> constructor =
				(Constructor<DGFileUserPermissionEntry>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map
		<String, Function<DGFileUserPermissionEntry, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<DGFileUserPermissionEntry, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<DGFileUserPermissionEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DGFileUserPermissionEntry, Object>>();
		Map<String, BiConsumer<DGFileUserPermissionEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<DGFileUserPermissionEntry, ?>>();

		attributeGetterFunctions.put(
			"uuid", DGFileUserPermissionEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<DGFileUserPermissionEntry, String>)
				DGFileUserPermissionEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode",
			DGFileUserPermissionEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<DGFileUserPermissionEntry, String>)
				DGFileUserPermissionEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"fileUserPermissionId",
			DGFileUserPermissionEntry::getFileUserPermissionId);
		attributeSetterBiConsumers.put(
			"fileUserPermissionId",
			(BiConsumer<DGFileUserPermissionEntry, Long>)
				DGFileUserPermissionEntry::setFileUserPermissionId);
		attributeGetterFunctions.put(
			"groupId", DGFileUserPermissionEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DGFileUserPermissionEntry, Long>)
				DGFileUserPermissionEntry::setGroupId);
		attributeGetterFunctions.put(
			"companyId", DGFileUserPermissionEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DGFileUserPermissionEntry, Long>)
				DGFileUserPermissionEntry::setCompanyId);
		attributeGetterFunctions.put(
			"userId", DGFileUserPermissionEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DGFileUserPermissionEntry, Long>)
				DGFileUserPermissionEntry::setUserId);
		attributeGetterFunctions.put(
			"userName", DGFileUserPermissionEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DGFileUserPermissionEntry, String>)
				DGFileUserPermissionEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", DGFileUserPermissionEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DGFileUserPermissionEntry, Date>)
				DGFileUserPermissionEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", DGFileUserPermissionEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DGFileUserPermissionEntry, Date>)
				DGFileUserPermissionEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"customerId", DGFileUserPermissionEntry::getCustomerId);
		attributeSetterBiConsumers.put(
			"customerId",
			(BiConsumer<DGFileUserPermissionEntry, Long>)
				DGFileUserPermissionEntry::setCustomerId);
		attributeGetterFunctions.put(
			"creatorId", DGFileUserPermissionEntry::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<DGFileUserPermissionEntry, Long>)
				DGFileUserPermissionEntry::setCreatorId);
		attributeGetterFunctions.put(
			"fileId", DGFileUserPermissionEntry::getFileId);
		attributeSetterBiConsumers.put(
			"fileId",
			(BiConsumer<DGFileUserPermissionEntry, Long>)
				DGFileUserPermissionEntry::setFileId);
		attributeGetterFunctions.put(
			"userAllowedId", DGFileUserPermissionEntry::getUserAllowedId);
		attributeSetterBiConsumers.put(
			"userAllowedId",
			(BiConsumer<DGFileUserPermissionEntry, Long>)
				DGFileUserPermissionEntry::setUserAllowedId);
		attributeGetterFunctions.put(
			"role", DGFileUserPermissionEntry::getRole);
		attributeSetterBiConsumers.put(
			"role",
			(BiConsumer<DGFileUserPermissionEntry, String>)
				DGFileUserPermissionEntry::setRole);
		attributeGetterFunctions.put(
			"status", DGFileUserPermissionEntry::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<DGFileUserPermissionEntry, String>)
				DGFileUserPermissionEntry::setStatus);
		attributeGetterFunctions.put(
			"type", DGFileUserPermissionEntry::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<DGFileUserPermissionEntry, String>)
				DGFileUserPermissionEntry::setType);

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
	public long getFileUserPermissionId() {
		return _fileUserPermissionId;
	}

	@Override
	public void setFileUserPermissionId(long fileUserPermissionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileUserPermissionId = fileUserPermissionId;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalFileId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("fileId"));
	}

	@Override
	public long getUserAllowedId() {
		return _userAllowedId;
	}

	@Override
	public void setUserAllowedId(long userAllowedId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userAllowedId = userAllowedId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserAllowedId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("userAllowedId"));
	}

	@Override
	public String getRole() {
		if (_role == null) {
			return "";
		}
		else {
			return _role;
		}
	}

	@Override
	public void setRole(String role) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_role = role;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalStatus() {
		return getColumnOriginalValue("status");
	}

	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalType() {
		return getColumnOriginalValue("type_");
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				DGFileUserPermissionEntry.class.getName()));
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
			getCompanyId(), DGFileUserPermissionEntry.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DGFileUserPermissionEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DGFileUserPermissionEntry>
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
		DGFileUserPermissionEntryImpl dgFileUserPermissionEntryImpl =
			new DGFileUserPermissionEntryImpl();

		dgFileUserPermissionEntryImpl.setUuid(getUuid());
		dgFileUserPermissionEntryImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		dgFileUserPermissionEntryImpl.setFileUserPermissionId(
			getFileUserPermissionId());
		dgFileUserPermissionEntryImpl.setGroupId(getGroupId());
		dgFileUserPermissionEntryImpl.setCompanyId(getCompanyId());
		dgFileUserPermissionEntryImpl.setUserId(getUserId());
		dgFileUserPermissionEntryImpl.setUserName(getUserName());
		dgFileUserPermissionEntryImpl.setCreateDate(getCreateDate());
		dgFileUserPermissionEntryImpl.setModifiedDate(getModifiedDate());
		dgFileUserPermissionEntryImpl.setCustomerId(getCustomerId());
		dgFileUserPermissionEntryImpl.setCreatorId(getCreatorId());
		dgFileUserPermissionEntryImpl.setFileId(getFileId());
		dgFileUserPermissionEntryImpl.setUserAllowedId(getUserAllowedId());
		dgFileUserPermissionEntryImpl.setRole(getRole());
		dgFileUserPermissionEntryImpl.setStatus(getStatus());
		dgFileUserPermissionEntryImpl.setType(getType());

		dgFileUserPermissionEntryImpl.resetOriginalValues();

		return dgFileUserPermissionEntryImpl;
	}

	@Override
	public DGFileUserPermissionEntry cloneWithOriginalValues() {
		DGFileUserPermissionEntryImpl dgFileUserPermissionEntryImpl =
			new DGFileUserPermissionEntryImpl();

		dgFileUserPermissionEntryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		dgFileUserPermissionEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		dgFileUserPermissionEntryImpl.setFileUserPermissionId(
			this.<Long>getColumnOriginalValue("fileUserPermissionId"));
		dgFileUserPermissionEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		dgFileUserPermissionEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		dgFileUserPermissionEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		dgFileUserPermissionEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		dgFileUserPermissionEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		dgFileUserPermissionEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		dgFileUserPermissionEntryImpl.setCustomerId(
			this.<Long>getColumnOriginalValue("customerId"));
		dgFileUserPermissionEntryImpl.setCreatorId(
			this.<Long>getColumnOriginalValue("creatorId"));
		dgFileUserPermissionEntryImpl.setFileId(
			this.<Long>getColumnOriginalValue("fileId"));
		dgFileUserPermissionEntryImpl.setUserAllowedId(
			this.<Long>getColumnOriginalValue("userAllowedId"));
		dgFileUserPermissionEntryImpl.setRole(
			this.<String>getColumnOriginalValue("role_"));
		dgFileUserPermissionEntryImpl.setStatus(
			this.<String>getColumnOriginalValue("status"));
		dgFileUserPermissionEntryImpl.setType(
			this.<String>getColumnOriginalValue("type_"));

		return dgFileUserPermissionEntryImpl;
	}

	@Override
	public int compareTo(DGFileUserPermissionEntry dgFileUserPermissionEntry) {
		long primaryKey = dgFileUserPermissionEntry.getPrimaryKey();

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

		if (!(object instanceof DGFileUserPermissionEntry)) {
			return false;
		}

		DGFileUserPermissionEntry dgFileUserPermissionEntry =
			(DGFileUserPermissionEntry)object;

		long primaryKey = dgFileUserPermissionEntry.getPrimaryKey();

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
	public CacheModel<DGFileUserPermissionEntry> toCacheModel() {
		DGFileUserPermissionEntryCacheModel
			dgFileUserPermissionEntryCacheModel =
				new DGFileUserPermissionEntryCacheModel();

		dgFileUserPermissionEntryCacheModel.uuid = getUuid();

		String uuid = dgFileUserPermissionEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dgFileUserPermissionEntryCacheModel.uuid = null;
		}

		dgFileUserPermissionEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			dgFileUserPermissionEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			dgFileUserPermissionEntryCacheModel.externalReferenceCode = null;
		}

		dgFileUserPermissionEntryCacheModel.fileUserPermissionId =
			getFileUserPermissionId();

		dgFileUserPermissionEntryCacheModel.groupId = getGroupId();

		dgFileUserPermissionEntryCacheModel.companyId = getCompanyId();

		dgFileUserPermissionEntryCacheModel.userId = getUserId();

		dgFileUserPermissionEntryCacheModel.userName = getUserName();

		String userName = dgFileUserPermissionEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dgFileUserPermissionEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dgFileUserPermissionEntryCacheModel.createDate =
				createDate.getTime();
		}
		else {
			dgFileUserPermissionEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dgFileUserPermissionEntryCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			dgFileUserPermissionEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dgFileUserPermissionEntryCacheModel.customerId = getCustomerId();

		dgFileUserPermissionEntryCacheModel.creatorId = getCreatorId();

		dgFileUserPermissionEntryCacheModel.fileId = getFileId();

		dgFileUserPermissionEntryCacheModel.userAllowedId = getUserAllowedId();

		dgFileUserPermissionEntryCacheModel.role = getRole();

		String role = dgFileUserPermissionEntryCacheModel.role;

		if ((role != null) && (role.length() == 0)) {
			dgFileUserPermissionEntryCacheModel.role = null;
		}

		dgFileUserPermissionEntryCacheModel.status = getStatus();

		String status = dgFileUserPermissionEntryCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			dgFileUserPermissionEntryCacheModel.status = null;
		}

		dgFileUserPermissionEntryCacheModel.type = getType();

		String type = dgFileUserPermissionEntryCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			dgFileUserPermissionEntryCacheModel.type = null;
		}

		return dgFileUserPermissionEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DGFileUserPermissionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DGFileUserPermissionEntry, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileUserPermissionEntry, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(DGFileUserPermissionEntry)this);

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
		Map<String, Function<DGFileUserPermissionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DGFileUserPermissionEntry, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileUserPermissionEntry, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((DGFileUserPermissionEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, DGFileUserPermissionEntry>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _fileUserPermissionId;
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
	private long _userAllowedId;
	private String _role;
	private String _status;
	private String _type;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DGFileUserPermissionEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DGFileUserPermissionEntry)this);
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
		_columnOriginalValues.put(
			"fileUserPermissionId", _fileUserPermissionId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("customerId", _customerId);
		_columnOriginalValues.put("creatorId", _creatorId);
		_columnOriginalValues.put("fileId", _fileId);
		_columnOriginalValues.put("userAllowedId", _userAllowedId);
		_columnOriginalValues.put("role_", _role);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("type_", _type);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("role_", "role");
		attributeNames.put("type_", "type");

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

		columnBitmasks.put("fileUserPermissionId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("customerId", 512L);

		columnBitmasks.put("creatorId", 1024L);

		columnBitmasks.put("fileId", 2048L);

		columnBitmasks.put("userAllowedId", 4096L);

		columnBitmasks.put("role_", 8192L);

		columnBitmasks.put("status", 16384L);

		columnBitmasks.put("type_", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DGFileUserPermissionEntry _escapedModel;

}