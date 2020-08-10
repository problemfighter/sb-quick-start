package com.problemfighter.controller;

import com.problemfighter.apiprocessor.common.ApiProcessorException;
import com.problemfighter.apiprocessor.exception.HttpToApiException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class SBQuickStartExceptionController implements ErrorController {

    @ExceptionHandler(Exception.class)
    public Object handleException(HttpServletRequest request, Exception exception) {
        return "Exception";
    }

    @ExceptionHandler(value = ApiProcessorException.class)
    public Object apiProcessorException(ApiProcessorException exception) {
        return exception.getError();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Object noHandlerFoundException(HttpServletRequest request, Exception e) {
        return "NoHandlerFoundException";
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
