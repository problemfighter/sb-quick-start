package com.problemfighter.apiprocessor.rr.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.problemfighter.apiprocessor.exception.ErrorCode;
import io.swagger.annotations.ApiModel;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "details", description = "status success response")
public class DetailsResponse<T> extends ErrorAndBaseData {
    public T data;


    public void success() {
        this.code = ErrorCode.success;
        this.status = Status.success;
    }

    public void error() {
        this.code = ErrorCode.error;
        this.status = Status.error;
    }
}

