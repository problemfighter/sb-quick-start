package com.problemfighter.apiprocessor.rr;

import com.problemfighter.apiprocessor.rr.response.*;

public class ResProcessor {


    public static ResProcessor instance() {
        return new ResProcessor();
    }

    public MessageResponse responseMessage(String message, String errorCode) {
        return responseMessage(message, errorCode, null);
    }

    public MessageResponse responseMessage(String message, String errorCode, ErrorData error) {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.message = message;
        messageResponse.code = errorCode;
        messageResponse.error = error;
        return messageResponse;
    }

    public MessageResponse errorMessageResponse(String message, String errorCode) {
        return responseMessage(null, errorCode).errorMessage(message);
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
