package com.problemfighter.apiprocessor.rr.response;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "details", description = "status success response")
public class DetailsResponse<T> extends ErrorAndBaseData {
    public T data;
}
