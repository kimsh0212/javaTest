package com.ksh.apimanage.service;

import com.google.common.collect.Maps;
import com.ksh.apimanage.model.ApiData;
import com.ksh.apimanage.repository.ApiManageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ApiManageService {

    @Autowired
    private ApiManageRepository apiManageRepository;

    /**
     *
     * @param params
     * @return
     * @throws Exception
     */
    public Map<String, Object> ApiAdd(Map<String, Object> params) throws Exception{
        Map<String, Object> resultMap = Maps.newHashMap();
        int result = 0;
        try{
            result = apiManageRepository.apiAddInsert(params);
        }catch(Exception e){
            result = 0;
        }

        if(result != 1 ){
            resultMap.put("code","0001");
            resultMap.put("result","FAIL");
            resultMap.put("message","Insert Failed");
        }else{
            resultMap.put("code","0000");
            resultMap.put("result","SUCCESS");
            resultMap.put("message","Insert Api Data Success");
        }
        return resultMap;
    }

    public List<ApiData> apiList() throws Exception{
        List<ApiData> apiList = apiManageRepository.selectAptList();
        return apiList;
    }
}
