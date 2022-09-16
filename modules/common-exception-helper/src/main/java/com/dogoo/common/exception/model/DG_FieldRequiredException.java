/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.dogoo.common.exception.model;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author khoa
 */
public class DG_FieldRequiredException extends PortalException {

	public DG_FieldRequiredException() {
	}

	public DG_FieldRequiredException(String msg) {
		super(msg);
	}

	public DG_FieldRequiredException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public DG_FieldRequiredException(Throwable throwable) {
		super(throwable);
	}

}