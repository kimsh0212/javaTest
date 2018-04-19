package com.ksh.common.model;

import lombok.Data;

@Data
public class ApiResult<T> {
    private String result;
    private String resultCode;
    private String resultMessage;
    private String totalCount;
    private T data;
}
