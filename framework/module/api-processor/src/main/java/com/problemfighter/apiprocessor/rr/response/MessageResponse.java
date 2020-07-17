package com.problemfighter.apiprocessor.rr.response;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "message", description = "status success response")
public class MessageResponse extends ErrorAndBaseData {
    public String message;
}
