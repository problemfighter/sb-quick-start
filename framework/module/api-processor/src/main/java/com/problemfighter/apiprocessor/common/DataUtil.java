package com.problemfighter.apiprocessor.common;

import com.hmtmcse.oc.reflection.ReflectionProcessor;
import com.problemfighter.apiprocessor.rr.request.RequestBulkData;

import java.lang.reflect.Field;
import java.util.*;

public class DataUtil {

    private ReflectionProcessor reflectionProcessor;

    public DataUtil() {
        reflectionProcessor = new ReflectionProcessor();
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

    public <D> D getObjectFromList(List<D> dataList, String fieldName, Object dataObject){
        Field listField, dataField;
        for (D data: dataList ){
            try{
                listField = reflectionProcessor.getAnyFieldFromObject(data, fieldName);
                dataField = reflectionProcessor.getAnyFieldFromObject(dataObject, fieldName);
                if (listField != null && dataField != null && listField.getType() == dataField.getType() && listField.get(data).equals(dataField.get(dataObject))){
                    return (D) listField.get(data);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public <E, D> Iterable<E> merge(Iterable<E> mergeTo, List<D> dataFrom, String compareField) {
        for (E data : mergeTo) {

        }
        return mergeTo;
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
