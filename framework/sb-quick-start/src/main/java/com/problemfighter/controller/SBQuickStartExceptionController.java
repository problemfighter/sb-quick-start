package com.problemfighter.controller;

import com.problemfighter.apiprocessor.common.ApiProcessorException;
import com.problemfighter.apiprocessor.exception.ExceptionProcessor;
import com.problemfighter.apiprocessor.exception.HttpToApiException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class SBQuickStartExceptionController implements ErrorController {

    @ExceptionHandler(Exception.class)
    public Object handleException(HttpServletRequest request, Exception exception) {
        return ExceptionProcessor.instance().handleException(exception);
    }

    @ExceptionHandler(value = ApiProcessorException.class)
    public Object apiProcessorException(ApiProcessorException exception) {
        return exception.getError();
    }


    @RequestMapping(value = "/error")
    public Object error(HttpServletRequest request, Exception e) {
        return HttpToApiException.handleException(request);
    }

    @Override
    public String getErrorPath() {
        return null;
    }


}
