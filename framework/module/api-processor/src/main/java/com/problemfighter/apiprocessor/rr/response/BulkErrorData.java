package com.problemfighter.apiprocessor.rr.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.LinkedHashMap;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BulkErrorData<T> extends BulkSuccessData <T> {
    public LinkedHashMap<String, ErrorData> error;
}