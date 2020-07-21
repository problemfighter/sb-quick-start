package com.problemfighter.apiprocessor.rr.response;


import io.swagger.annotations.ApiModel;

@ApiModel(value = "details", description = "status success response")
public class DetailsResponse<T> extends ErrorAndBaseData {
    public T data;
}

