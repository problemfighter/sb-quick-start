package com.problemfighter.apiprocessor.rr.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;


@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public MessageResponse status(Status status){
        this.status = status;
        return this;
    }

    public MessageResponse setCode(String code){
        this.code = code;
        return this;
    }
}
