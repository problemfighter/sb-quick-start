package com.problemfighter.apiprocessor.rr.response;


import io.swagger.annotations.ApiModel;


@ApiModel(value = "message", description = "status success response")
public class MessageResponse extends ErrorAndBaseData {
    public String message;
}
