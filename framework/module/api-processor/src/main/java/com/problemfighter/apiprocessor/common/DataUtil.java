package com.problemfighter.apiprocessor.common;

import com.hmtmcse.oc.reflection.ReflectionProcessor;
import com.problemfighter.apiprocessor.rr.ReqProcessor;
import com.problemfighter.apiprocessor.rr.request.RequestBulkData;
import com.problemfighter.apiprocessor.rr.response.*;

import java.lang.reflect.Field;
import java.util.*;

public class DataUtil {

    private ReflectionProcessor reflectionProcessor;
    private ReqProcessor reqProcessor;

    public DataUtil() {
        reflectionProcessor = new ReflectionProcessor();
        reqProcessor = new ReqProcessor();
    }

    public <D> List<Long> getAllId(RequestBulkData<D> data){
        return getAllId(data.getData());
    }

    public <D> List<Long> getAllId(List<D> list) {
        return getFieldValues(list, "id", Long.class);
    }

    public <D, L> List<L> getFieldValues(List<D> list, String name, Class<L> klass) {
        List<L> response = new ArrayList<>();
        Field field;
        for (D data : list) {
            try {
                field = reflectionProcessor.getAnyFieldFromObject(data, name);
                if (field != null && field.getType() == klass) {
                    field.setAccessible(true);
                    response.add((L) field.get(data));
                }
            } catch (IllegalAccessException ignore) {

            }
        }
        return response;
    }

    public <D> List<D> markAsDeleted(List<D> dataList) {
        for (D data: dataList){
            markAsDeleted(data);
        }
        return dataList;
    }

    public <D> Iterable<D> markAsDeleted(Iterable<D> dataList) {
        for (D data : dataList) {
            markAsDeleted(data);
        }
        return dataList;
    }

    public <D> D getObjectFromList(List<D> dataList, String fieldName, Object dataObject) {
        Field listField, dataField;
        for (D data : dataList) {
            try {
                listField = reflectionProcessor.getAnyFieldFromObject(data, fieldName);
                dataField = reflectionProcessor.getAnyFieldFromObject(dataObject, fieldName);
                if (listField != null && dataField != null && listField.getType() == dataField.getType()) {
                    listField.setAccessible(true);
                    dataField.setAccessible(true);
                    if (listField.get(data).equals(dataField.get(dataObject))) {
                        return data;
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public <E, D> BulkErrorValidEntities<D, E> merge(Iterable<E> mergeTo, RequestBulkData<D> data) {
        BulkErrorValidEntities<D, E> bulkErrorValidEntities = new BulkErrorValidEntities<>();
        List<D> sourceList = data.getData();
        D source;
        for (E entity : mergeTo) {
            source = getObjectFromList(sourceList, "id", entity);
            if (source != null) {
                try {
                    bulkErrorValidEntities.addToList(reqProcessor.copySrcToDstValidate(source, entity));
                } catch (ApiProcessorException e) {
                    MessageResponse messageResponse = (MessageResponse) e.getError();
                    bulkErrorValidEntities.addFailed(new BulkErrorData<D>().addError(messageResponse.error).addObject(source));
                }
                sourceList.remove(source);
            }
        }
        ErrorData error = new ErrorData();
        error.message = I18nMessage.message("Unable to process update");
        for (D errorSource : sourceList) {
            bulkErrorValidEntities.addFailed(new BulkErrorData<D>().addError(error).addObject(errorSource));
        }
        return bulkErrorValidEntities;
    }


    public <D> D markAsDeleted(D data) {
        return updateProperty(data, Map.of("isDeleted", true));
    }

    public <D> List<D> updateProperty(List<D> dataList, Map<String, Object> fieldValue) {
        for (D data : dataList) {
            updateProperty(data, fieldValue);
        }
        return dataList;
    }

    public <D> D updateProperty(D data, Map<String, Object> fieldValue) {
        Field field;
        for (Map.Entry<String, Object> entry : fieldValue.entrySet()) {
            try {
                field = reflectionProcessor.getAnyFieldFromObject(data, entry.getKey());
                if (field != null) {
                    field.setAccessible(true);
                    field.set(data, entry.getValue());
                }
            } catch (IllegalAccessException ignore) {
            }
        }
        return data;
    }

    public static DataUtil instance() {
        return new DataUtil();
    }
}
