package com.problemfighter.apiprocessor.rr;

import com.hmtmcse.oc.common.ObjectCopierException;
import com.hmtmcse.oc.copier.ObjectCopier;
import com.problemfighter.apiprocessor.exception.ErrorCode;
import com.problemfighter.apiprocessor.exception.ExceptionMessage;
import com.problemfighter.apiprocessor.rr.response.*;

import java.util.ArrayList;
import java.util.List;

public class ResProcessor {

    private ObjectCopier objectCopier;

    public ResProcessor() {
        this.objectCopier = new ObjectCopier();
    }

    public static ResProcessor instance() {
        return new ResProcessor();
    }

    public MessageResponse responseMessage(String message, String errorCode) {
        return responseMessage(message, errorCode, null).status(Status.success);
    }

    public MessageResponse responseMessage(String message, String errorCode, ErrorData error) {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.message = I18nMessage.message(message);
        messageResponse.code = errorCode;
        messageResponse.error = error;
        return messageResponse;
    }

    public MessageResponse errorMessageResponse(String message, String errorCode) {
        return responseMessage(null, errorCode).errorMessage(message).status(Status.error);
    }

    public MessageResponse successMessage(String message) {
        return instance().responseMessage(message, ErrorCode.success);
    }

    // Quick Access
    public static MessageResponse messageResponse(String message, String errorCode) {
        return instance().responseMessage(message, errorCode);
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

    public static MessageResponse validationError() {
        return errorMessage(ExceptionMessage.validationError, ErrorCode.validationError);
    }

    public static MessageResponse otherError(String message) {
        return errorMessage(message, ErrorCode.otherError);
    }

    public static MessageResponse errorMessage(String message, String errorCode) {
        return instance().errorMessageResponse(message, errorCode);
    }

    public <E, D> D entityToDTO(E entity, Class<D> dto) throws ObjectCopierException {
        return objectCopier.copy(entity, dto);
    }

    public <E, D> List<D> entityToDTO(List<E> entities, Class<D> dto) {
        List<D> dtoList = new ArrayList<>();
        if (entities != null) {
            for (E entity : entities) {
                try {
                    D dtoObject = objectCopier.copy(entity, dto);
                    if (dtoObject != null) {
                        dtoList.add(dtoObject);
                    }
                } catch (ObjectCopierException ignore) {
                }
            }
        }
        return dtoList;
    }

    public <D> BulkResponse<D> bulkResponse(BulkErrorDst<D, ?> processed, Class<D> dto) {
        BulkResponse<D> bulkResponse = new BulkResponse<>();
        processed.addSuccessDataList(entityToDTO(processed.dstList, dto));
        bulkResponse.status = Status.partial;
        if (processed.success == null  || processed.success.size() == 0) {
            bulkResponse.status = Status.error;
        } else if (processed.failed == null) {
            bulkResponse.status = Status.success;
        }
        bulkResponse.success = processed.success;
        bulkResponse.failed = processed.failed;
        return bulkResponse;
    }

    public static PageableResponse<?> pageableResponse() {
        return null;
    }

    public static DetailsResponse<?> detailsResponse() {
        return null;
    }

}
