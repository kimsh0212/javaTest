package com.ksh.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class SqlSessionTemplateAspect {
    @Around(value = "@within(dBRoute) || @annotation(dBRoute)")
    public Object setSqlMapClient(ProceedingJoinPoint pjp, DBRoute dbRoute) throws Throwable{
        Object returnObj = null;

        try {
            if(dbRoute != null){}
        } catch(Throwable t){

        }
        return returnObj;
    }
}
