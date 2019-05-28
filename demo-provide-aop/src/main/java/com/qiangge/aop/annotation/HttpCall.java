package com.qiangge.aop.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface HttpCall {
    String value() default "";
}
