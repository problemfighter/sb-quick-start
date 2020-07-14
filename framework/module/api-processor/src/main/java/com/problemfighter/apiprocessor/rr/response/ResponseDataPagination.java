package com.problemfighter.apiprocessor.rr.response;


import io.swagger.v3.oas.annotations.media.Schema;



@Schema(anyOf = {ResponseBasic.class, ResponseDataPagination.class})
public class ResponseDataPagination<T> extends ResponsePagination {

    public T data;
}
