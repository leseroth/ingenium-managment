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
public @interface LogT {

    String date() default "";

    String taskId() default "";

    int min() default 0;

    String cycle() default "";

    String responsible() default "";
}
