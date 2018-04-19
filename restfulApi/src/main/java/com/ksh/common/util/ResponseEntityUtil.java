package com.ksh.common.util;

import com.ksh.common.model.ApiResult;
import com.ksh.common.model.ResultCode;
import org.apache.commons.collections.MapUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * Created by becko on 2017-02-26.
 */
public class ResponseEntityUtil {

    /**
     * 2017.07.06
     * seungyong.lee
     * 결과코드 추가
     * @param resultMessage
     * @param data
     * @param resultCode
     * @return
     */
    public static ResponseEntity getResponse(String resultMessage, Object data, String resultCode) {
        ApiResult apiResult = new ApiResult();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

        apiResult.setResult("SUCCESS");
        apiResult.setResultCode(resultCode);

        apiResult.setResultMessage(resultMessage);

        if (data != null) {
            apiResult.setData(data);
        }

        return new ResponseEntity(apiResult, responseHeaders, HttpStatus.OK);
    }

    public static ResponseEntity getResponse(String resultMessage, Object data) {
        ApiResult apiResult = new ApiResult();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

        apiResult.setResult("SUCCESS");
        apiResult.setResultMessage(resultMessage);

        if (data != null) {
            apiResult.setData(data);
            apiResult.setResultCode(dataResultCode(data));
        }

        return new ResponseEntity(apiResult, responseHeaders, HttpStatus.OK);
    }

    public static ResponseEntity getResponse(Object data) {
        ApiResult apiResult = new ApiResult();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

        apiResult.setResult("SUCCESS");

        if (data != null) {
            apiResult.setData(data);
            apiResult.setResultCode(dataResultCode(data));
        }

        return new ResponseEntity(apiResult, responseHeaders, HttpStatus.OK);
    }

    public static ResponseEntity getResponse(Object data, String totalCount) {
        ApiResult apiResult = new ApiResult();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

        apiResult.setResult("SUCCESS");

        if (data != null) {
            apiResult.setData(data);
            apiResult.setTotalCount(totalCount);
            apiResult.setResultCode(dataResultCode(data));
        }

        return new ResponseEntity(apiResult, responseHeaders, HttpStatus.OK);
    }

    public static ResponseEntity getResponse() {
        ApiResult apiResult = new ApiResult();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

        apiResult.setResult("SUCCESS");

        return new ResponseEntity(apiResult, responseHeaders, HttpStatus.OK);
    }

    //get Fail Respense
    public  static ResponseEntity getFailResponse(String resultMessage, Object data){
        ApiResult apiResult = new ApiResult();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

        apiResult.setResult("FAIL");
        apiResult.setResultMessage(resultMessage);

        if (data != null) {
            apiResult.setData(data);
            apiResult.setResultCode(dataResultCode(data));
        }


        return new ResponseEntity(apiResult, responseHeaders, HttpStatus.OK);
    }

    public static String dataResultCode(Object data){
        String resultCode;

        if(!data.toString().contains("resultCode")){
            resultCode = ResultCode.Success;
        }else{
            int resultIndex= data.toString().indexOf("resultCode") + 11;
            resultCode=data.toString().substring(resultIndex,resultIndex+4);
        }
        return resultCode;
    }

    public static ResponseEntity getResponseData(Map<String, Object> data){
        ApiResult apiResult = new ApiResult();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

        apiResult.setResult(MapUtils.getString(data,"result"));
        apiResult.setResultCode(MapUtils.getString(data,"code"));
        if(data.get("message")!=null){
            apiResult.setResultMessage(MapUtils.getString(data,"message"));
        }
        if(data.get("data") != null) {
            apiResult.setData(data.get("data"));
        }

        return new ResponseEntity(apiResult, responseHeaders, HttpStatus.OK);
    }
}