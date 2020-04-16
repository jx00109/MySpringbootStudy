package com.ytj.aoplogger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: MySpringbootStudy
 * @description: 自定义方法级别的注解Log
 * @author: admin
 * @create: 2020-04-16 10:49
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
