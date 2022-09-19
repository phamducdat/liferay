package com.liferay.docs.guestbook.service.permission;

import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.service.EntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {"model.class.name=com.liferay.docs.guestbook.model.Entry"}
)
public class EntryPermission extends BaseResourcePermissionChecker {

    public static void check(
            PermissionChecker permissionChecker, long entryId, String actionId)
            throws PortalException, SystemException {

        if (!contains(permissionChecker, entryId, actionId)) {
            throw new PrincipalException();
        }
    }


    public static boolean contains(
            PermissionChecker permissionChecker,
            long entryId,
            String actionId
    ) throws PortalException {
        Entry entry = _entryLocalService.getEntry(entryId);

        return contains(permissionChecker, entry, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, Entry entry, String actionId
    ) {
        return permissionChecker.hasPermission(entry.getGroupId(),
                Entry.class.getName(),
                entry.getEntryId(),
                actionId);
    }

    @Reference(unbind = "-")
    protected void setEntryLocalService(EntryLocalService entryLocalService) {
        _entryLocalService = entryLocalService;
    }

    private static EntryLocalService _entryLocalService;

    @Override
    public Boolean checkResource(PermissionChecker permissionChecker, long classPK, String actionId) {
        return null;
    }
}
