package com.ksh.config;

import org.mybatis.spring.SqlSessionTemplate;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DBRoute {
    SqlSessionTemplateType value() default SqlSessionTemplateType.KSH;
}
