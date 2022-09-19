package com.liferay.docs.guestbook.service.permission;


import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.GuestbookLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {"model.class.name=com.liferay.docs.guestbook.model.Guestbook"}
)
public class GuestbookPermission implements BaseModelPermissionChecker {

    public static void check(
            PermissionChecker permissionChecker, long guestbookId, String actionId) {

    }


    @Override
    public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId) throws PortalException {

    }

    public static boolean contains(
            PermissionChecker permissionChecker, long groupId, long guestbookId, String actionId
    ) throws PortalException {
        Guestbook guestbook = _guestbookLocalService.getGuestbook(guestbookId);

        return GuestbookModelPermission.contains(permissionChecker, groupId, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long guestbookId, String actionId) throws PortalException {
        Guestbook guestbook =
                _guestbookLocalService.getGuestbook(guestbookId);

        return contains(permissionChecker, guestbook, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, Guestbook guestbook, String actionId
    ) {
        return permissionChecker.hasPermission(
                guestbook.getGuestbookId(), Guestbook.class.getName(),
                guestbook.getGuestbookId(), actionId
        );
    }

    @Reference(unbind = "-")
    protected void setGuestbookLocalService(GuestbookLocalService guestbookLocalService) {
        _guestbookLocalService = guestbookLocalService;
    }

    private static GuestbookLocalService _guestbookLocalService;
}
