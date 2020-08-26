package com.problemfighter.apiprocessor.rr.response;


import com.problemfighter.apiprocessor.exception.ErrorCode;

public class BaseData {
    public Status status;
    public String code;

    public void success() {
        this.code = ErrorCode.success;
        this.status = Status.success;
    }

    public void error() {
        this.code = ErrorCode.error;
        this.status = Status.error;
    }
}
