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

import com.dogoo.common.files.manager.service.model.DGFilePermission;
import com.dogoo.common.files.manager.service.model.DGFilePermissionModel;

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
 * The base model implementation for the DGFilePermission service. Represents a row in the &quot;DG_FilePermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DGFilePermissionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DGFilePermissionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFilePermissionImpl
 * @generated
 */
public class DGFilePermissionModelImpl
	extends BaseModelImpl<DGFilePermission> implements DGFilePermissionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dg file permission model instance should use the <code>DGFilePermission</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_FilePermission";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"filePermissionId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"customerId", Types.BIGINT},
		{"creatorId", Types.BIGINT}, {"fileId", Types.BIGINT},
		{"generalPermission", Types.VARCHAR}, {"role_", Types.VARCHAR},
		{"allowActionForEditor", Types.BOOLEAN},
		{"allowActionForViewer", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("filePermissionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("customerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("generalPermission", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("role_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("allowActionForEditor", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("allowActionForViewer", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_FilePermission (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,filePermissionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,customerId LONG,creatorId LONG,fileId LONG,generalPermission VARCHAR(75) null,role_ VARCHAR(75) null,allowActionForEditor BOOLEAN,allowActionForViewer BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table DG_FilePermission";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgFilePermission.filePermissionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DG_FilePermission.filePermissionId ASC";

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
	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FILEPERMISSIONID_COLUMN_BITMASK = 16L;

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

	public DGFilePermissionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _filePermissionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFilePermissionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _filePermissionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DGFilePermission.class;
	}

	@Override
	public String getModelClassName() {
		return DGFilePermission.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DGFilePermission, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DGFilePermission, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFilePermission, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DGFilePermission)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DGFilePermission, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DGFilePermission, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DGFilePermission)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DGFilePermission, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DGFilePermission, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DGFilePermission>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DGFilePermission.class.getClassLoader(), DGFilePermission.class,
			ModelWrapper.class);

		try {
			Constructor<DGFilePermission> constructor =
				(Constructor<DGFilePermission>)proxyClass.getConstructor(
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

	private static final Map<String, Function<DGFilePermission, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DGFilePermission, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DGFilePermission, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<DGFilePermission, Object>>();
		Map<String, BiConsumer<DGFilePermission, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<DGFilePermission, ?>>();

		attributeGetterFunctions.put("uuid", DGFilePermission::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<DGFilePermission, String>)DGFilePermission::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode",
			DGFilePermission::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<DGFilePermission, String>)
				DGFilePermission::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"filePermissionId", DGFilePermission::getFilePermissionId);
		attributeSetterBiConsumers.put(
			"filePermissionId",
			(BiConsumer<DGFilePermission, Long>)
				DGFilePermission::setFilePermissionId);
		attributeGetterFunctions.put("groupId", DGFilePermission::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DGFilePermission, Long>)DGFilePermission::setGroupId);
		attributeGetterFunctions.put(
			"companyId", DGFilePermission::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DGFilePermission, Long>)DGFilePermission::setCompanyId);
		attributeGetterFunctions.put("userId", DGFilePermission::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DGFilePermission, Long>)DGFilePermission::setUserId);
		attributeGetterFunctions.put("userName", DGFilePermission::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DGFilePermission, String>)
				DGFilePermission::setUserName);
		attributeGetterFunctions.put(
			"createDate", DGFilePermission::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DGFilePermission, Date>)
				DGFilePermission::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", DGFilePermission::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DGFilePermission, Date>)
				DGFilePermission::setModifiedDate);
		attributeGetterFunctions.put(
			"customerId", DGFilePermission::getCustomerId);
		attributeSetterBiConsumers.put(
			"customerId",
			(BiConsumer<DGFilePermission, Long>)
				DGFilePermission::setCustomerId);
		attributeGetterFunctions.put(
			"creatorId", DGFilePermission::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<DGFilePermission, Long>)DGFilePermission::setCreatorId);
		attributeGetterFunctions.put("fileId", DGFilePermission::getFileId);
		attributeSetterBiConsumers.put(
			"fileId",
			(BiConsumer<DGFilePermission, Long>)DGFilePermission::setFileId);
		attributeGetterFunctions.put(
			"generalPermission", DGFilePermission::getGeneralPermission);
		attributeSetterBiConsumers.put(
			"generalPermission",
			(BiConsumer<DGFilePermission, String>)
				DGFilePermission::setGeneralPermission);
		attributeGetterFunctions.put("role", DGFilePermission::getRole);
		attributeSetterBiConsumers.put(
			"role",
			(BiConsumer<DGFilePermission, String>)DGFilePermission::setRole);
		attributeGetterFunctions.put(
			"allowActionForEditor", DGFilePermission::getAllowActionForEditor);
		attributeSetterBiConsumers.put(
			"allowActionForEditor",
			(BiConsumer<DGFilePermission, Boolean>)
				DGFilePermission::setAllowActionForEditor);
		attributeGetterFunctions.put(
			"allowActionForViewer", DGFilePermission::getAllowActionForViewer);
		attributeSetterBiConsumers.put(
			"allowActionForViewer",
			(BiConsumer<DGFilePermission, Boolean>)
				DGFilePermission::setAllowActionForViewer);

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
	public long getFilePermissionId() {
		return _filePermissionId;
	}

	@Override
	public void setFilePermissionId(long filePermissionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_filePermissionId = filePermissionId;
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
	public String getGeneralPermission() {
		if (_generalPermission == null) {
			return "";
		}
		else {
			return _generalPermission;
		}
	}

	@Override
	public void setGeneralPermission(String generalPermission) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_generalPermission = generalPermission;
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
	public boolean getAllowActionForEditor() {
		return _allowActionForEditor;
	}

	@Override
	public boolean isAllowActionForEditor() {
		return _allowActionForEditor;
	}

	@Override
	public void setAllowActionForEditor(boolean allowActionForEditor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_allowActionForEditor = allowActionForEditor;
	}

	@Override
	public boolean getAllowActionForViewer() {
		return _allowActionForViewer;
	}

	@Override
	public boolean isAllowActionForViewer() {
		return _allowActionForViewer;
	}

	@Override
	public void setAllowActionForViewer(boolean allowActionForViewer) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_allowActionForViewer = allowActionForViewer;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(DGFilePermission.class.getName()));
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
			getCompanyId(), DGFilePermission.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DGFilePermission toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DGFilePermission>
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
		DGFilePermissionImpl dgFilePermissionImpl = new DGFilePermissionImpl();

		dgFilePermissionImpl.setUuid(getUuid());
		dgFilePermissionImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		dgFilePermissionImpl.setFilePermissionId(getFilePermissionId());
		dgFilePermissionImpl.setGroupId(getGroupId());
		dgFilePermissionImpl.setCompanyId(getCompanyId());
		dgFilePermissionImpl.setUserId(getUserId());
		dgFilePermissionImpl.setUserName(getUserName());
		dgFilePermissionImpl.setCreateDate(getCreateDate());
		dgFilePermissionImpl.setModifiedDate(getModifiedDate());
		dgFilePermissionImpl.setCustomerId(getCustomerId());
		dgFilePermissionImpl.setCreatorId(getCreatorId());
		dgFilePermissionImpl.setFileId(getFileId());
		dgFilePermissionImpl.setGeneralPermission(getGeneralPermission());
		dgFilePermissionImpl.setRole(getRole());
		dgFilePermissionImpl.setAllowActionForEditor(isAllowActionForEditor());
		dgFilePermissionImpl.setAllowActionForViewer(isAllowActionForViewer());

		dgFilePermissionImpl.resetOriginalValues();

		return dgFilePermissionImpl;
	}

	@Override
	public DGFilePermission cloneWithOriginalValues() {
		DGFilePermissionImpl dgFilePermissionImpl = new DGFilePermissionImpl();

		dgFilePermissionImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		dgFilePermissionImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		dgFilePermissionImpl.setFilePermissionId(
			this.<Long>getColumnOriginalValue("filePermissionId"));
		dgFilePermissionImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		dgFilePermissionImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		dgFilePermissionImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		dgFilePermissionImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		dgFilePermissionImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		dgFilePermissionImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		dgFilePermissionImpl.setCustomerId(
			this.<Long>getColumnOriginalValue("customerId"));
		dgFilePermissionImpl.setCreatorId(
			this.<Long>getColumnOriginalValue("creatorId"));
		dgFilePermissionImpl.setFileId(
			this.<Long>getColumnOriginalValue("fileId"));
		dgFilePermissionImpl.setGeneralPermission(
			this.<String>getColumnOriginalValue("generalPermission"));
		dgFilePermissionImpl.setRole(
			this.<String>getColumnOriginalValue("role_"));
		dgFilePermissionImpl.setAllowActionForEditor(
			this.<Boolean>getColumnOriginalValue("allowActionForEditor"));
		dgFilePermissionImpl.setAllowActionForViewer(
			this.<Boolean>getColumnOriginalValue("allowActionForViewer"));

		return dgFilePermissionImpl;
	}

	@Override
	public int compareTo(DGFilePermission dgFilePermission) {
		long primaryKey = dgFilePermission.getPrimaryKey();

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

		if (!(object instanceof DGFilePermission)) {
			return false;
		}

		DGFilePermission dgFilePermission = (DGFilePermission)object;

		long primaryKey = dgFilePermission.getPrimaryKey();

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
	public CacheModel<DGFilePermission> toCacheModel() {
		DGFilePermissionCacheModel dgFilePermissionCacheModel =
			new DGFilePermissionCacheModel();

		dgFilePermissionCacheModel.uuid = getUuid();

		String uuid = dgFilePermissionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dgFilePermissionCacheModel.uuid = null;
		}

		dgFilePermissionCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			dgFilePermissionCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			dgFilePermissionCacheModel.externalReferenceCode = null;
		}

		dgFilePermissionCacheModel.filePermissionId = getFilePermissionId();

		dgFilePermissionCacheModel.groupId = getGroupId();

		dgFilePermissionCacheModel.companyId = getCompanyId();

		dgFilePermissionCacheModel.userId = getUserId();

		dgFilePermissionCacheModel.userName = getUserName();

		String userName = dgFilePermissionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dgFilePermissionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dgFilePermissionCacheModel.createDate = createDate.getTime();
		}
		else {
			dgFilePermissionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dgFilePermissionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dgFilePermissionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dgFilePermissionCacheModel.customerId = getCustomerId();

		dgFilePermissionCacheModel.creatorId = getCreatorId();

		dgFilePermissionCacheModel.fileId = getFileId();

		dgFilePermissionCacheModel.generalPermission = getGeneralPermission();

		String generalPermission = dgFilePermissionCacheModel.generalPermission;

		if ((generalPermission != null) && (generalPermission.length() == 0)) {
			dgFilePermissionCacheModel.generalPermission = null;
		}

		dgFilePermissionCacheModel.role = getRole();

		String role = dgFilePermissionCacheModel.role;

		if ((role != null) && (role.length() == 0)) {
			dgFilePermissionCacheModel.role = null;
		}

		dgFilePermissionCacheModel.allowActionForEditor =
			isAllowActionForEditor();

		dgFilePermissionCacheModel.allowActionForViewer =
			isAllowActionForViewer();

		return dgFilePermissionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DGFilePermission, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DGFilePermission, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFilePermission, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(DGFilePermission)this);

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
		Map<String, Function<DGFilePermission, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DGFilePermission, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFilePermission, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DGFilePermission)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DGFilePermission>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _filePermissionId;
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
	private String _generalPermission;
	private String _role;
	private boolean _allowActionForEditor;
	private boolean _allowActionForViewer;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DGFilePermission, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DGFilePermission)this);
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
		_columnOriginalValues.put("filePermissionId", _filePermissionId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("customerId", _customerId);
		_columnOriginalValues.put("creatorId", _creatorId);
		_columnOriginalValues.put("fileId", _fileId);
		_columnOriginalValues.put("generalPermission", _generalPermission);
		_columnOriginalValues.put("role_", _role);
		_columnOriginalValues.put(
			"allowActionForEditor", _allowActionForEditor);
		_columnOriginalValues.put(
			"allowActionForViewer", _allowActionForViewer);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("role_", "role");

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

		columnBitmasks.put("filePermissionId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("customerId", 512L);

		columnBitmasks.put("creatorId", 1024L);

		columnBitmasks.put("fileId", 2048L);

		columnBitmasks.put("generalPermission", 4096L);

		columnBitmasks.put("role_", 8192L);

		columnBitmasks.put("allowActionForEditor", 16384L);

		columnBitmasks.put("allowActionForViewer", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DGFilePermission _escapedModel;

}