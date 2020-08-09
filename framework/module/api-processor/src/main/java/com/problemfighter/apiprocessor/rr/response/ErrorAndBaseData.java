package com.problemfighter.apiprocessor.rr.response;


import java.util.LinkedHashMap;

public class ErrorAndBaseData extends BaseData {
    public ErrorData error;

    public void initErrorData() {
        if (error == null) {
            error = new ErrorData();
        }
    }

    public void addErrorMessage(String message) {
        initErrorData();
        error.message = message;
    }

    public void addErrorReason(String key, String explanation) {
        initErrorData();
        if (error.details == null) {
            error.details = new LinkedHashMap<>();
        }
        error.details.put(key, explanation);
    }
}
