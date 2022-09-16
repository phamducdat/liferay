package com.dogoo.common.exception.mapper;

import com.dogoo.common.exception.model.ExceptionType;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;

//@Component (
//        property = {
//                "osgi.jaxrs.application.select=(osgi.jaxrs.name=*)",
//                "osgi.jaxrs.extension=true",
//                "osgi.jaxrs.name=Dogoo.Common.Exception.ExpiredJwtException"
//        },
//        service = javax.ws.rs.ext.ExceptionMapper.class,
//        immediate = true
//)
public class ExceptionMapper
        extends BaseExceptionMapper<Exception> {

    private final String TITLE_MSG = "[DG] - Common Exception";

    @Override
    protected Problem getProblem(Exception exception) {

        return new Problem(exception.getMessage(),
                Response.Status.INTERNAL_SERVER_ERROR,
                TITLE_MSG,
                ExceptionType.Status.COMMON.name());
    }
}
