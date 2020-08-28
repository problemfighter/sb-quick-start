package com.problemfighter.apiprocessor.rr;

import com.hmtmcse.oc.common.InitCustomProcessor;
import com.hmtmcse.oc.common.ObjectCopierException;
import com.hmtmcse.oc.common.ProcessCustomCopy;
import com.hmtmcse.oc.copier.ObjectCopier;
import com.hmtmcse.oc.reflection.ReflectionProcessor;
import com.problemfighter.apiprocessor.common.ApiProcessorException;
import com.problemfighter.apiprocessor.rr.request.RequestBulkData;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.*;
import com.problemfighter.appcommon.common.SpringContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Optional;

public class ReqProcessor {

    private ObjectCopier objectCopier;
    private ReflectionProcessor reflectionProcessor;
    public static Integer itemPerPage = 15;
    public static String sortField = "id";
    public static Sort.Direction sortOrder = Sort.Direction.DESC;

    public ReqProcessor() {
        this.objectCopier = new ObjectCopier();
        this.objectCopier.initCustomProcessor = new InitCustomProcessor() {
            @Override
            public <S, D> ProcessCustomCopy<S, D> init(Class<?> klass, S source, D destination) {
                return (ProcessCustomCopy<S, D>) SpringContext.getBean(klass);
            }
        };
        this.reflectionProcessor = new ReflectionProcessor();
    }

    public <D> D copySrcToDst(Object source, D destination) {
        try {
            return this.objectCopier.copy(source, destination);
        } catch (ObjectCopierException e) {
            ApiProcessorException.otherError(e.getMessage());
        }
        return null;
    }

    public <D> D copySrcToDst(Object source, Class<D> destination) {
        try {
            return this.objectCopier.copy(source, destination);
        } catch (ObjectCopierException e) {
            ApiProcessorException.otherError(e.getMessage());
        }
        return null;
    }

    public void dataValidate(Object source) {
        LinkedHashMap<String, String> errors = this.objectCopier.validateObject(source);
        if (errors.size() != 0) {
            ApiProcessorException.throwException(ResProcessor.validationError().reason(errors));
        }
    }

    public void dataValidate(RequestData<?> requestData) {
        dataValidate(requestData.getData());
    }

    public <D> D copySrcToDstValidate(Object source, Class<D> destination) {
        dataValidate(source);
        return copySrcToDst(source, destination);
    }

    public <D> D copySrcToDstValidate(Object source, D destination) {
        dataValidate(source);
        return copySrcToDst(source, destination);
    }

    // Quick Access
    public static ReqProcessor instance() {
        return new ReqProcessor();
    }

    public <D> D copyOnly(Object source, Class<D> destination) throws ApiProcessorException {
        return copySrcToDst(source, destination);
    }

    public <D> D copyOnly(Object source, D destination) throws ApiProcessorException {
        return copySrcToDst(source, destination);
    }

    public <D> D process(Object source, Class<D> destination) {
        return copySrcToDstValidate(source, destination);
    }

    public <D> D process(Object source, D destination) {
        return copySrcToDstValidate(source, destination);
    }

    public <D> D process(RequestData<?> requestData, D destination) {
        return copySrcToDstValidate(requestData.getData(), destination);
    }

    public <D> D process(RequestData<?> requestData, Class<D> destination) {
        return copySrcToDstValidate(requestData.getData(), destination);
    }


    public <D, E> BulkErrorDst<D, E> bulkProcess(RequestBulkData<D> requestData, Class<E> destination) {
        BulkErrorDst<D, E> errorDst = new BulkErrorDst<>();
        for (D object : requestData.getData()) {
            try {
                errorDst.addToList(copySrcToDstValidate(object, destination));
            } catch (ApiProcessorException e) {
                MessageResponse messageResponse = (MessageResponse) e.getError();
                errorDst.addFailed(new BulkErrorData<D>().addError(messageResponse.error).addObject(object));
            }
        }
        return errorDst;
    }

    public <O> Long validateId(Long id, String message) {
        if (id == null && message != null) {
            ApiProcessorException.error(message);
        }
        return id;
    }

    public <O> Long getId(RequestData<O> data) {
        return getIdFieldValue(data.getData());
    }

    public <O> Long validateNGetId(RequestData<O> data, String message) {
        Long id = getIdFieldValue(data.getData());
        return validateId(id, message);
    }

    public <E> E validateNOp2Entity(Optional<E> optional, String message) {
        if (optional.isEmpty() && message != null) {
            ApiProcessorException.error(message);
        }
        return optional.get();
    }

    public <O> Long getIdFieldValue(O object) {
        return getFieldValue(object, "id", Long.class);
    }

    private <T, O> T getFieldValue(O object, String name, Class<T> type) {
        try {
            Field field = reflectionProcessor.getFieldFromObject(object, name);
            if (field == null || field.getType() != type) {
                return null;
            }
            return (T) field.get(object);
        } catch (IllegalAccessException ignore) {
            return null;
        }
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

}
