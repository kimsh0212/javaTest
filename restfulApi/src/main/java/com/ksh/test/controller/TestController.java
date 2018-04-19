package com.ksh.test.controller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import com.ksh.common.util.ResponseEntityUtil;
import com.ksh.test.model.Test;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ksh.common.model.ApiResult;
import org.springframework.web.bind.annotation.*;
import com.ksh.test.service.TestService;
import javax.servlet.http.HttpServletRequest;

import java.util.Map;
@Slf4j
@RestController
public class TestController{
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> selectUtcTimeInfo(){
        Map<String, Object> result = Maps.newHashMap();
        Test timeInfo =testService.selectUtcTimeInfoService();
        result.put("data",timeInfo);
        return ResponseEntityUtil.getResponseData(result);
    }
}
