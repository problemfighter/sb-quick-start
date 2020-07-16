package com.problemfighter.apiprocessor.rr;


import com.problemfighter.apiprocessor.rr.response.ResponseBase;
import com.problemfighter.apiprocessor.rr.response.ResponseBasic;
import com.problemfighter.apiprocessor.rr.response.ResponseData;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public class ApiResponse2<T> extends ResponseBase {

    @Schema(name = "response", oneOf = {ResponseBasic.class, ResponseData.class})
    public T data;
}
