package com.dogoo.common.exception.mapper;

import com.dogoo.common.exception.model.DG_HaveChildException;
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
                "osgi.jaxrs.name=Dogoo.Common.Exception.DG_HaveChildException"
        },
        service = ExceptionMapper.class
)
public class HaveChildExceptionMapper
        extends BaseExceptionMapper<DG_HaveChildException> {

    private final String TITLE_MSG = "[DG] - Have Child Exception";

    @Override
    protected Problem getProblem(DG_HaveChildException exception) {

        return new Problem(exception.getMessage(),
                Response.Status.CONFLICT,
                TITLE_MSG,
                ExceptionType.Status.RESOURCE.name());
    }
}
