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

import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileSettingPermissionEntryModel;

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
 * The base model implementation for the DGFileSettingPermissionEntry service. Represents a row in the &quot;DG_FileSettingPermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DGFileSettingPermissionEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DGFileSettingPermissionEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileSettingPermissionEntryImpl
 * @generated
 */
public class DGFileSettingPermissionEntryModelImpl
	extends BaseModelImpl<DGFileSettingPermissionEntry>
	implements DGFileSettingPermissionEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dg file setting permission entry model instance should use the <code>DGFileSettingPermissionEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_FileSettingPermission";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"fileSettingPermissionId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"customerId", Types.BIGINT},
		{"creatorId", Types.BIGINT}, {"fileId", Types.BIGINT},
		{"permissionEditor", Types.BOOLEAN},
		{"permissionViewer", Types.BOOLEAN}, {"type_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileSettingPermissionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("customerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("permissionEditor", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("permissionViewer", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_FileSettingPermission (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,fileSettingPermissionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,customerId LONG,creatorId LONG,fileId LONG,permissionEditor BOOLEAN,permissionViewer BOOLEAN,type_ VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table DG_FileSettingPermission";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgFileSettingPermissionEntry.fileSettingPermissionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DG_FileSettingPermission.fileSettingPermissionId ASC";

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
	public static final long TYPE_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FILESETTINGPERMISSIONID_COLUMN_BITMASK = 128L;

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

	public DGFileSettingPermissionEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fileSettingPermissionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileSettingPermissionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileSettingPermissionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DGFileSettingPermissionEntry.class;
	}

	@Override
	public String getModelClassName() {
		return DGFileSettingPermissionEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DGFileSettingPermissionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DGFileSettingPermissionEntry, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileSettingPermissionEntry, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(DGFileSettingPermissionEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DGFileSettingPermissionEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DGFileSettingPermissionEntry, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DGFileSettingPermissionEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DGFileSettingPermissionEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DGFileSettingPermissionEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DGFileSettingPermissionEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DGFileSettingPermissionEntry.class.getClassLoader(),
			DGFileSettingPermissionEntry.class, ModelWrapper.class);

		try {
			Constructor<DGFileSettingPermissionEntry> constructor =
				(Constructor<DGFileSettingPermissionEntry>)
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
		<String, Function<DGFileSettingPermissionEntry, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<DGFileSettingPermissionEntry, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<DGFileSettingPermissionEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DGFileSettingPermissionEntry, Object>>();
		Map<String, BiConsumer<DGFileSettingPermissionEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<DGFileSettingPermissionEntry, ?>>();

		attributeGetterFunctions.put(
			"uuid", DGFileSettingPermissionEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<DGFileSettingPermissionEntry, String>)
				DGFileSettingPermissionEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode",
			DGFileSettingPermissionEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<DGFileSettingPermissionEntry, String>)
				DGFileSettingPermissionEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"fileSettingPermissionId",
			DGFileSettingPermissionEntry::getFileSettingPermissionId);
		attributeSetterBiConsumers.put(
			"fileSettingPermissionId",
			(BiConsumer<DGFileSettingPermissionEntry, Long>)
				DGFileSettingPermissionEntry::setFileSettingPermissionId);
		attributeGetterFunctions.put(
			"groupId", DGFileSettingPermissionEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DGFileSettingPermissionEntry, Long>)
				DGFileSettingPermissionEntry::setGroupId);
		attributeGetterFunctions.put(
			"companyId", DGFileSettingPermissionEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DGFileSettingPermissionEntry, Long>)
				DGFileSettingPermissionEntry::setCompanyId);
		attributeGetterFunctions.put(
			"userId", DGFileSettingPermissionEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DGFileSettingPermissionEntry, Long>)
				DGFileSettingPermissionEntry::setUserId);
		attributeGetterFunctions.put(
			"userName", DGFileSettingPermissionEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DGFileSettingPermissionEntry, String>)
				DGFileSettingPermissionEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", DGFileSettingPermissionEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DGFileSettingPermissionEntry, Date>)
				DGFileSettingPermissionEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", DGFileSettingPermissionEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DGFileSettingPermissionEntry, Date>)
				DGFileSettingPermissionEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"customerId", DGFileSettingPermissionEntry::getCustomerId);
		attributeSetterBiConsumers.put(
			"customerId",
			(BiConsumer<DGFileSettingPermissionEntry, Long>)
				DGFileSettingPermissionEntry::setCustomerId);
		attributeGetterFunctions.put(
			"creatorId", DGFileSettingPermissionEntry::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<DGFileSettingPermissionEntry, Long>)
				DGFileSettingPermissionEntry::setCreatorId);
		attributeGetterFunctions.put(
			"fileId", DGFileSettingPermissionEntry::getFileId);
		attributeSetterBiConsumers.put(
			"fileId",
			(BiConsumer<DGFileSettingPermissionEntry, Long>)
				DGFileSettingPermissionEntry::setFileId);
		attributeGetterFunctions.put(
			"permissionEditor",
			DGFileSettingPermissionEntry::getPermissionEditor);
		attributeSetterBiConsumers.put(
			"permissionEditor",
			(BiConsumer<DGFileSettingPermissionEntry, Boolean>)
				DGFileSettingPermissionEntry::setPermissionEditor);
		attributeGetterFunctions.put(
			"permissionViewer",
			DGFileSettingPermissionEntry::getPermissionViewer);
		attributeSetterBiConsumers.put(
			"permissionViewer",
			(BiConsumer<DGFileSettingPermissionEntry, Boolean>)
				DGFileSettingPermissionEntry::setPermissionViewer);
		attributeGetterFunctions.put(
			"type", DGFileSettingPermissionEntry::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<DGFileSettingPermissionEntry, String>)
				DGFileSettingPermissionEntry::setType);

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
	public long getFileSettingPermissionId() {
		return _fileSettingPermissionId;
	}

	@Override
	public void setFileSettingPermissionId(long fileSettingPermissionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileSettingPermissionId = fileSettingPermissionId;
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
	public boolean getPermissionEditor() {
		return _permissionEditor;
	}

	@Override
	public boolean isPermissionEditor() {
		return _permissionEditor;
	}

	@Override
	public void setPermissionEditor(boolean permissionEditor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_permissionEditor = permissionEditor;
	}

	@Override
	public boolean getPermissionViewer() {
		return _permissionViewer;
	}

	@Override
	public boolean isPermissionViewer() {
		return _permissionViewer;
	}

	@Override
	public void setPermissionViewer(boolean permissionViewer) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_permissionViewer = permissionViewer;
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
				DGFileSettingPermissionEntry.class.getName()));
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
			getCompanyId(), DGFileSettingPermissionEntry.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DGFileSettingPermissionEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DGFileSettingPermissionEntry>
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
		DGFileSettingPermissionEntryImpl dgFileSettingPermissionEntryImpl =
			new DGFileSettingPermissionEntryImpl();

		dgFileSettingPermissionEntryImpl.setUuid(getUuid());
		dgFileSettingPermissionEntryImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		dgFileSettingPermissionEntryImpl.setFileSettingPermissionId(
			getFileSettingPermissionId());
		dgFileSettingPermissionEntryImpl.setGroupId(getGroupId());
		dgFileSettingPermissionEntryImpl.setCompanyId(getCompanyId());
		dgFileSettingPermissionEntryImpl.setUserId(getUserId());
		dgFileSettingPermissionEntryImpl.setUserName(getUserName());
		dgFileSettingPermissionEntryImpl.setCreateDate(getCreateDate());
		dgFileSettingPermissionEntryImpl.setModifiedDate(getModifiedDate());
		dgFileSettingPermissionEntryImpl.setCustomerId(getCustomerId());
		dgFileSettingPermissionEntryImpl.setCreatorId(getCreatorId());
		dgFileSettingPermissionEntryImpl.setFileId(getFileId());
		dgFileSettingPermissionEntryImpl.setPermissionEditor(
			isPermissionEditor());
		dgFileSettingPermissionEntryImpl.setPermissionViewer(
			isPermissionViewer());
		dgFileSettingPermissionEntryImpl.setType(getType());

		dgFileSettingPermissionEntryImpl.resetOriginalValues();

		return dgFileSettingPermissionEntryImpl;
	}

	@Override
	public DGFileSettingPermissionEntry cloneWithOriginalValues() {
		DGFileSettingPermissionEntryImpl dgFileSettingPermissionEntryImpl =
			new DGFileSettingPermissionEntryImpl();

		dgFileSettingPermissionEntryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		dgFileSettingPermissionEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		dgFileSettingPermissionEntryImpl.setFileSettingPermissionId(
			this.<Long>getColumnOriginalValue("fileSettingPermissionId"));
		dgFileSettingPermissionEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		dgFileSettingPermissionEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		dgFileSettingPermissionEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		dgFileSettingPermissionEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		dgFileSettingPermissionEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		dgFileSettingPermissionEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		dgFileSettingPermissionEntryImpl.setCustomerId(
			this.<Long>getColumnOriginalValue("customerId"));
		dgFileSettingPermissionEntryImpl.setCreatorId(
			this.<Long>getColumnOriginalValue("creatorId"));
		dgFileSettingPermissionEntryImpl.setFileId(
			this.<Long>getColumnOriginalValue("fileId"));
		dgFileSettingPermissionEntryImpl.setPermissionEditor(
			this.<Boolean>getColumnOriginalValue("permissionEditor"));
		dgFileSettingPermissionEntryImpl.setPermissionViewer(
			this.<Boolean>getColumnOriginalValue("permissionViewer"));
		dgFileSettingPermissionEntryImpl.setType(
			this.<String>getColumnOriginalValue("type_"));

		return dgFileSettingPermissionEntryImpl;
	}

	@Override
	public int compareTo(
		DGFileSettingPermissionEntry dgFileSettingPermissionEntry) {

		long primaryKey = dgFileSettingPermissionEntry.getPrimaryKey();

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

		if (!(object instanceof DGFileSettingPermissionEntry)) {
			return false;
		}

		DGFileSettingPermissionEntry dgFileSettingPermissionEntry =
			(DGFileSettingPermissionEntry)object;

		long primaryKey = dgFileSettingPermissionEntry.getPrimaryKey();

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
	public CacheModel<DGFileSettingPermissionEntry> toCacheModel() {
		DGFileSettingPermissionEntryCacheModel
			dgFileSettingPermissionEntryCacheModel =
				new DGFileSettingPermissionEntryCacheModel();

		dgFileSettingPermissionEntryCacheModel.uuid = getUuid();

		String uuid = dgFileSettingPermissionEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dgFileSettingPermissionEntryCacheModel.uuid = null;
		}

		dgFileSettingPermissionEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			dgFileSettingPermissionEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			dgFileSettingPermissionEntryCacheModel.externalReferenceCode = null;
		}

		dgFileSettingPermissionEntryCacheModel.fileSettingPermissionId =
			getFileSettingPermissionId();

		dgFileSettingPermissionEntryCacheModel.groupId = getGroupId();

		dgFileSettingPermissionEntryCacheModel.companyId = getCompanyId();

		dgFileSettingPermissionEntryCacheModel.userId = getUserId();

		dgFileSettingPermissionEntryCacheModel.userName = getUserName();

		String userName = dgFileSettingPermissionEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dgFileSettingPermissionEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dgFileSettingPermissionEntryCacheModel.createDate =
				createDate.getTime();
		}
		else {
			dgFileSettingPermissionEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dgFileSettingPermissionEntryCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			dgFileSettingPermissionEntryCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		dgFileSettingPermissionEntryCacheModel.customerId = getCustomerId();

		dgFileSettingPermissionEntryCacheModel.creatorId = getCreatorId();

		dgFileSettingPermissionEntryCacheModel.fileId = getFileId();

		dgFileSettingPermissionEntryCacheModel.permissionEditor =
			isPermissionEditor();

		dgFileSettingPermissionEntryCacheModel.permissionViewer =
			isPermissionViewer();

		dgFileSettingPermissionEntryCacheModel.type = getType();

		String type = dgFileSettingPermissionEntryCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			dgFileSettingPermissionEntryCacheModel.type = null;
		}

		return dgFileSettingPermissionEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DGFileSettingPermissionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DGFileSettingPermissionEntry, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileSettingPermissionEntry, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(DGFileSettingPermissionEntry)this);

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
		Map<String, Function<DGFileSettingPermissionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DGFileSettingPermissionEntry, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileSettingPermissionEntry, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(DGFileSettingPermissionEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, DGFileSettingPermissionEntry>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _fileSettingPermissionId;
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
	private boolean _permissionEditor;
	private boolean _permissionViewer;
	private String _type;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DGFileSettingPermissionEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DGFileSettingPermissionEntry)this);
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
			"fileSettingPermissionId", _fileSettingPermissionId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("customerId", _customerId);
		_columnOriginalValues.put("creatorId", _creatorId);
		_columnOriginalValues.put("fileId", _fileId);
		_columnOriginalValues.put("permissionEditor", _permissionEditor);
		_columnOriginalValues.put("permissionViewer", _permissionViewer);
		_columnOriginalValues.put("type_", _type);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
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

		columnBitmasks.put("fileSettingPermissionId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("customerId", 512L);

		columnBitmasks.put("creatorId", 1024L);

		columnBitmasks.put("fileId", 2048L);

		columnBitmasks.put("permissionEditor", 4096L);

		columnBitmasks.put("permissionViewer", 8192L);

		columnBitmasks.put("type_", 16384L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DGFileSettingPermissionEntry _escapedModel;

}