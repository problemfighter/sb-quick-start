package com.problemfighter.apiprocessor.exception;

import com.problemfighter.apiprocessor.rr.ResProcessor;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import com.problemfighter.appcommon.common.SpringContext;
import org.hibernate.HibernateException;
import org.springframework.core.env.Environment;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

public class ExceptionProcessor {

    private Environment environment;

    public ExceptionProcessor() {
        environment = SpringContext.environment();
    }

    public static ExceptionProcessor instance() {
        return new ExceptionProcessor();
    }

    public String eng() {
        if (environment != null) {
            return environment.getActiveProfiles()[0];
        }
        return null;
    }

    public String handleHibernateException(Throwable throwable) {
        if (throwable.getCause() != null) {
            return throwable.getCause().getMessage();
        }
        return throwable.getMessage();
    }

    private String exceptionMessageGenerator(Exception exception, String message) {
        if (exception instanceof MethodArgumentTypeMismatchException) {
            return ExceptionMessage.invalidRequestParams;
        } else if (exception.getCause() instanceof HibernateException) {
            message = handleHibernateException(exception.getCause());
        }
        return message;
    }

    public MessageResponse handleException(Exception exception) {
        String message = exception.getMessage();
        String code = ErrorCode.unknownError;
        message = exceptionMessageGenerator(exception, message);
        if (eng() != null && eng().equals("local")) {
            exception.printStackTrace();
        }
        MessageResponse messageResponse = ResProcessor.errorMessage(message).setCode(code);
        messageResponse.updateErrorMessageKey(null);
        return messageResponse;
    }
}
