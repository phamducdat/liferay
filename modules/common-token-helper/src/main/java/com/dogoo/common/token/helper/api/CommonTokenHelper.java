package com.dogoo.common.token.helper.api;

import com.dogoo.common.token.model.AccountTokenModel;
import com.dogoo.common.token.model.UserTokenModel;
import com.dogoo.common.token.service.JwtService;
import com.dogoo.common.token.util.ClaimsKeys;
import com.dogoo.common.token.util.TokenKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.util.GetterUtil;
import io.jsonwebtoken.Claims;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

/**
 * @author khoa
 */

@Component(immediate = true, service = CommonTokenHelper.class)
public class CommonTokenHelper {

    public UserTokenModel getUserToken(HttpServletRequest httpServletRequest) {
        String userContext = httpServletRequest.getHeader(TokenKeys.USER_CONTEXT);

        Claims claims = _jwtService.decodeJWToken(userContext);

        UserTokenModel userToken = new UserTokenModel();

        userToken.setUserId(GetterUtil.getLong(claims.get(ClaimsKeys.USER_ID)));
        userToken.setCustomerId(GetterUtil.getLong(claims.get(ClaimsKeys.CUSTOMER_ID)));
        userToken.setEmail(GetterUtil.getString(claims.get(ClaimsKeys.EMAIL)));
        userToken.setScreenName(GetterUtil.getString(claims.get(ClaimsKeys.SCREEN_NAME)));
        userToken.setFullName(GetterUtil.getString(claims.get(ClaimsKeys.FULL_NAME)));
        userToken.setAccount(getAccountTokenModel(claims));
        userToken.setCustomer(GetterUtil.getString(claims.get(ClaimsKeys.CUSTOMER_NAME)));
        userToken.setEmployeeId(GetterUtil.getLong(claims.get(ClaimsKeys.EMPLOYEE)));
        userToken.setAccountId(GetterUtil.getLong(claims.get(ClaimsKeys.ACCOUNT_ID)));

        return userToken;
    }

    private AccountTokenModel getAccountTokenModel(Claims claims) {
        LinkedHashMap<String, Object> accountHash =
                (LinkedHashMap<String, Object>) claims.get(ClaimsKeys.ACCOUNT);

        ObjectMapper oMapper = new ObjectMapper();

        AccountTokenModel accountTokenModel = oMapper.convertValue(accountHash, AccountTokenModel.class);

        return accountTokenModel;
    }

    @Reference
    private JwtService _jwtService;
}