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

package com.dogoo.dataitems.service.model.impl;

import com.dogoo.dataitems.service.model.DataItemEntry;
import com.dogoo.dataitems.service.model.DataItemEntryModel;

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
 * The base model implementation for the DataItemEntry service. Represents a row in the &quot;DG_DATAITEMENTRY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DataItemEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataItemEntryImpl}.
 * </p>
 *
 * @author nghiatt
 * @see DataItemEntryImpl
 * @generated
 */
public class DataItemEntryModelImpl
	extends BaseModelImpl<DataItemEntry> implements DataItemEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a data item entry model instance should use the <code>DataItemEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_DATAITEMENTRY";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"dataItemId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"creatorId", Types.BIGINT},
		{"customerId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"order_", Types.BIGINT},
		{"type_", Types.VARCHAR}, {"parentId", Types.BIGINT},
		{"isDefaultValue", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dataItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("customerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("order_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("parentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("isDefaultValue", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_DATAITEMENTRY (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,dataItemId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,creatorId LONG,customerId LONG,name VARCHAR(75) null,description VARCHAR(75) null,order_ LONG,type_ VARCHAR(75) null,parentId LONG,isDefaultValue BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table DG_DATAITEMENTRY";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dataItemEntry.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DG_DATAITEMENTRY.name ASC";

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
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PARENTID_COLUMN_BITMASK = 32L;

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

	public DataItemEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dataItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDataItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dataItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DataItemEntry.class;
	}

	@Override
	public String getModelClassName() {
		return DataItemEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DataItemEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DataItemEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataItemEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DataItemEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DataItemEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DataItemEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DataItemEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DataItemEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DataItemEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DataItemEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DataItemEntry.class.getClassLoader(), DataItemEntry.class,
			ModelWrapper.class);

		try {
			Constructor<DataItemEntry> constructor =
				(Constructor<DataItemEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<DataItemEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DataItemEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DataItemEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DataItemEntry, Object>>();
		Map<String, BiConsumer<DataItemEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DataItemEntry, ?>>();

		attributeGetterFunctions.put("uuid", DataItemEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<DataItemEntry, String>)DataItemEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode", DataItemEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<DataItemEntry, String>)
				DataItemEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"dataItemId", DataItemEntry::getDataItemId);
		attributeSetterBiConsumers.put(
			"dataItemId",
			(BiConsumer<DataItemEntry, Long>)DataItemEntry::setDataItemId);
		attributeGetterFunctions.put("groupId", DataItemEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DataItemEntry, Long>)DataItemEntry::setGroupId);
		attributeGetterFunctions.put("companyId", DataItemEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DataItemEntry, Long>)DataItemEntry::setCompanyId);
		attributeGetterFunctions.put("userId", DataItemEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DataItemEntry, Long>)DataItemEntry::setUserId);
		attributeGetterFunctions.put("userName", DataItemEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DataItemEntry, String>)DataItemEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", DataItemEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DataItemEntry, Date>)DataItemEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", DataItemEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DataItemEntry, Date>)DataItemEntry::setModifiedDate);
		attributeGetterFunctions.put("creatorId", DataItemEntry::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<DataItemEntry, Long>)DataItemEntry::setCreatorId);
		attributeGetterFunctions.put(
			"customerId", DataItemEntry::getCustomerId);
		attributeSetterBiConsumers.put(
			"customerId",
			(BiConsumer<DataItemEntry, Long>)DataItemEntry::setCustomerId);
		attributeGetterFunctions.put("name", DataItemEntry::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<DataItemEntry, String>)DataItemEntry::setName);
		attributeGetterFunctions.put(
			"description", DataItemEntry::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<DataItemEntry, String>)DataItemEntry::setDescription);
		attributeGetterFunctions.put("order_", DataItemEntry::getOrder_);
		attributeSetterBiConsumers.put(
			"order_",
			(BiConsumer<DataItemEntry, Long>)DataItemEntry::setOrder_);
		attributeGetterFunctions.put("type", DataItemEntry::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<DataItemEntry, String>)DataItemEntry::setType);
		attributeGetterFunctions.put("parentId", DataItemEntry::getParentId);
		attributeSetterBiConsumers.put(
			"parentId",
			(BiConsumer<DataItemEntry, Long>)DataItemEntry::setParentId);
		attributeGetterFunctions.put(
			"isDefaultValue", DataItemEntry::getIsDefaultValue);
		attributeSetterBiConsumers.put(
			"isDefaultValue",
			(BiConsumer<DataItemEntry, Boolean>)
				DataItemEntry::setIsDefaultValue);

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
	public long getDataItemId() {
		return _dataItemId;
	}

	@Override
	public void setDataItemId(long dataItemId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dataItemId = dataItemId;
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
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public long getOrder_() {
		return _order_;
	}

	@Override
	public void setOrder_(long order_) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_order_ = order_;
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
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_parentId = parentId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalParentId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("parentId"));
	}

	@Override
	public boolean getIsDefaultValue() {
		return _isDefaultValue;
	}

	@Override
	public boolean isIsDefaultValue() {
		return _isDefaultValue;
	}

	@Override
	public void setIsDefaultValue(boolean isDefaultValue) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isDefaultValue = isDefaultValue;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(DataItemEntry.class.getName()));
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
			getCompanyId(), DataItemEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DataItemEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DataItemEntry>
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
		DataItemEntryImpl dataItemEntryImpl = new DataItemEntryImpl();

		dataItemEntryImpl.setUuid(getUuid());
		dataItemEntryImpl.setExternalReferenceCode(getExternalReferenceCode());
		dataItemEntryImpl.setDataItemId(getDataItemId());
		dataItemEntryImpl.setGroupId(getGroupId());
		dataItemEntryImpl.setCompanyId(getCompanyId());
		dataItemEntryImpl.setUserId(getUserId());
		dataItemEntryImpl.setUserName(getUserName());
		dataItemEntryImpl.setCreateDate(getCreateDate());
		dataItemEntryImpl.setModifiedDate(getModifiedDate());
		dataItemEntryImpl.setCreatorId(getCreatorId());
		dataItemEntryImpl.setCustomerId(getCustomerId());
		dataItemEntryImpl.setName(getName());
		dataItemEntryImpl.setDescription(getDescription());
		dataItemEntryImpl.setOrder_(getOrder_());
		dataItemEntryImpl.setType(getType());
		dataItemEntryImpl.setParentId(getParentId());
		dataItemEntryImpl.setIsDefaultValue(isIsDefaultValue());

		dataItemEntryImpl.resetOriginalValues();

		return dataItemEntryImpl;
	}

	@Override
	public DataItemEntry cloneWithOriginalValues() {
		DataItemEntryImpl dataItemEntryImpl = new DataItemEntryImpl();

		dataItemEntryImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		dataItemEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		dataItemEntryImpl.setDataItemId(
			this.<Long>getColumnOriginalValue("dataItemId"));
		dataItemEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		dataItemEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		dataItemEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		dataItemEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		dataItemEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		dataItemEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		dataItemEntryImpl.setCreatorId(
			this.<Long>getColumnOriginalValue("creatorId"));
		dataItemEntryImpl.setCustomerId(
			this.<Long>getColumnOriginalValue("customerId"));
		dataItemEntryImpl.setName(this.<String>getColumnOriginalValue("name"));
		dataItemEntryImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		dataItemEntryImpl.setOrder_(
			this.<Long>getColumnOriginalValue("order_"));
		dataItemEntryImpl.setType(this.<String>getColumnOriginalValue("type_"));
		dataItemEntryImpl.setParentId(
			this.<Long>getColumnOriginalValue("parentId"));
		dataItemEntryImpl.setIsDefaultValue(
			this.<Boolean>getColumnOriginalValue("isDefaultValue"));

		return dataItemEntryImpl;
	}

	@Override
	public int compareTo(DataItemEntry dataItemEntry) {
		int value = 0;

		value = getName().compareTo(dataItemEntry.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataItemEntry)) {
			return false;
		}

		DataItemEntry dataItemEntry = (DataItemEntry)object;

		long primaryKey = dataItemEntry.getPrimaryKey();

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
	public CacheModel<DataItemEntry> toCacheModel() {
		DataItemEntryCacheModel dataItemEntryCacheModel =
			new DataItemEntryCacheModel();

		dataItemEntryCacheModel.uuid = getUuid();

		String uuid = dataItemEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dataItemEntryCacheModel.uuid = null;
		}

		dataItemEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			dataItemEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			dataItemEntryCacheModel.externalReferenceCode = null;
		}

		dataItemEntryCacheModel.dataItemId = getDataItemId();

		dataItemEntryCacheModel.groupId = getGroupId();

		dataItemEntryCacheModel.companyId = getCompanyId();

		dataItemEntryCacheModel.userId = getUserId();

		dataItemEntryCacheModel.userName = getUserName();

		String userName = dataItemEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dataItemEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dataItemEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			dataItemEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dataItemEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dataItemEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dataItemEntryCacheModel.creatorId = getCreatorId();

		dataItemEntryCacheModel.customerId = getCustomerId();

		dataItemEntryCacheModel.name = getName();

		String name = dataItemEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			dataItemEntryCacheModel.name = null;
		}

		dataItemEntryCacheModel.description = getDescription();

		String description = dataItemEntryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			dataItemEntryCacheModel.description = null;
		}

		dataItemEntryCacheModel.order_ = getOrder_();

		dataItemEntryCacheModel.type = getType();

		String type = dataItemEntryCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			dataItemEntryCacheModel.type = null;
		}

		dataItemEntryCacheModel.parentId = getParentId();

		dataItemEntryCacheModel.isDefaultValue = isIsDefaultValue();

		return dataItemEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DataItemEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DataItemEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataItemEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DataItemEntry)this);

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
		Map<String, Function<DataItemEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DataItemEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataItemEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DataItemEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DataItemEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _dataItemId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _creatorId;
	private long _customerId;
	private String _name;
	private String _description;
	private long _order_;
	private String _type;
	private long _parentId;
	private boolean _isDefaultValue;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DataItemEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DataItemEntry)this);
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
		_columnOriginalValues.put("dataItemId", _dataItemId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("creatorId", _creatorId);
		_columnOriginalValues.put("customerId", _customerId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("order_", _order_);
		_columnOriginalValues.put("type_", _type);
		_columnOriginalValues.put("parentId", _parentId);
		_columnOriginalValues.put("isDefaultValue", _isDefaultValue);
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

		columnBitmasks.put("dataItemId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("creatorId", 512L);

		columnBitmasks.put("customerId", 1024L);

		columnBitmasks.put("name", 2048L);

		columnBitmasks.put("description", 4096L);

		columnBitmasks.put("order_", 8192L);

		columnBitmasks.put("type_", 16384L);

		columnBitmasks.put("parentId", 32768L);

		columnBitmasks.put("isDefaultValue", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DataItemEntry _escapedModel;

}