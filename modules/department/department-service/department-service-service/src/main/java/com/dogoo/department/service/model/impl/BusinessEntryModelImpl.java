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

package com.dogoo.department.service.model.impl;

import com.dogoo.department.service.model.BusinessEntry;
import com.dogoo.department.service.model.BusinessEntryModel;

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
 * The base model implementation for the BusinessEntry service. Represents a row in the &quot;DG_BusinessEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>BusinessEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BusinessEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessEntryImpl
 * @generated
 */
public class BusinessEntryModelImpl
	extends BaseModelImpl<BusinessEntry> implements BusinessEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a business entry model instance should use the <code>BusinessEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_BusinessEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"businessId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"creatorId", Types.BIGINT},
		{"customerId", Types.BIGINT}, {"name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("businessId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("customerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_BusinessEntry (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,businessId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,creatorId LONG,customerId LONG,name VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table DG_BusinessEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY businessEntry.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DG_BusinessEntry.name ASC";

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

	public BusinessEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _businessId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBusinessId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _businessId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BusinessEntry.class;
	}

	@Override
	public String getModelClassName() {
		return BusinessEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BusinessEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BusinessEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BusinessEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((BusinessEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BusinessEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BusinessEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BusinessEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BusinessEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BusinessEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, BusinessEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			BusinessEntry.class.getClassLoader(), BusinessEntry.class,
			ModelWrapper.class);

		try {
			Constructor<BusinessEntry> constructor =
				(Constructor<BusinessEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<BusinessEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<BusinessEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<BusinessEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<BusinessEntry, Object>>();
		Map<String, BiConsumer<BusinessEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<BusinessEntry, ?>>();

		attributeGetterFunctions.put("uuid", BusinessEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<BusinessEntry, String>)BusinessEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode", BusinessEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<BusinessEntry, String>)
				BusinessEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"businessId", BusinessEntry::getBusinessId);
		attributeSetterBiConsumers.put(
			"businessId",
			(BiConsumer<BusinessEntry, Long>)BusinessEntry::setBusinessId);
		attributeGetterFunctions.put("groupId", BusinessEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<BusinessEntry, Long>)BusinessEntry::setGroupId);
		attributeGetterFunctions.put("companyId", BusinessEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<BusinessEntry, Long>)BusinessEntry::setCompanyId);
		attributeGetterFunctions.put("userId", BusinessEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<BusinessEntry, Long>)BusinessEntry::setUserId);
		attributeGetterFunctions.put("userName", BusinessEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<BusinessEntry, String>)BusinessEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", BusinessEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<BusinessEntry, Date>)BusinessEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", BusinessEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<BusinessEntry, Date>)BusinessEntry::setModifiedDate);
		attributeGetterFunctions.put("creatorId", BusinessEntry::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<BusinessEntry, Long>)BusinessEntry::setCreatorId);
		attributeGetterFunctions.put(
			"customerId", BusinessEntry::getCustomerId);
		attributeSetterBiConsumers.put(
			"customerId",
			(BiConsumer<BusinessEntry, Long>)BusinessEntry::setCustomerId);
		attributeGetterFunctions.put("name", BusinessEntry::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<BusinessEntry, String>)BusinessEntry::setName);

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
	public long getBusinessId() {
		return _businessId;
	}

	@Override
	public void setBusinessId(long businessId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_businessId = businessId;
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
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(BusinessEntry.class.getName()));
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
			getCompanyId(), BusinessEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BusinessEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, BusinessEntry>
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
		BusinessEntryImpl businessEntryImpl = new BusinessEntryImpl();

		businessEntryImpl.setUuid(getUuid());
		businessEntryImpl.setExternalReferenceCode(getExternalReferenceCode());
		businessEntryImpl.setBusinessId(getBusinessId());
		businessEntryImpl.setGroupId(getGroupId());
		businessEntryImpl.setCompanyId(getCompanyId());
		businessEntryImpl.setUserId(getUserId());
		businessEntryImpl.setUserName(getUserName());
		businessEntryImpl.setCreateDate(getCreateDate());
		businessEntryImpl.setModifiedDate(getModifiedDate());
		businessEntryImpl.setCreatorId(getCreatorId());
		businessEntryImpl.setCustomerId(getCustomerId());
		businessEntryImpl.setName(getName());

		businessEntryImpl.resetOriginalValues();

		return businessEntryImpl;
	}

	@Override
	public BusinessEntry cloneWithOriginalValues() {
		BusinessEntryImpl businessEntryImpl = new BusinessEntryImpl();

		businessEntryImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		businessEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		businessEntryImpl.setBusinessId(
			this.<Long>getColumnOriginalValue("businessId"));
		businessEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		businessEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		businessEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		businessEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		businessEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		businessEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		businessEntryImpl.setCreatorId(
			this.<Long>getColumnOriginalValue("creatorId"));
		businessEntryImpl.setCustomerId(
			this.<Long>getColumnOriginalValue("customerId"));
		businessEntryImpl.setName(this.<String>getColumnOriginalValue("name"));

		return businessEntryImpl;
	}

	@Override
	public int compareTo(BusinessEntry businessEntry) {
		int value = 0;

		value = getName().compareTo(businessEntry.getName());

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

		if (!(object instanceof BusinessEntry)) {
			return false;
		}

		BusinessEntry businessEntry = (BusinessEntry)object;

		long primaryKey = businessEntry.getPrimaryKey();

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
	public CacheModel<BusinessEntry> toCacheModel() {
		BusinessEntryCacheModel businessEntryCacheModel =
			new BusinessEntryCacheModel();

		businessEntryCacheModel.uuid = getUuid();

		String uuid = businessEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			businessEntryCacheModel.uuid = null;
		}

		businessEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			businessEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			businessEntryCacheModel.externalReferenceCode = null;
		}

		businessEntryCacheModel.businessId = getBusinessId();

		businessEntryCacheModel.groupId = getGroupId();

		businessEntryCacheModel.companyId = getCompanyId();

		businessEntryCacheModel.userId = getUserId();

		businessEntryCacheModel.userName = getUserName();

		String userName = businessEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			businessEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			businessEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			businessEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			businessEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			businessEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		businessEntryCacheModel.creatorId = getCreatorId();

		businessEntryCacheModel.customerId = getCustomerId();

		businessEntryCacheModel.name = getName();

		String name = businessEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			businessEntryCacheModel.name = null;
		}

		return businessEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<BusinessEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<BusinessEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BusinessEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((BusinessEntry)this);

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
		Map<String, Function<BusinessEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<BusinessEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BusinessEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((BusinessEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, BusinessEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _businessId;
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

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<BusinessEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((BusinessEntry)this);
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
		_columnOriginalValues.put("businessId", _businessId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("creatorId", _creatorId);
		_columnOriginalValues.put("customerId", _customerId);
		_columnOriginalValues.put("name", _name);
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

		columnBitmasks.put("businessId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("creatorId", 512L);

		columnBitmasks.put("customerId", 1024L);

		columnBitmasks.put("name", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private BusinessEntry _escapedModel;

}