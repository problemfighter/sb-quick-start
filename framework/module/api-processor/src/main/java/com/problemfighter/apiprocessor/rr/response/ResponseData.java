package com.problemfighter.apiprocessor.rr.response;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "data")
public class ResponseData<T> {
    public T data;
    public String database;
}
