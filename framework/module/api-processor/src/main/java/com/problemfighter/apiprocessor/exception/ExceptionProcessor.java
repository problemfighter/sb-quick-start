package com.problemfighter.apiprocessor.exception;

import com.problemfighter.apiprocessor.rr.ResProcessor;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import org.hibernate.HibernateException;

public class ExceptionProcessor {

    public static ExceptionProcessor instance() {
        return new ExceptionProcessor();
    }

    public MessageResponse handleException(Exception exception) {
        String message = exception.getMessage();
        String code = ErrorCode.unknownError;
        if (exception.getCause() instanceof HibernateException) {
            message = exception.getCause().getMessage();
        }
        MessageResponse messageResponse = ResProcessor.errorMessage(message).setCode(code);
        messageResponse.updateErrorMessageKey(null);
        return messageResponse;
    }
}
