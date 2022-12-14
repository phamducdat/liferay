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

import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntry;
import com.dogoo.common.files.manager.service.model.DGFileDepartmentPermissionEntryModel;

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
 * The base model implementation for the DGFileDepartmentPermissionEntry service. Represents a row in the &quot;DG_FileDepartmentPermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DGFileDepartmentPermissionEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DGFileDepartmentPermissionEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DGFileDepartmentPermissionEntryImpl
 * @generated
 */
public class DGFileDepartmentPermissionEntryModelImpl
	extends BaseModelImpl<DGFileDepartmentPermissionEntry>
	implements DGFileDepartmentPermissionEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dg file department permission entry model instance should use the <code>DGFileDepartmentPermissionEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_FileDepartmentPermission";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"fileDepartmentPermissionId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"customerId", Types.BIGINT},
		{"creatorId", Types.BIGINT}, {"fileId", Types.BIGINT},
		{"departmentId", Types.BIGINT}, {"role_", Types.VARCHAR},
		{"type_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileDepartmentPermissionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("customerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("departmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("role_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_FileDepartmentPermission (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,fileDepartmentPermissionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,customerId LONG,creatorId LONG,fileId LONG,departmentId LONG,role_ VARCHAR(75) null,type_ VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table DG_FileDepartmentPermission";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgFileDepartmentPermissionEntry.fileDepartmentPermissionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DG_FileDepartmentPermission.fileDepartmentPermissionId ASC";

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
	public static final long DEPARTMENTID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FILEID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TYPE_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FILEDEPARTMENTPERMISSIONID_COLUMN_BITMASK = 256L;

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

	public DGFileDepartmentPermissionEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fileDepartmentPermissionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileDepartmentPermissionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileDepartmentPermissionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DGFileDepartmentPermissionEntry.class;
	}

	@Override
	public String getModelClassName() {
		return DGFileDepartmentPermissionEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DGFileDepartmentPermissionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry
				<String, Function<DGFileDepartmentPermissionEntry, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileDepartmentPermissionEntry, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(DGFileDepartmentPermissionEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DGFileDepartmentPermissionEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DGFileDepartmentPermissionEntry, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DGFileDepartmentPermissionEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DGFileDepartmentPermissionEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DGFileDepartmentPermissionEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DGFileDepartmentPermissionEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DGFileDepartmentPermissionEntry.class.getClassLoader(),
			DGFileDepartmentPermissionEntry.class, ModelWrapper.class);

		try {
			Constructor<DGFileDepartmentPermissionEntry> constructor =
				(Constructor<DGFileDepartmentPermissionEntry>)
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
		<String, Function<DGFileDepartmentPermissionEntry, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<DGFileDepartmentPermissionEntry, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<DGFileDepartmentPermissionEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function<DGFileDepartmentPermissionEntry, Object>>();
		Map<String, BiConsumer<DGFileDepartmentPermissionEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<DGFileDepartmentPermissionEntry, ?>>();

		attributeGetterFunctions.put(
			"uuid", DGFileDepartmentPermissionEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<DGFileDepartmentPermissionEntry, String>)
				DGFileDepartmentPermissionEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode",
			DGFileDepartmentPermissionEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<DGFileDepartmentPermissionEntry, String>)
				DGFileDepartmentPermissionEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"fileDepartmentPermissionId",
			DGFileDepartmentPermissionEntry::getFileDepartmentPermissionId);
		attributeSetterBiConsumers.put(
			"fileDepartmentPermissionId",
			(BiConsumer<DGFileDepartmentPermissionEntry, Long>)
				DGFileDepartmentPermissionEntry::setFileDepartmentPermissionId);
		attributeGetterFunctions.put(
			"groupId", DGFileDepartmentPermissionEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DGFileDepartmentPermissionEntry, Long>)
				DGFileDepartmentPermissionEntry::setGroupId);
		attributeGetterFunctions.put(
			"companyId", DGFileDepartmentPermissionEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DGFileDepartmentPermissionEntry, Long>)
				DGFileDepartmentPermissionEntry::setCompanyId);
		attributeGetterFunctions.put(
			"userId", DGFileDepartmentPermissionEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DGFileDepartmentPermissionEntry, Long>)
				DGFileDepartmentPermissionEntry::setUserId);
		attributeGetterFunctions.put(
			"userName", DGFileDepartmentPermissionEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DGFileDepartmentPermissionEntry, String>)
				DGFileDepartmentPermissionEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", DGFileDepartmentPermissionEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DGFileDepartmentPermissionEntry, Date>)
				DGFileDepartmentPermissionEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", DGFileDepartmentPermissionEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DGFileDepartmentPermissionEntry, Date>)
				DGFileDepartmentPermissionEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"customerId", DGFileDepartmentPermissionEntry::getCustomerId);
		attributeSetterBiConsumers.put(
			"customerId",
			(BiConsumer<DGFileDepartmentPermissionEntry, Long>)
				DGFileDepartmentPermissionEntry::setCustomerId);
		attributeGetterFunctions.put(
			"creatorId", DGFileDepartmentPermissionEntry::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<DGFileDepartmentPermissionEntry, Long>)
				DGFileDepartmentPermissionEntry::setCreatorId);
		attributeGetterFunctions.put(
			"fileId", DGFileDepartmentPermissionEntry::getFileId);
		attributeSetterBiConsumers.put(
			"fileId",
			(BiConsumer<DGFileDepartmentPermissionEntry, Long>)
				DGFileDepartmentPermissionEntry::setFileId);
		attributeGetterFunctions.put(
			"departmentId", DGFileDepartmentPermissionEntry::getDepartmentId);
		attributeSetterBiConsumers.put(
			"departmentId",
			(BiConsumer<DGFileDepartmentPermissionEntry, Long>)
				DGFileDepartmentPermissionEntry::setDepartmentId);
		attributeGetterFunctions.put(
			"role", DGFileDepartmentPermissionEntry::getRole);
		attributeSetterBiConsumers.put(
			"role",
			(BiConsumer<DGFileDepartmentPermissionEntry, String>)
				DGFileDepartmentPermissionEntry::setRole);
		attributeGetterFunctions.put(
			"type", DGFileDepartmentPermissionEntry::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<DGFileDepartmentPermissionEntry, String>)
				DGFileDepartmentPermissionEntry::setType);

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
	public long getFileDepartmentPermissionId() {
		return _fileDepartmentPermissionId;
	}

	@Override
	public void setFileDepartmentPermissionId(long fileDepartmentPermissionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileDepartmentPermissionId = fileDepartmentPermissionId;
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
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_departmentId = departmentId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDepartmentId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("departmentId"));
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
				DGFileDepartmentPermissionEntry.class.getName()));
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
			getCompanyId(), DGFileDepartmentPermissionEntry.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DGFileDepartmentPermissionEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DGFileDepartmentPermissionEntry>
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
		DGFileDepartmentPermissionEntryImpl
			dgFileDepartmentPermissionEntryImpl =
				new DGFileDepartmentPermissionEntryImpl();

		dgFileDepartmentPermissionEntryImpl.setUuid(getUuid());
		dgFileDepartmentPermissionEntryImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		dgFileDepartmentPermissionEntryImpl.setFileDepartmentPermissionId(
			getFileDepartmentPermissionId());
		dgFileDepartmentPermissionEntryImpl.setGroupId(getGroupId());
		dgFileDepartmentPermissionEntryImpl.setCompanyId(getCompanyId());
		dgFileDepartmentPermissionEntryImpl.setUserId(getUserId());
		dgFileDepartmentPermissionEntryImpl.setUserName(getUserName());
		dgFileDepartmentPermissionEntryImpl.setCreateDate(getCreateDate());
		dgFileDepartmentPermissionEntryImpl.setModifiedDate(getModifiedDate());
		dgFileDepartmentPermissionEntryImpl.setCustomerId(getCustomerId());
		dgFileDepartmentPermissionEntryImpl.setCreatorId(getCreatorId());
		dgFileDepartmentPermissionEntryImpl.setFileId(getFileId());
		dgFileDepartmentPermissionEntryImpl.setDepartmentId(getDepartmentId());
		dgFileDepartmentPermissionEntryImpl.setRole(getRole());
		dgFileDepartmentPermissionEntryImpl.setType(getType());

		dgFileDepartmentPermissionEntryImpl.resetOriginalValues();

		return dgFileDepartmentPermissionEntryImpl;
	}

	@Override
	public DGFileDepartmentPermissionEntry cloneWithOriginalValues() {
		DGFileDepartmentPermissionEntryImpl
			dgFileDepartmentPermissionEntryImpl =
				new DGFileDepartmentPermissionEntryImpl();

		dgFileDepartmentPermissionEntryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		dgFileDepartmentPermissionEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		dgFileDepartmentPermissionEntryImpl.setFileDepartmentPermissionId(
			this.<Long>getColumnOriginalValue("fileDepartmentPermissionId"));
		dgFileDepartmentPermissionEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		dgFileDepartmentPermissionEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		dgFileDepartmentPermissionEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		dgFileDepartmentPermissionEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		dgFileDepartmentPermissionEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		dgFileDepartmentPermissionEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		dgFileDepartmentPermissionEntryImpl.setCustomerId(
			this.<Long>getColumnOriginalValue("customerId"));
		dgFileDepartmentPermissionEntryImpl.setCreatorId(
			this.<Long>getColumnOriginalValue("creatorId"));
		dgFileDepartmentPermissionEntryImpl.setFileId(
			this.<Long>getColumnOriginalValue("fileId"));
		dgFileDepartmentPermissionEntryImpl.setDepartmentId(
			this.<Long>getColumnOriginalValue("departmentId"));
		dgFileDepartmentPermissionEntryImpl.setRole(
			this.<String>getColumnOriginalValue("role_"));
		dgFileDepartmentPermissionEntryImpl.setType(
			this.<String>getColumnOriginalValue("type_"));

		return dgFileDepartmentPermissionEntryImpl;
	}

	@Override
	public int compareTo(
		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry) {

		long primaryKey = dgFileDepartmentPermissionEntry.getPrimaryKey();

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

		if (!(object instanceof DGFileDepartmentPermissionEntry)) {
			return false;
		}

		DGFileDepartmentPermissionEntry dgFileDepartmentPermissionEntry =
			(DGFileDepartmentPermissionEntry)object;

		long primaryKey = dgFileDepartmentPermissionEntry.getPrimaryKey();

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
	public CacheModel<DGFileDepartmentPermissionEntry> toCacheModel() {
		DGFileDepartmentPermissionEntryCacheModel
			dgFileDepartmentPermissionEntryCacheModel =
				new DGFileDepartmentPermissionEntryCacheModel();

		dgFileDepartmentPermissionEntryCacheModel.uuid = getUuid();

		String uuid = dgFileDepartmentPermissionEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dgFileDepartmentPermissionEntryCacheModel.uuid = null;
		}

		dgFileDepartmentPermissionEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			dgFileDepartmentPermissionEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			dgFileDepartmentPermissionEntryCacheModel.externalReferenceCode =
				null;
		}

		dgFileDepartmentPermissionEntryCacheModel.fileDepartmentPermissionId =
			getFileDepartmentPermissionId();

		dgFileDepartmentPermissionEntryCacheModel.groupId = getGroupId();

		dgFileDepartmentPermissionEntryCacheModel.companyId = getCompanyId();

		dgFileDepartmentPermissionEntryCacheModel.userId = getUserId();

		dgFileDepartmentPermissionEntryCacheModel.userName = getUserName();

		String userName = dgFileDepartmentPermissionEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dgFileDepartmentPermissionEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dgFileDepartmentPermissionEntryCacheModel.createDate =
				createDate.getTime();
		}
		else {
			dgFileDepartmentPermissionEntryCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dgFileDepartmentPermissionEntryCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			dgFileDepartmentPermissionEntryCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		dgFileDepartmentPermissionEntryCacheModel.customerId = getCustomerId();

		dgFileDepartmentPermissionEntryCacheModel.creatorId = getCreatorId();

		dgFileDepartmentPermissionEntryCacheModel.fileId = getFileId();

		dgFileDepartmentPermissionEntryCacheModel.departmentId =
			getDepartmentId();

		dgFileDepartmentPermissionEntryCacheModel.role = getRole();

		String role = dgFileDepartmentPermissionEntryCacheModel.role;

		if ((role != null) && (role.length() == 0)) {
			dgFileDepartmentPermissionEntryCacheModel.role = null;
		}

		dgFileDepartmentPermissionEntryCacheModel.type = getType();

		String type = dgFileDepartmentPermissionEntryCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			dgFileDepartmentPermissionEntryCacheModel.type = null;
		}

		return dgFileDepartmentPermissionEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DGFileDepartmentPermissionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry
				<String, Function<DGFileDepartmentPermissionEntry, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileDepartmentPermissionEntry, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(DGFileDepartmentPermissionEntry)this);

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
		Map<String, Function<DGFileDepartmentPermissionEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry
				<String, Function<DGFileDepartmentPermissionEntry, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DGFileDepartmentPermissionEntry, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(DGFileDepartmentPermissionEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, DGFileDepartmentPermissionEntry>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _fileDepartmentPermissionId;
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
	private long _departmentId;
	private String _role;
	private String _type;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DGFileDepartmentPermissionEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DGFileDepartmentPermissionEntry)this);
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
			"fileDepartmentPermissionId", _fileDepartmentPermissionId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("customerId", _customerId);
		_columnOriginalValues.put("creatorId", _creatorId);
		_columnOriginalValues.put("fileId", _fileId);
		_columnOriginalValues.put("departmentId", _departmentId);
		_columnOriginalValues.put("role_", _role);
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

		columnBitmasks.put("fileDepartmentPermissionId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("customerId", 512L);

		columnBitmasks.put("creatorId", 1024L);

		columnBitmasks.put("fileId", 2048L);

		columnBitmasks.put("departmentId", 4096L);

		columnBitmasks.put("role_", 8192L);

		columnBitmasks.put("type_", 16384L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DGFileDepartmentPermissionEntry _escapedModel;

}