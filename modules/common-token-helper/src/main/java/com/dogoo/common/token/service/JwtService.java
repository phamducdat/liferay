package com.dogoo.common.token.service;

import com.dogoo.common.token.util.Helper;
import com.dogoo.common.token.util.TokenKeys;
import com.liferay.portal.kernel.util.Validator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.osgi.service.component.annotations.Component;

import javax.xml.bind.DatatypeConverter;
import java.util.Properties;

@Component(immediate = true, service = JwtService.class)
public class JwtService {
    private Properties AUTHZ_PROPERTIES =
            new Helper().loadResourceBundled("/configuration/authz.properties");

    public Claims decodeJWToken(String token) {
        if (Validator.isNull(token)) {
            return null;
        }

        return Jwts.parserBuilder()
                .setSigningKey(
                        DatatypeConverter
                                .parseBase64Binary(AUTHZ_PROPERTIES.getProperty(TokenKeys.SECRET_KEY)))
                .build()
                .parseClaimsJws(token).getBody();
    }

}
