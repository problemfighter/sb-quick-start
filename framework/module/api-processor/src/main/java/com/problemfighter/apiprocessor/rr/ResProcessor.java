package com.problemfighter.apiprocessor.rr;

import com.hmtmcse.oc.copier.ObjectCopier;
import com.problemfighter.apiprocessor.exception.ExceptionMessage;
import com.problemfighter.apiprocessor.rr.response.*;

public class ResProcessor extends ObjectCopier {

    public static String UNKNOWN_ERROR = "Unknown Error Occur!";

    public static ResProcessor instance() {
        return new ResProcessor();
    }

    public MessageResponse responseMessage(String message, String errorCode) {
        return responseMessage(message, errorCode, null).status(Status.success);
    }

    public MessageResponse responseMessage(String message, String errorCode, ErrorData error) {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.message = message;
        messageResponse.code = errorCode;
        messageResponse.error = error;
        return messageResponse;
    }

    public MessageResponse errorMessageResponse(String message, String errorCode) {
        return responseMessage(null, errorCode).errorMessage(message).status(Status.error);
    }


    // Quick Access
    public static MessageResponse messageResponse(String message, String errorCode) {
        return instance().responseMessage(message, errorCode);
    }

    public static MessageResponse successMessage(String message) {
        return instance().responseMessage(message, ErrorCode.success);
    }

    public static MessageResponse errorMessage(String message) {
        return instance().errorMessageResponse(message, ErrorCode.error);
    }


    public static MessageResponse unknownError() {
        return instance().errorMessageResponse(ExceptionMessage.unknownError, ErrorCode.unknownError);
    }


    public static MessageResponse notFound() {
        return errorMessage(ExceptionMessage.notFound).setCode(ErrorCode.notFound);
    }

    public static MessageResponse badRequest() {
        return errorMessage(ExceptionMessage.badRequest).setCode(ErrorCode.badRequest);
    }

    public static MessageResponse unauthorized() {
        return errorMessage(ExceptionMessage.unauthorized).setCode(ErrorCode.unauthorized);
    }

    public static MessageResponse forbidden() {
        return errorMessage(ExceptionMessage.forbidden).setCode(ErrorCode.forbidden);
    }

    public static MessageResponse codeError() {
        return errorMessage(ExceptionMessage.codeError).setCode(ErrorCode.codeError);
    }


    public static MessageResponse errorMessage(String message, String errorCode) {
        return instance().errorMessageResponse(message, errorCode);
    }

    public static PageableResponse<?> pageableResponse() {
        return null;
    }

    public static DetailsResponse<?> detailsResponse() {
        return null;
    }

}
