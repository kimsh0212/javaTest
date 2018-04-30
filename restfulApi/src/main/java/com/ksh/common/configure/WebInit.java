package com.ksh.common.configure;

import com.ksh.common.interceptors.SimpleLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebInit implements WebApplicationInitializer {

    @Autowired
    SimpleLoggingInterceptor simpleLoggingInterceptor;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException{
        System.out.println("========= Web Server Start ========");
        return;
    }
}
