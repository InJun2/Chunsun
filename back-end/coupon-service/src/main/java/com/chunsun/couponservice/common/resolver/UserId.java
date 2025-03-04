package com.chunsun.couponservice.common.resolver;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({PARAMETER, METHOD})
@Retention(RUNTIME)
public @interface UserId {
}
