package com.dogoo.common.httpinvoker.impl;

import com.dogoo.common.httpinvoker.api.CommonHttpInvokerApi;
import com.dogoo.common.httpinvoker.http.HttpInvoker;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

@Component(
        immediate = true, service = CommonHttpInvokerApi.class
)
public class CommonHttpInvokerApiImpl implements CommonHttpInvokerApi {

    public CommonHttpInvokerApiImpl() {}

    public CommonHttpInvokerApiImpl(Builder builder) {
        _builder = builder;
    }

    private Builder _builder;

    @Override
    public HttpInvoker.HttpResponse callApiHttpResponse(String body,
                                                        HttpInvoker.HttpMethod method,
                                                        String path) throws Exception {

        HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

        httpInvoker.body(body, "application/json");

        if (_builder._locale != null) {
            httpInvoker.header(
                    "Accept-Language", _builder._locale.toLanguageTag());
        }

        for (Map.Entry<String, String> entry :
                _builder._headers.entrySet()) {

            httpInvoker.header(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry :
                _builder._parameters.entrySet()) {

            httpInvoker.parameter(entry.getKey(), entry.getValue());
        }

        httpInvoker.httpMethod(method);

        httpInvoker.path(
                _builder._scheme + "://" + _builder._host + ":" +
                        _builder._port + path);

        httpInvoker.userNameAndPassword(
                _builder._login + ":" + _builder._password);

        return httpInvoker.invoke();
    }

}
