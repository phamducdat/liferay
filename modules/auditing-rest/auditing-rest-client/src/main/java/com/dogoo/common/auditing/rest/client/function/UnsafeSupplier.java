package com.dogoo.common.auditing.rest.client.function;

import javax.annotation.Generated;

/**
 * @author khoa
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}