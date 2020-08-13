package com.problemfighter.apiprocessor.exception;

import com.problemfighter.apiprocessor.rr.ResProcessor;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;

public class ExceptionProcessor {

    public static ExceptionProcessor instance() {
        return new ExceptionProcessor();
    }

    public MessageResponse handleException(Exception exception) {

        return ResProcessor.errorMessage(exception.getMessage());
    }
}
