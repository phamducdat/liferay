package com.dogoo.common.httpinvoker.api;

import com.dogoo.common.httpinvoker.http.HttpInvoker;
import com.dogoo.common.httpinvoker.impl.CommonHttpInvokerApiImpl;
import org.osgi.annotation.versioning.ProviderType;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author khoa
 */

@ProviderType
public interface CommonHttpInvokerApi {

    static Builder builder() {
        return new Builder();
    }

    HttpInvoker.HttpResponse callApiHttpResponse(String body,
                                                 HttpInvoker.HttpMethod method,
                                                 String path) throws Exception;

    class Builder {

        public Builder authentication(String login, String password) {
            _login = login;
            _password = password;

            return this;
        }

        public CommonHttpInvokerApi build() {
            return new CommonHttpInvokerApiImpl(this);
        }

        public Builder endpoint(String host, int port, String scheme) {
            _host = host;
            _port = port;
            _scheme = scheme;

            return this;
        }

        public Builder header(String key, String value) {
            _headers.put(key, value);

            return this;
        }

        public Builder locale(Locale locale) {
            _locale = locale;

            return this;
        }

        public Builder parameter(String key, String value) {
            _parameters.put(key, value);

            return this;
        }

        public Builder parameters(String... parameters) {
            if ((parameters.length % 2) != 0) {
                throw new IllegalArgumentException(
                        "Parameters length is not an even number");
            }

            for (int i = 0; i < parameters.length; i += 2) {
                String parameterName = String.valueOf(parameters[i]);
                String parameterValue = String.valueOf(parameters[i + 1]);

                _parameters.put(parameterName, parameterValue);
            }

            return this;
        }

        private Builder() {
        }

        public Map<String, String> _headers = new LinkedHashMap<>();
        public String _host = "localhost";
        public Locale _locale;
        public String _login = "";
        public String _password = "";
        public Map<String, String> _parameters = new LinkedHashMap<>();
        public int _port = 8080;
        public String _scheme = "http";

    }
}