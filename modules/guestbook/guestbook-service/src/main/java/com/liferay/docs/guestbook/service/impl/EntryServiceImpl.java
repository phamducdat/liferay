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

package com.liferay.docs.guestbook.service.impl;

import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.service.base.EntryServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author liferay
 */
@Component(
	property = {
		"json.web.service.context.name=gb",
		"json.web.service.context.path=Entry"
	},
	service = AopService.class
)
public class EntryServiceImpl extends EntryServiceBaseImpl {

	public Entry addEntry(long userId, long guestbookId, String name, String email,
						  String message, ServiceContext serviceContext) throws PortalException {
		return entryLocalService.addEntry(userId, guestbookId, name, email, message, serviceContext);
	}

	public List<Entry> getEntries(long groupId, long guestbookId) {
		return entryLocalService.getEntries(groupId, guestbookId);
	}

	public List<Entry> getEntries(long groupId, long guestbookId, int start, int end) {
		return entryLocalService.getEntries(groupId, guestbookId, start, end);
	}

	public int getEntriesCount(long groupId, long guestbookId) {
		return  entryLocalService.getEntriesCount(groupId, guestbookId);
	}
	public Entry updateEntry(long userId, long guestbookId, long entryId,
							 String name, String email, String message,
							 ServiceContext serviceContext) throws PortalException,
			SystemException {

		return entryLocalService.updateEntry(userId, guestbookId, entryId,
				name, email, message, serviceContext);
	}

}