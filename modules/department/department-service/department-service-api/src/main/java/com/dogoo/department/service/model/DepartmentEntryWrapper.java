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

package com.dogoo.department.service.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DepartmentEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentEntry
 * @generated
 */
public class DepartmentEntryWrapper
	extends BaseModelWrapper<DepartmentEntry>
	implements DepartmentEntry, ModelWrapper<DepartmentEntry> {

	public DepartmentEntryWrapper(DepartmentEntry departmentEntry) {
		super(departmentEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("customerId", getCustomerId());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("parentId", getParentId());
		attributes.put("order", getOrder());
		attributes.put("type", getType());
		attributes.put("businessId", getBusinessId());
		attributes.put("tax", getTax());
		attributes.put("address", getAddress());
		attributes.put("headOffice", getHeadOffice());
		attributes.put("alias", getAlias());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String externalReferenceCode = (String)attributes.get(
			"externalReferenceCode");

		if (externalReferenceCode != null) {
			setExternalReferenceCode(externalReferenceCode);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
		}

		String tax = (String)attributes.get("tax");

		if (tax != null) {
			setTax(tax);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String headOffice = (String)attributes.get("headOffice");

		if (headOffice != null) {
			setHeadOffice(headOffice);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public DepartmentEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this department entry.
	 *
	 * @return the address of this department entry
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the alias of this department entry.
	 *
	 * @return the alias of this department entry
	 */
	@Override
	public String getAlias() {
		return model.getAlias();
	}

	/**
	 * Returns the business ID of this department entry.
	 *
	 * @return the business ID of this department entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the code of this department entry.
	 *
	 * @return the code of this department entry
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this department entry.
	 *
	 * @return the company ID of this department entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this department entry.
	 *
	 * @return the create date of this department entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this department entry.
	 *
	 * @return the creator ID of this department entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this department entry.
	 *
	 * @return the customer ID of this department entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the department ID of this department entry.
	 *
	 * @return the department ID of this department entry
	 */
	@Override
	public long getDepartmentId() {
		return model.getDepartmentId();
	}

	/**
	 * Returns the description of this department entry.
	 *
	 * @return the description of this department entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the external reference code of this department entry.
	 *
	 * @return the external reference code of this department entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this department entry.
	 *
	 * @return the group ID of this department entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the head office of this department entry.
	 *
	 * @return the head office of this department entry
	 */
	@Override
	public String getHeadOffice() {
		return model.getHeadOffice();
	}

	/**
	 * Returns the modified date of this department entry.
	 *
	 * @return the modified date of this department entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this department entry.
	 *
	 * @return the name of this department entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the order of this department entry.
	 *
	 * @return the order of this department entry
	 */
	@Override
	public Integer getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the parent ID of this department entry.
	 *
	 * @return the parent ID of this department entry
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this department entry.
	 *
	 * @return the primary key of this department entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this department entry.
	 *
	 * @return the status of this department entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status date of this department entry.
	 *
	 * @return the status date of this department entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the tax of this department entry.
	 *
	 * @return the tax of this department entry
	 */
	@Override
	public String getTax() {
		return model.getTax();
	}

	/**
	 * Returns the type of this department entry.
	 *
	 * @return the type of this department entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this department entry.
	 *
	 * @return the user ID of this department entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this department entry.
	 *
	 * @return the user name of this department entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this department entry.
	 *
	 * @return the user uuid of this department entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this department entry.
	 *
	 * @return the uuid of this department entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this department entry.
	 *
	 * @param address the address of this department entry
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the alias of this department entry.
	 *
	 * @param alias the alias of this department entry
	 */
	@Override
	public void setAlias(String alias) {
		model.setAlias(alias);
	}

	/**
	 * Sets the business ID of this department entry.
	 *
	 * @param businessId the business ID of this department entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the code of this department entry.
	 *
	 * @param code the code of this department entry
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this department entry.
	 *
	 * @param companyId the company ID of this department entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this department entry.
	 *
	 * @param createDate the create date of this department entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this department entry.
	 *
	 * @param creatorId the creator ID of this department entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this department entry.
	 *
	 * @param customerId the customer ID of this department entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the department ID of this department entry.
	 *
	 * @param departmentId the department ID of this department entry
	 */
	@Override
	public void setDepartmentId(long departmentId) {
		model.setDepartmentId(departmentId);
	}

	/**
	 * Sets the description of this department entry.
	 *
	 * @param description the description of this department entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the external reference code of this department entry.
	 *
	 * @param externalReferenceCode the external reference code of this department entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this department entry.
	 *
	 * @param groupId the group ID of this department entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the head office of this department entry.
	 *
	 * @param headOffice the head office of this department entry
	 */
	@Override
	public void setHeadOffice(String headOffice) {
		model.setHeadOffice(headOffice);
	}

	/**
	 * Sets the modified date of this department entry.
	 *
	 * @param modifiedDate the modified date of this department entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this department entry.
	 *
	 * @param name the name of this department entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the order of this department entry.
	 *
	 * @param order the order of this department entry
	 */
	@Override
	public void setOrder(Integer order) {
		model.setOrder(order);
	}

	/**
	 * Sets the parent ID of this department entry.
	 *
	 * @param parentId the parent ID of this department entry
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this department entry.
	 *
	 * @param primaryKey the primary key of this department entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this department entry.
	 *
	 * @param status the status of this department entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status date of this department entry.
	 *
	 * @param statusDate the status date of this department entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the tax of this department entry.
	 *
	 * @param tax the tax of this department entry
	 */
	@Override
	public void setTax(String tax) {
		model.setTax(tax);
	}

	/**
	 * Sets the type of this department entry.
	 *
	 * @param type the type of this department entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this department entry.
	 *
	 * @param userId the user ID of this department entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this department entry.
	 *
	 * @param userName the user name of this department entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this department entry.
	 *
	 * @param userUuid the user uuid of this department entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this department entry.
	 *
	 * @param uuid the uuid of this department entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DepartmentEntryWrapper wrap(DepartmentEntry departmentEntry) {
		return new DepartmentEntryWrapper(departmentEntry);
	}

}