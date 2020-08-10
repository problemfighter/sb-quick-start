package com.problemfighter.apiprocessor.common;

import com.problemfighter.apiprocessor.rr.ResProcessor;

/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class ApiProcessorException extends RuntimeException {

    public Object errorMessage;

    public ApiProcessorException() {
        super("Api Processor Exception");
    }

    public ApiProcessorException(String message) {
        super(message);
    }

    public ApiProcessorException error(Object errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public Object getError() {
        if (this.errorMessage == null) {
            return ResProcessor.unknownError();
        }
        return this.errorMessage;
    }
}
