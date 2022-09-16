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

package com.dogoo.common.comment.service.service.impl;

import com.dogoo.common.comment.service.exception.NoSuchCommentEntryException;
import com.dogoo.common.comment.service.exception.NoSuchEmoticonEntryException;
import com.dogoo.common.comment.service.mapper.model.CommentMapperModel;
import com.dogoo.common.comment.service.mapper.model.EmoticonMapperModel;
import com.dogoo.common.comment.service.model.CommentEntry;
import com.dogoo.common.comment.service.model.EmoticonEntry;
import com.dogoo.common.comment.service.service.base.EmoticonEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.dogoo.common.comment.service.model.EmoticonEntry",
	service = AopService.class
)
public class EmoticonEntryLocalServiceImpl
	extends EmoticonEntryLocalServiceBaseImpl {

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor =  {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public EmoticonEntry addEmoticon(long customerId,
								   long creatorId,
								   EmoticonMapperModel model,
								   ServiceContext serviceContext){

		EmoticonEntry emoticonEntry = createEmoticonEntry(
				counterLocalService.increment(EmoticonEntry.class.getName()));

		Date current = new Date();

		createModifierAudit(
				customerId,
				creatorId,
				emoticonEntry,
				current,
				userLocalService.fetchUser(serviceContext.getUserId()),
				serviceContext);

		updateEmoticonData(emoticonEntry , model);

		return addEmoticonEntry(emoticonEntry);

	}

	@Transactional(
			isolation = Isolation.PORTAL,
			rollbackFor =  {PortalException.class, SystemException.class})
	@Indexable(type = IndexableType.REINDEX)
	public EmoticonEntry updateEmoticon(long emoticonId,
									  EmoticonMapperModel model,
									  ServiceContext serviceContext)
			throws NoSuchEmoticonEntryException {

		EmoticonEntry emoticonEntry = emoticonEntryPersistence.findByPrimaryKey(emoticonId);

		updateEmoticonData(emoticonEntry, model);

		return updateEmoticonEntry(emoticonEntry);
	}

	public List<EmoticonEntry> getEmoticonEntriesByClassPkIdAndClassPkName(long customerId,
															 long classPkId,
															 String classPkName){
		return emoticonEntryPersistence.findByC_C_C(customerId , classPkId , classPkName);
	}

	public EmoticonEntry getEmoticonEntriesByClassPkIdAndClassPkNameAndUser(long customerId,
																				  long classPkId,
																				  String classPkName,
																				  long creatorId) throws NoSuchEmoticonEntryException {
		return emoticonEntryPersistence.fetchByC_C_C_C(customerId,classPkId,classPkName,creatorId);
	}

	private void updateEmoticonData(EmoticonEntry emoticonEntry,
									EmoticonMapperModel model) {
		emoticonEntry.setClassPkId(model.getClassPkId());
		emoticonEntry.setClassPkName(model.getClassPkName());
		emoticonEntry.setCreatorFullName(model.getCreatorFullName());
		emoticonEntry.setEmoji(model.getEmoji());
	}

	private void createModifierAudit(long customerId,
									 long creatorId,
									 EmoticonEntry entry,
									 Date current,
									 User user,
									 ServiceContext serviceContext) {

		entry.setCustomerId(customerId);
		entry.setGroupId(serviceContext.getScopeGroupId());
		entry.setCompanyId(serviceContext.getCompanyId());
		entry.setCreateDate(serviceContext.getCreateDate(current));
		entry.setExternalReferenceCode(UUID.randomUUID().toString());

		updateModifierAudit(creatorId, entry, current, user, serviceContext);
	}

	private void updateModifierAudit(long creatorId,
									 EmoticonEntry entry,
									 Date current,
									 User user,
									 ServiceContext serviceContext) {

		if (user != null) {
			entry.setUserName(user.getFullName());
			entry.setUserUuid(user.getUserUuid());
		}

		entry.setModifiedDate(serviceContext.getModifiedDate(current));
		entry.setUserId(serviceContext.getUserId());
		entry.setCreatorId(creatorId);
	}
}