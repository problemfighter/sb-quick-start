package com.problemfighter.apiprocessor.rr;


import com.problemfighter.apiprocessor.rr.response.ErrorData;
import com.problemfighter.apiprocessor.rr.response.ResponseBase;
import com.problemfighter.apiprocessor.rr.response.ResponseData;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "response", oneOf = {ErrorData.class, ResponseData.class})
public class ApiResponse2<T> extends ResponseBase {
    public T data;
}
