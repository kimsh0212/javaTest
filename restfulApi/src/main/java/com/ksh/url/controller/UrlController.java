package com.ksh.url.controller;

import com.google.common.collect.Maps;
import com.ksh.common.model.ApiResult;
import com.ksh.common.util.ResponseEntityUtil;
import com.ksh.url.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UrlController {
    @Autowired
    private UrlService urlService;

    @RequestMapping(value="/url/urlList")
    public ResponseEntity<ApiResult> getUrlList(@RequestParam Map<String, Object> params){
        Map<String, Object> result = Maps.newHashMap();
        result = urlService.getUserUrlList(params);
        return ResponseEntityUtil.getResponseData(result);
    }
}
