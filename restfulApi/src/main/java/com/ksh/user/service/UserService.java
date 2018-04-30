package com.ksh.user.service;

import com.google.common.collect.Maps;
import com.ksh.common.model.ResultCode;
import com.ksh.user.model.User;
import com.ksh.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, Object> getUserInfo(Map<String, Object> params){
        Map<String, Object> result = Maps.newHashMap();
        User user = new User();
        user = userRepository.selectUserInfo(params);
        if(user.getUserId().equals("") && !user.getUserId().isEmpty()){
            result.put("result","SUCCESS");
            result.put("code", ResultCode.Success);
            result.put("data",user);
        }else{
            result.put("result","FAIL");
            result.put("code", ResultCode.Fail);
            result.put("message","result null");
        }

        return result;
    }

}
