package com.ksh.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2017-07-04.
 */

@Slf4j
public class LocationDomain implements ServletContextListener {
    static public Map<String, Object> cdnDomainList;

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

        // cdn 도메인 리스트를 디비로 관리?
        cdnDomainList = new HashMap<String, Object>();
        cdnDomainList.put("KR", "http://52ad3.http.seo01.cdn.softlayer.net/WinUS_DEV");
        cdnDomainList.put("US", "http://52AD3.http.dal05.cdn.softlayer.net/DShare_Dallas");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}