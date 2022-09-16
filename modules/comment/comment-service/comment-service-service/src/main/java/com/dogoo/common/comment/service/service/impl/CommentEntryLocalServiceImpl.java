/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dogoo.common.comment.service.service.impl;

import com.dogoo.authz.account.service.model.AccountEntry;
import com.dogoo.authz.account.service.service.AccountEntryLocalService;
import com.dogoo.common.comment.service.exception.NoSuchCommentEntryException;
import com.dogoo.common.comment.service.mapper.model.CommentMapperModel;
import com.dogoo.common.comment.service.model.CommentEntry;
import com.dogoo.common.comment.service.service.base.CommentEntryLocalServiceBaseImpl;
import com.dogoo.core.workflow.service.mapper.model.NotificationModel;
import com.dogoo.core.workflow.service.service.NotificationEntryLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.dogoo.common.comment.service.model.CommentEntry",
        service = AopService.class
)
public class CommentEntryLocalServiceImpl
        extends CommentEntryLocalServiceBaseImpl {

	@Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public CommentEntry addComment(long customerId,
                                   long creatorId,
                                   CommentMapperModel model,
                                   ServiceContext serviceContext) {

        CommentEntry commentEntry = createCommentEntry(
                counterLocalService.increment(CommentEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                customerId,
                creatorId,
                commentEntry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        updateCommentData(commentEntry, model, serviceContext);

        return addCommentEntry(commentEntry);

    }

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public CommentEntry updateComment(long commentId,
                                      CommentMapperModel model,
                                      ServiceContext serviceContext)
            throws NoSuchCommentEntryException {

        CommentEntry commentEntry = commentEntryPersistence.findByPrimaryKey(commentId);

        updateCommentData(commentEntry, model, serviceContext);

        return updateCommentEntry(commentEntry);
    }

    public List<CommentEntry> getCommentsByPkIdAndPkName(long customerId,
                                                         long classPkId,
                                                         String classPkName) {
        return commentEntryPersistence.findByC_C_C(customerId, classPkId, classPkName);
    }

    public List<CommentEntry> getCommentsByPkIdAndPkNameOfTreeComment(long customerId,
                                                                      long classPkId,
                                                                      String classPkName,
                                                                      long parentId) {
        return commentEntryPersistence.findByC_C_C_P(customerId, classPkId, classPkName, parentId);
    }


    public List<CommentEntry> getCommentsByPkParentId(long parentId) {
        return commentEntryPersistence.findByP_(parentId);
    }

    private void addNotification(
            long id,
            String mentionChar,
            String classPkName,
            long employeeId,
            long customerId,
            long creatorId,
            ServiceContext serviceContext) {

        NotificationModel notificationModel = new NotificationModel();

        String notificationType;

        if (mentionChar.equals("@")) {
			notificationType = "notification";
        } else {
			notificationType = "sms";
        }

        AccountEntry accountEntry = _accountEntryLocalService.fetchAccountEntry(creatorId);

        String description = " đã nhắc bạn trong một bình luận. Bạn có thể nhấp vào đường dẫn để xem.";

        if (Validator.isNull(accountEntry)) {
            description = "Admin" + description;
        } else {
            description = accountEntry.getFullName() + description;
        }

        Date current = new Date();

        notificationModel.setCategory(classPkName);
        notificationModel.setType(notificationType);
        notificationModel.setName(classPkName);
        notificationModel.setDescription(description);
        notificationModel.setDoEntryId(id);
        notificationModel.setTaskInstanceId(0L);
        notificationModel.setReceiverId(employeeId);
        notificationModel.setCount(0);

        _notificationEntryLocalService.addNotification(
                customerId,
                creatorId,
                notificationModel,
                serviceContext
        );
    }

    private void updateCommentData(CommentEntry commentEntry,
                                   CommentMapperModel model,
                                   ServiceContext serviceContext) {
        commentEntry.setClassPkId(model.getClassPkId());
        commentEntry.setClassPkName(model.getClassPkName());
        commentEntry.setContent(model.getContent());
        commentEntry.setCreatorFullName(model.getCreatorFullName());
        commentEntry.setParentId(model.getParentId());

        Arrays.stream(model.getMentions()).forEach(mention -> addNotification(
				model.getClassPkId(),
				mention.getMentionChar(),
				model.getClassPkName(),
				mention.getId(),
				commentEntry.getCustomerId(),
				commentEntry.getCreatorId(),
				serviceContext));
    }

    private void createModifierAudit(long customerId,
                                     long creatorId,
                                     CommentEntry entry,
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
                                     CommentEntry entry,
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

    @Reference
    NotificationEntryLocalService _notificationEntryLocalService;

	@Reference
    AccountEntryLocalService _accountEntryLocalService;
}