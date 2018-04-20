package com.ksh.apimanage.controller;

import com.google.common.collect.Maps;
import com.ksh.apimanage.model.ApiData;
import com.ksh.apimanage.service.ApiManageService;
import com.ksh.common.util.ResponseEntityUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ApiManageController {

    @Autowired
    private ApiManageService apiManageService;

    @RequestMapping(value="/apiList", method = RequestMethod.POST)
    public ResponseEntity apiListAdd(@RequestParam Map<String, Object> params) throws Exception{
        Map<String, Object> result = Maps.newHashMap();
        if(StringUtils.isNotEmpty(MapUtils.getString(params, "apiName")) || StringUtils.isNotEmpty(MapUtils.getString(params, "apiType"))) {
            result = apiManageService.ApiAdd(params);
        }else{
            result.put("code","0001");
            result.put("message","Invalid not parameter");
            result.put("result","FAIL");
        }
        return ResponseEntityUtil.getResponseData(result);
    }

    @RequestMapping(value="/apiList", method = RequestMethod.GET)
    public ResponseEntity apiList() throws Exception{
        Map<String, Object> result = Maps.newHashMap();
        List<ApiData> apiList = apiManageService.apiList();

        if(apiList.size() > 0){
            result.put("code","0000");
            result.put("result","SUCCESS");
            result.put("data",apiList);
        }else{
            result.put("code","0101");
            result.put("result","FAIU");
            result.put("message","Api List -- 0");
        }

        return ResponseEntityUtil.getResponseData(result);
    }
}
