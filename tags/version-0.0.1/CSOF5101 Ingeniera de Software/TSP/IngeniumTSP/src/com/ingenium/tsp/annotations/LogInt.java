package com.ingenium.tsp.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Ingenium
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR })
public @interface LogInt {

    String date() default "";

    String intId() default "";

    String cycle() default "";

    String responsible() default "";

    int min() default 0;
}
