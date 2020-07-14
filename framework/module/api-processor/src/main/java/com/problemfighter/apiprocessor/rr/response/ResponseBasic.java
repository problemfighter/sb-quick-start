package com.problemfighter.apiprocessor.rr.response;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "errorResponse")
public class ResponseBasic extends ResponseBase {
    public Error error;
    public String message;
}
