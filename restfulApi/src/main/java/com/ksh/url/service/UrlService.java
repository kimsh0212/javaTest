package com.ksh.url.service;

import com.google.common.collect.Maps;
import com.ksh.common.model.ResultCode;
import com.ksh.url.model.Url;
import com.ksh.url.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public Map<String, Object> getUserUrlList(Map<String, Object> params) {
        Map<String, Object> result = Maps.newHashMap();
        List<Url> urlList = urlRepository.selectUserUrlList(params);

        if(urlList.size() > 0){
            result.put("result","SUCCESS");
            result.put("code",ResultCode.Success);
            result.put("data",urlList);
        }else{
            result.put("result","FAIL");
            result.put("code", ResultCode.Fail);
            result.put("message","Api info is null");
        }

        return result;
    }
}
