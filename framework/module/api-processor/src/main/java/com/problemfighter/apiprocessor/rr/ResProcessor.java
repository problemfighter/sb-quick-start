package com.problemfighter.apiprocessor.rr;

import com.hmtmcse.oc.common.InitCustomProcessor;
import com.hmtmcse.oc.common.ObjectCopierException;
import com.hmtmcse.oc.common.ProcessCustomCopy;
import com.hmtmcse.oc.copier.ObjectCopier;
import com.problemfighter.apiprocessor.exception.ErrorCode;
import com.problemfighter.apiprocessor.exception.ExceptionMessage;
import com.problemfighter.apiprocessor.rr.response.*;
import com.problemfighter.appcommon.common.SpringContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class ResProcessor {

    private ObjectCopier objectCopier;
    public static Integer itemPerPage = 15;
    public static String sortField = "id";
    public static Sort.Direction sortOrder = Sort.Direction.DESC;

    public ResProcessor() {
        this.objectCopier = new ObjectCopier();
        this.objectCopier.initCustomProcessor = new InitCustomProcessor() {
            @Override
            public <S, D> ProcessCustomCopy<S, D> init(Class<?> klass, S source, D destination) {
                return (ProcessCustomCopy<S, D>) SpringContext.getBean(klass);
            }
        };
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
                    ignore.printStackTrace();
                }
            }
        }
        return dtoList;
    }

    public <D> BulkResponse<D> bulkResponse(BulkErrorDst<D, ?> processed, Class<D> dto) {
        BulkResponse<D> bulkResponse = new BulkResponse<>();
        processed.addSuccessDataList(entityToDTO(processed.dstList, dto));
        bulkResponse.status = Status.partial;
        bulkResponse.code = ErrorCode.partial;
        if (processed.success == null || processed.success.size() == 0) {
            bulkResponse.status = Status.error;
            bulkResponse.code = ErrorCode.error;
            processed.success = null;
        } else if (processed.failed == null) {
            bulkResponse.status = Status.success;
            bulkResponse.code = ErrorCode.success;
        }
        bulkResponse.success = processed.success;
        bulkResponse.failed = processed.failed;
        return bulkResponse;
    }

    public <E, D> PageableResponse<D> pageableResponse(Page<E> page, Class<D> dto) {
        PageableResponse<D> pageableResponse = new PageableResponse<>();
        pageableResponse.data = entityToDTO(page.getContent(), dto);
        Pageable pageable = page.getPageable();
        pageableResponse.addPagination(pageable.getPageNumber(), pageable.getPageSize())
                .setTotal(page.getTotalElements())
                .setTotalPage(page.getTotalPages());
        return pageableResponse;
    }

    public PageRequest paginationNSort(Integer page, Integer size, String sort, String field) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = itemPerPage;
        }

        Sort.Direction order = sortOrder;
        if (sort != null && sort.equals("asc")) {
            order = Sort.Direction.ASC;
        }

        if (field == null || field.equals("")) {
            field = sortField;
        }
        return PageRequest.of(page, size, order, field);
    }

    public DetailsResponse<?> detailsResponse() {
        return null;
    }

}
