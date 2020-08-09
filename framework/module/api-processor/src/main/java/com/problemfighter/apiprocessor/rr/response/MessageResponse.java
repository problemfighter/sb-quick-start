package com.problemfighter.apiprocessor.rr.response;


import io.swagger.annotations.ApiModel;


@ApiModel(value = "message", description = "status success response")
public class MessageResponse extends ErrorAndBaseData {
    public String message;

    public MessageResponse reason(String key, String explanation) {
        addErrorReason(key, explanation);
        return this;
    }

    public MessageResponse errorMessage(String message) {
        addErrorMessage(message);
        return this;
    }
}
