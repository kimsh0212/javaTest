package com.ksh.user.controller;

import com.google.common.collect.Maps;
import com.ksh.common.model.ApiResult;
import com.ksh.common.util.ResponseEntityUtil;
import com.ksh.user.model.User;
import com.ksh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user/info")
    public ResponseEntity<ApiResult> getUserInfo(@RequestParam Map<String, Object> params){
        Map<String, Object> result = Maps.newHashMap();
        result = userService.getUserInfo(params);
        return ResponseEntityUtil.getResponseData(result);
    }
}
