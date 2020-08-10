package com.problemfighter.apiprocessor.rr;

import com.hmtmcse.oc.common.ObjectCopierException;
import com.hmtmcse.oc.copier.ObjectCopier;
import com.problemfighter.apiprocessor.common.ApiProcessorException;

import java.util.LinkedHashMap;

public class ReqProcessor extends ObjectCopier {


    public <D> D copySrcToDst(Object source, Class<D> destination) {
        try {
            return copy(source, destination);
        } catch (ObjectCopierException e) {
            throw new ApiProcessorException(e.getMessage());
        }
    }

    public <D> D copySrcToDstValidate(Object source, Class<D> destination) {
        try {
            LinkedHashMap<String, String> errors = validateObject(source);
            if (errors.size() != 0) {

            }
            D data = copySrcToDst(source, destination);

            return data;
        } catch (ApiProcessorException e) {
            throw new ApiProcessorException(e.getMessage());
        }
    }

    // Quick Access
    public static ReqProcessor instance() {
        return new ReqProcessor();
    }

    public static <D> D copyOnly(Object source, Class<D> destination) throws ApiProcessorException {
        return instance().copySrcToDst(source, destination);
    }

    public static <D> D process(Object source, Class<D> destination) {
        return instance().copySrcToDstValidate(source, destination);
    }


}
