package com.dogoo.common.exception.mapper;

import com.dogoo.common.exception.model.DG_NoSuchEntryException;
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
                "osgi.jaxrs.name=Dogoo.Common.Exception.DG_NoSuchEntryException"
        },
        service = ExceptionMapper.class
)
public class NoSuchEntryExceptionMapper
        extends BaseExceptionMapper<DG_NoSuchEntryException> {

    private final String TITLE_MSG = "[DG] - No Such Entry Exception";

    @Override
    protected Problem getProblem(DG_NoSuchEntryException exception) {

        return new Problem(exception.getMessage(),
                Response.Status.NOT_FOUND,
                TITLE_MSG,
                ExceptionType.Status.RESOURCE.name());
    }
}
