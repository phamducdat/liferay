package com.liferay.docs.guestbook.search;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.permission.GuestbookPermission;
import com.liferay.portal.kernel.dao.db.Index;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.Locale;

@Component(
        immediate = true,
        service = Index.class
)
public class GuestbookIndexer extends BaseIndexer<Guestbook> {

    public static final String CLASS_NAME = Guestbook.class.getName();

    public GuestbookIndexer() {
        setDefaultSelectedFieldNames(
                Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
                Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
                Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID
        );

        setPermissionAware(true);
        setFilterSearch(true);
    }

    @Override
    protected void doDelete(Guestbook object) throws Exception {
        deleteDocument(object.getCompanyId(), object.getGuestbookId());
    }

    @Override
    protected Document doGetDocument(Guestbook object) throws Exception {
        Document document = getBaseModelDocument(CLASS_NAME, object);

        document.addDate(Field.MODIFIED_DATE, object.getModifiedDate());

        Locale defaultLocale =
                PortalUtil.getSiteDefaultLocale(object.getGroupId());
        String localizedField = LocalizationUtil.getLocalizedName(Field.TITLE, defaultLocale.toString());

        document.addText(localizedField, object.getName());
        return document;
    }

    @Override
    protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest, PortletResponse portletResponse) throws Exception {
        return null;
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {

    }

    @Override
    protected void doReindex(String[] ids) throws Exception {

    }

    @Override
    protected void doReindex(Guestbook object) throws Exception {

    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, String actionId) throws Exception {
        return GuestbookPermission.contains(
                permissionChecker, entryClassPK, ActionKeys.VIEW
        );
    }

    @Override
    public void postProcessContextBooleanFilter(BooleanFilter contextBooleanFilter, SearchContext searchContext) throws Exception {
        addStatus(contextBooleanFilter, searchContext);
    }

    @Override
    public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter, SearchContext searchContext) throws Exception {
        addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
    }
}
