package com.dogoo.common.comment.rest.internal.resource.v2_0;

import com.dogoo.common.comment.rest.dto.v2_0.Emoticon;
import com.dogoo.common.comment.rest.internal.service.EmoticonService;
import com.dogoo.common.comment.rest.internal.util.LanguageKeys;
import com.dogoo.common.comment.rest.internal.validator.EmoticonValidator;
import com.dogoo.common.comment.rest.resource.v2_0.EmoticonResource;

import com.dogoo.common.token.helper.api.CommonTokenHelper;
import com.dogoo.common.token.model.UserTokenModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.List;
import java.util.Locale;

/**
 * @author khoa
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/emoticon.properties",
	scope = ServiceScope.PROTOTYPE, service = EmoticonResource.class
)
public class EmoticonResourceImpl extends BaseEmoticonResourceImpl {

	@Override
	public Page<Emoticon> getEmoticons(Long classPkId, String classPkName) throws Exception {
		List<Emoticon> emoticons = _emoticonService.
				getEmoticonByClassPkIdAndClassPkName(getUserToken().getCustomerId(),
													classPkId,
													classPkName);
		return Page.of(emoticons);
	}

	@Override
	public Emoticon postEmoticon(Emoticon emoticon) throws Exception {

		_emoticonValidator.validatorUserIdWasExpressive(
				getUserToken().getCustomerId(),
				getUserToken().getUserId(),
				emoticon.getClassPkId(),
				emoticon.getClassPkName(),
				getLocale());

		_emoticonValidator.validatorEmojiNotFound(
				emoticon.getEmoji(),
				getLocale());

		return _emoticonService.postEmoticon(
				getUserToken().getCustomerId(),
				getUserToken().getUserId(),
				getUserToken().getFullName(),
				emoticon,
				getServiceContext());
	}

	@Override
	public void deleteEmoticon(Long emoticonId) throws Exception {
		_emoticonValidator.validatorEmoticonIsNotOfUserId(
				getUserToken().getUserId(),
				emoticonId,
				getLocale());

		_emoticonService.deleteEmoticon(emoticonId);
	}

	@Override
	public Emoticon putEmoticon(Long emoticonId, Emoticon emoticon) throws Exception {

		_emoticonValidator.validatorEmoticonIsNotOfUserId(
				getUserToken().getUserId(),
				emoticonId,
				getLocale());

		_emoticonValidator.validatorEmojiNotFound(
				emoticon.getEmoji(),
				getLocale());

		return _emoticonService.updateEmoticonByEmotionId(
				emoticonId,
				emoticon ,
				getServiceContext() );
	}

	@Override
	public Emoticon getEmoticonByUser(Long classPkId, String classPkName, Long creatorUserId) throws Exception {
		return _emoticonService.getEmoticonByClassPkIdAndClassPkNameAndUserId(
				getUserToken().getCustomerId(),
				classPkId,
				classPkName,
				creatorUserId );
	}

	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		return serviceContext;
	}

	public Locale getLocale() {

		Locale locale = contextHttpServletRequest.getLocale();

		if (locale.getLanguage().isEmpty()) {
			locale = new Locale(LanguageKeys.DEFAULT_LANG, LanguageKeys.DEFAULT_COUNTRY);
		}

		return locale;
	}

	public UserTokenModel getUserToken() {
		return _commonTokenHelper.getUserToken(contextHttpServletRequest);
	}

	@Reference
	private EmoticonService _emoticonService;

	@Reference
	private CommonTokenHelper _commonTokenHelper;

	@Reference
	private EmoticonValidator _emoticonValidator;

}