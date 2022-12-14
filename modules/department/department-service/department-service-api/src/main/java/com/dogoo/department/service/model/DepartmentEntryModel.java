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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DepartmentEntry service. Represents a row in the &quot;DG_DepartmentEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dogoo.department.service.model.impl.DepartmentEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dogoo.department.service.model.impl.DepartmentEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentEntry
 * @generated
 */
@ProviderType
public interface DepartmentEntryModel
	extends BaseModel<DepartmentEntry>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a department entry model instance should use the {@link DepartmentEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this department entry.
	 *
	 * @return the primary key of this department entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this department entry.
	 *
	 * @param primaryKey the primary key of this department entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this department entry.
	 *
	 * @return the uuid of this department entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this department entry.
	 *
	 * @param uuid the uuid of this department entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this department entry.
	 *
	 * @return the external reference code of this department entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this department entry.
	 *
	 * @param externalReferenceCode the external reference code of this department entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the department ID of this department entry.
	 *
	 * @return the department ID of this department entry
	 */
	public long getDepartmentId();

	/**
	 * Sets the department ID of this department entry.
	 *
	 * @param departmentId the department ID of this department entry
	 */
	public void setDepartmentId(long departmentId);

	/**
	 * Returns the group ID of this department entry.
	 *
	 * @return the group ID of this department entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this department entry.
	 *
	 * @param groupId the group ID of this department entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this department entry.
	 *
	 * @return the company ID of this department entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this department entry.
	 *
	 * @param companyId the company ID of this department entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this department entry.
	 *
	 * @return the user ID of this department entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this department entry.
	 *
	 * @param userId the user ID of this department entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this department entry.
	 *
	 * @return the user uuid of this department entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this department entry.
	 *
	 * @param userUuid the user uuid of this department entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this department entry.
	 *
	 * @return the user name of this department entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this department entry.
	 *
	 * @param userName the user name of this department entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this department entry.
	 *
	 * @return the create date of this department entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this department entry.
	 *
	 * @param createDate the create date of this department entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this department entry.
	 *
	 * @return the modified date of this department entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this department entry.
	 *
	 * @param modifiedDate the modified date of this department entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the creator ID of this department entry.
	 *
	 * @return the creator ID of this department entry
	 */
	public long getCreatorId();

	/**
	 * Sets the creator ID of this department entry.
	 *
	 * @param creatorId the creator ID of this department entry
	 */
	public void setCreatorId(long creatorId);

	/**
	 * Returns the customer ID of this department entry.
	 *
	 * @return the customer ID of this department entry
	 */
	public long getCustomerId();

	/**
	 * Sets the customer ID of this department entry.
	 *
	 * @param customerId the customer ID of this department entry
	 */
	public void setCustomerId(long customerId);

	/**
	 * Returns the name of this department entry.
	 *
	 * @return the name of this department entry
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this department entry.
	 *
	 * @param name the name of this department entry
	 */
	public void setName(String name);

	/**
	 * Returns the code of this department entry.
	 *
	 * @return the code of this department entry
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this department entry.
	 *
	 * @param code the code of this department entry
	 */
	public void setCode(String code);

	/**
	 * Returns the parent ID of this department entry.
	 *
	 * @return the parent ID of this department entry
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this department entry.
	 *
	 * @param parentId the parent ID of this department entry
	 */
	public void setParentId(long parentId);

	/**
	 * Returns the order of this department entry.
	 *
	 * @return the order of this department entry
	 */
	public Integer getOrder();

	/**
	 * Sets the order of this department entry.
	 *
	 * @param order the order of this department entry
	 */
	public void setOrder(Integer order);

	/**
	 * Returns the type of this department entry.
	 *
	 * @return the type of this department entry
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this department entry.
	 *
	 * @param type the type of this department entry
	 */
	public void setType(String type);

	/**
	 * Returns the business ID of this department entry.
	 *
	 * @return the business ID of this department entry
	 */
	public long getBusinessId();

	/**
	 * Sets the business ID of this department entry.
	 *
	 * @param businessId the business ID of this department entry
	 */
	public void setBusinessId(long businessId);

	/**
	 * Returns the tax of this department entry.
	 *
	 * @return the tax of this department entry
	 */
	@AutoEscape
	public String getTax();

	/**
	 * Sets the tax of this department entry.
	 *
	 * @param tax the tax of this department entry
	 */
	public void setTax(String tax);

	/**
	 * Returns the address of this department entry.
	 *
	 * @return the address of this department entry
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this department entry.
	 *
	 * @param address the address of this department entry
	 */
	public void setAddress(String address);

	/**
	 * Returns the head office of this department entry.
	 *
	 * @return the head office of this department entry
	 */
	@AutoEscape
	public String getHeadOffice();

	/**
	 * Sets the head office of this department entry.
	 *
	 * @param headOffice the head office of this department entry
	 */
	public void setHeadOffice(String headOffice);

	/**
	 * Returns the alias of this department entry.
	 *
	 * @return the alias of this department entry
	 */
	@AutoEscape
	public String getAlias();

	/**
	 * Sets the alias of this department entry.
	 *
	 * @param alias the alias of this department entry
	 */
	public void setAlias(String alias);

	/**
	 * Returns the description of this department entry.
	 *
	 * @return the description of this department entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this department entry.
	 *
	 * @param description the description of this department entry
	 */
	public void setDescription(String description);

	/**
	 * Returns the status of this department entry.
	 *
	 * @return the status of this department entry
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this department entry.
	 *
	 * @param status the status of this department entry
	 */
	public void setStatus(String status);

	/**
	 * Returns the status date of this department entry.
	 *
	 * @return the status date of this department entry
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this department entry.
	 *
	 * @param statusDate the status date of this department entry
	 */
	public void setStatusDate(Date statusDate);

	@Override
	public DepartmentEntry cloneWithOriginalValues();

}