package com.dogoo.common.exception.model;

import com.liferay.portal.kernel.exception.PortalException;

public class DG_InvalidStructureException extends PortalException {
    public DG_InvalidStructureException() {
    }

    public DG_InvalidStructureException(String msg) {
        super(msg);
    }

    public DG_InvalidStructureException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public DG_InvalidStructureException(Throwable throwable) {
        super(throwable);
    }

}
