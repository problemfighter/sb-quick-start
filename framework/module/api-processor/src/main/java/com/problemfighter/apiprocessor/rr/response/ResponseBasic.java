package com.problemfighter.apiprocessor.rr.response;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "error")
public class ResponseBasic {
    public Error error;
}
