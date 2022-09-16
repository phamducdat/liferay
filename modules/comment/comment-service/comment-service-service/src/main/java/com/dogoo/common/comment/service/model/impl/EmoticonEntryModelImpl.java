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

package com.dogoo.common.comment.service.model.impl;

import com.dogoo.common.comment.service.model.EmoticonEntry;
import com.dogoo.common.comment.service.model.EmoticonEntryModel;

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
 * The base model implementation for the EmoticonEntry service. Represents a row in the &quot;DG_EmoticonEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmoticonEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmoticonEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmoticonEntryImpl
 * @generated
 */
public class EmoticonEntryModelImpl
	extends BaseModelImpl<EmoticonEntry> implements EmoticonEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a emoticon entry model instance should use the <code>EmoticonEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_EmoticonEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"emoticonId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"customerId", Types.BIGINT},
		{"creatorId", Types.BIGINT}, {"classPkId", Types.BIGINT},
		{"classPkName", Types.VARCHAR}, {"creatorFullName", Types.VARCHAR},
		{"emoji", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("emoticonId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("customerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPkName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("creatorFullName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("emoji", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_EmoticonEntry (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,emoticonId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,customerId LONG,creatorId LONG,classPkId LONG,classPkName VARCHAR(75) null,creatorFullName VARCHAR(75) null,emoji VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table DG_EmoticonEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY emoticonEntry.emoticonId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DG_EmoticonEntry.emoticonId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CLASSPKID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CLASSPKNAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CREATORID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CUSTOMERID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 64L;

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
	public static final long EMOTICONID_COLUMN_BITMASK = 256L;

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

	public EmoticonEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _emoticonId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmoticonId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _emoticonId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmoticonEntry.class;
	}

	@Override
	public String getModelClassName() {
		return EmoticonEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmoticonEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmoticonEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmoticonEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmoticonEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmoticonEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmoticonEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmoticonEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmoticonEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmoticonEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmoticonEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmoticonEntry.class.getClassLoader(), EmoticonEntry.class,
			ModelWrapper.class);

		try {
			Constructor<EmoticonEntry> constructor =
				(Constructor<EmoticonEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EmoticonEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmoticonEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmoticonEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<EmoticonEntry, Object>>();
		Map<String, BiConsumer<EmoticonEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<EmoticonEntry, ?>>();

		attributeGetterFunctions.put("uuid", EmoticonEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<EmoticonEntry, String>)EmoticonEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode", EmoticonEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<EmoticonEntry, String>)
				EmoticonEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"emoticonId", EmoticonEntry::getEmoticonId);
		attributeSetterBiConsumers.put(
			"emoticonId",
			(BiConsumer<EmoticonEntry, Long>)EmoticonEntry::setEmoticonId);
		attributeGetterFunctions.put("groupId", EmoticonEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EmoticonEntry, Long>)EmoticonEntry::setGroupId);
		attributeGetterFunctions.put("companyId", EmoticonEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EmoticonEntry, Long>)EmoticonEntry::setCompanyId);
		attributeGetterFunctions.put("userId", EmoticonEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EmoticonEntry, Long>)EmoticonEntry::setUserId);
		attributeGetterFunctions.put("userName", EmoticonEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<EmoticonEntry, String>)EmoticonEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", EmoticonEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EmoticonEntry, Date>)EmoticonEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EmoticonEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EmoticonEntry, Date>)EmoticonEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"customerId", EmoticonEntry::getCustomerId);
		attributeSetterBiConsumers.put(
			"customerId",
			(BiConsumer<EmoticonEntry, Long>)EmoticonEntry::setCustomerId);
		attributeGetterFunctions.put("creatorId", EmoticonEntry::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<EmoticonEntry, Long>)EmoticonEntry::setCreatorId);
		attributeGetterFunctions.put("classPkId", EmoticonEntry::getClassPkId);
		attributeSetterBiConsumers.put(
			"classPkId",
			(BiConsumer<EmoticonEntry, Long>)EmoticonEntry::setClassPkId);
		attributeGetterFunctions.put(
			"classPkName", EmoticonEntry::getClassPkName);
		attributeSetterBiConsumers.put(
			"classPkName",
			(BiConsumer<EmoticonEntry, String>)EmoticonEntry::setClassPkName);
		attributeGetterFunctions.put(
			"creatorFullName", EmoticonEntry::getCreatorFullName);
		attributeSetterBiConsumers.put(
			"creatorFullName",
			(BiConsumer<EmoticonEntry, String>)
				EmoticonEntry::setCreatorFullName);
		attributeGetterFunctions.put("emoji", EmoticonEntry::getEmoji);
		attributeSetterBiConsumers.put(
			"emoji",
			(BiConsumer<EmoticonEntry, String>)EmoticonEntry::setEmoji);

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
	public long getEmoticonId() {
		return _emoticonId;
	}

	@Override
	public void setEmoticonId(long emoticonId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_emoticonId = emoticonId;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCreatorId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("creatorId"));
	}

	@Override
	public long getClassPkId() {
		return _classPkId;
	}

	@Override
	public void setClassPkId(long classPkId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_classPkId = classPkId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassPkId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("classPkId"));
	}

	@Override
	public String getClassPkName() {
		if (_classPkName == null) {
			return "";
		}
		else {
			return _classPkName;
		}
	}

	@Override
	public void setClassPkName(String classPkName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_classPkName = classPkName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalClassPkName() {
		return getColumnOriginalValue("classPkName");
	}

	@Override
	public String getCreatorFullName() {
		if (_creatorFullName == null) {
			return "";
		}
		else {
			return _creatorFullName;
		}
	}

	@Override
	public void setCreatorFullName(String creatorFullName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_creatorFullName = creatorFullName;
	}

	@Override
	public String getEmoji() {
		if (_emoji == null) {
			return "";
		}
		else {
			return _emoji;
		}
	}

	@Override
	public void setEmoji(String emoji) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_emoji = emoji;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(EmoticonEntry.class.getName()));
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
			getCompanyId(), EmoticonEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmoticonEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmoticonEntry>
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
		EmoticonEntryImpl emoticonEntryImpl = new EmoticonEntryImpl();

		emoticonEntryImpl.setUuid(getUuid());
		emoticonEntryImpl.setExternalReferenceCode(getExternalReferenceCode());
		emoticonEntryImpl.setEmoticonId(getEmoticonId());
		emoticonEntryImpl.setGroupId(getGroupId());
		emoticonEntryImpl.setCompanyId(getCompanyId());
		emoticonEntryImpl.setUserId(getUserId());
		emoticonEntryImpl.setUserName(getUserName());
		emoticonEntryImpl.setCreateDate(getCreateDate());
		emoticonEntryImpl.setModifiedDate(getModifiedDate());
		emoticonEntryImpl.setCustomerId(getCustomerId());
		emoticonEntryImpl.setCreatorId(getCreatorId());
		emoticonEntryImpl.setClassPkId(getClassPkId());
		emoticonEntryImpl.setClassPkName(getClassPkName());
		emoticonEntryImpl.setCreatorFullName(getCreatorFullName());
		emoticonEntryImpl.setEmoji(getEmoji());

		emoticonEntryImpl.resetOriginalValues();

		return emoticonEntryImpl;
	}

	@Override
	public EmoticonEntry cloneWithOriginalValues() {
		EmoticonEntryImpl emoticonEntryImpl = new EmoticonEntryImpl();

		emoticonEntryImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		emoticonEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		emoticonEntryImpl.setEmoticonId(
			this.<Long>getColumnOriginalValue("emoticonId"));
		emoticonEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		emoticonEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		emoticonEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		emoticonEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		emoticonEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		emoticonEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		emoticonEntryImpl.setCustomerId(
			this.<Long>getColumnOriginalValue("customerId"));
		emoticonEntryImpl.setCreatorId(
			this.<Long>getColumnOriginalValue("creatorId"));
		emoticonEntryImpl.setClassPkId(
			this.<Long>getColumnOriginalValue("classPkId"));
		emoticonEntryImpl.setClassPkName(
			this.<String>getColumnOriginalValue("classPkName"));
		emoticonEntryImpl.setCreatorFullName(
			this.<String>getColumnOriginalValue("creatorFullName"));
		emoticonEntryImpl.setEmoji(
			this.<String>getColumnOriginalValue("emoji"));

		return emoticonEntryImpl;
	}

	@Override
	public int compareTo(EmoticonEntry emoticonEntry) {
		long primaryKey = emoticonEntry.getPrimaryKey();

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

		if (!(object instanceof EmoticonEntry)) {
			return false;
		}

		EmoticonEntry emoticonEntry = (EmoticonEntry)object;

		long primaryKey = emoticonEntry.getPrimaryKey();

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
	public CacheModel<EmoticonEntry> toCacheModel() {
		EmoticonEntryCacheModel emoticonEntryCacheModel =
			new EmoticonEntryCacheModel();

		emoticonEntryCacheModel.uuid = getUuid();

		String uuid = emoticonEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			emoticonEntryCacheModel.uuid = null;
		}

		emoticonEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			emoticonEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			emoticonEntryCacheModel.externalReferenceCode = null;
		}

		emoticonEntryCacheModel.emoticonId = getEmoticonId();

		emoticonEntryCacheModel.groupId = getGroupId();

		emoticonEntryCacheModel.companyId = getCompanyId();

		emoticonEntryCacheModel.userId = getUserId();

		emoticonEntryCacheModel.userName = getUserName();

		String userName = emoticonEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			emoticonEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			emoticonEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			emoticonEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			emoticonEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			emoticonEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		emoticonEntryCacheModel.customerId = getCustomerId();

		emoticonEntryCacheModel.creatorId = getCreatorId();

		emoticonEntryCacheModel.classPkId = getClassPkId();

		emoticonEntryCacheModel.classPkName = getClassPkName();

		String classPkName = emoticonEntryCacheModel.classPkName;

		if ((classPkName != null) && (classPkName.length() == 0)) {
			emoticonEntryCacheModel.classPkName = null;
		}

		emoticonEntryCacheModel.creatorFullName = getCreatorFullName();

		String creatorFullName = emoticonEntryCacheModel.creatorFullName;

		if ((creatorFullName != null) && (creatorFullName.length() == 0)) {
			emoticonEntryCacheModel.creatorFullName = null;
		}

		emoticonEntryCacheModel.emoji = getEmoji();

		String emoji = emoticonEntryCacheModel.emoji;

		if ((emoji != null) && (emoji.length() == 0)) {
			emoticonEntryCacheModel.emoji = null;
		}

		return emoticonEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmoticonEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmoticonEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmoticonEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((EmoticonEntry)this);

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
		Map<String, Function<EmoticonEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmoticonEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmoticonEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmoticonEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmoticonEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _emoticonId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _customerId;
	private long _creatorId;
	private long _classPkId;
	private String _classPkName;
	private String _creatorFullName;
	private String _emoji;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<EmoticonEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmoticonEntry)this);
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
		_columnOriginalValues.put("emoticonId", _emoticonId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("customerId", _customerId);
		_columnOriginalValues.put("creatorId", _creatorId);
		_columnOriginalValues.put("classPkId", _classPkId);
		_columnOriginalValues.put("classPkName", _classPkName);
		_columnOriginalValues.put("creatorFullName", _creatorFullName);
		_columnOriginalValues.put("emoji", _emoji);
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

		columnBitmasks.put("emoticonId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("customerId", 512L);

		columnBitmasks.put("creatorId", 1024L);

		columnBitmasks.put("classPkId", 2048L);

		columnBitmasks.put("classPkName", 4096L);

		columnBitmasks.put("creatorFullName", 8192L);

		columnBitmasks.put("emoji", 16384L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmoticonEntry _escapedModel;

}