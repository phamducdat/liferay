package com.dogoo.common.exception.mapper;

import com.dogoo.common.exception.model.DG_FieldRequiredException;
import com.dogoo.common.exception.model.ExceptionType;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Component (
        property = {
                "osgi.jaxrs.application.select=(osgi.jaxrs.name=*)",
                "osgi.jaxrs.extension=true",
                "osgi.jaxrs.name=Dogoo.Common.Exception.DG_FieldRequiredException"
        },
        service = ExceptionMapper.class
)
public class FieldRequiredExceptionMapper
        extends BaseExceptionMapper<DG_FieldRequiredException> {

    private final String TITLE_MSG = "[DG] - Field Required Exception";

    @Override
    protected Problem getProblem(DG_FieldRequiredException exception) {

        return new Problem(exception.getMessage(),
                Response.Status.BAD_REQUEST,
                TITLE_MSG,
                ExceptionType.Status.BAD_REQUEST.name());
    }
}
