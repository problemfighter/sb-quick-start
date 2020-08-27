package com.problemfighter.apiprocessor.common;

import com.hmtmcse.oc.reflection.ReflectionProcessor;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class DataUtil {

    private ReflectionProcessor reflectionProcessor;

    public DataUtil() {
        reflectionProcessor = new ReflectionProcessor();
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
