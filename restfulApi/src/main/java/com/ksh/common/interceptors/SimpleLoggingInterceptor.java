package com.ksh.common.interceptors;

import com.google.common.collect.Maps;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

/**
 * https://dev.maxmind.com/geoip/legacy/geolite/ 를 이용해서 geoip data 파일을 가져옴.
 * client ip 가 사설 대역인 경우 정보를 가져오지 못함.. 정보가 없을경우 default로 어느 지역을 기준으로 해줄건지 결정이 필요함.*
 *
 * Created by user on 2017-03-02.
 */
@Slf4j

public class SimpleLoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("[Spring mvc]===================== START : " + ((HandlerMethod) handler).getBean().getClass().getName() + " =====================");
            log.debug("Call controller method is : " + ((HandlerMethod) handler).getMethod().getName() + "( )");
            log.debug("\n");
            log.debug("[parameters] ================================================================== ");
            Map parameterMap = Maps.newHashMap();

            Enumeration enums = request.getParameterNames();
            while(enums.hasMoreElements()){
                String paramName = (String)enums.nextElement();
                String[] parameters = request.getParameterValues(paramName);

                if(parameters.length > 1){
                    parameterMap.put(paramName, parameters);
                    log.debug("key : {} , value : {}", paramName, ReflectionToStringBuilder.toString(parameters));
                }else{
                    log.debug("key : {} , value : {}", paramName, parameters[0]);
                }
            }
            log.debug("\n");
            log.debug("----------------------[GEO Location Info]----------------------");
            log.debug("GEOIP_COUNTRY_CODE3 : {}", request.getHeader("GEOIP_COUNTRY_CODE3"));
            log.debug("GEOIP_COUNTRY_NAME : {}", request.getHeader("GEOIP_COUNTRY_NAME"));
            log.debug("GEOIP_CITY_COUNTRY_CODE :{}", request.getHeader("GEOIP_CITY_COUNTRY_CODE"));
            log.debug("GEOIP_CITY_COUNTRY_CODE3 :{}", request.getHeader("GEOIP_CITY_COUNTRY_CODE3"));
            log.debug("GEOIP_CITY_COUNTRY_NAME :{}", request.getHeader("GEOIP_CITY_COUNTRY_NAME"));
            log.debug("GEOIP_REGION :{}", request.getHeader("GEOIP_REGION"));
            log.debug("GEOIP_CITY :{}", request.getHeader("GEOIP_CITY"));
            log.debug("GEOIP_POSTAL_CODE :{}", request.getHeader("GEOIP_POSTAL_CODE"));
            log.debug("GEOIP_CITY_CONTINENT_CODE :{}", request.getHeader("GEOIP_CITY_CONTINENT_CODE"));
            log.debug("GEOIP_LATITUDE :{}", request.getHeader("GEOIP_LATITUDE"));
            log.debug("GEOIP_LONGITUDE :{}", request.getHeader("GEOIP_LONGITUDE"));
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("[Spring mvc]===================== END : " + ((HandlerMethod) handler).getBean().getClass().getName() + " =====================");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
