package com.problemfighter.apiprocessor.rr.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BulkErrorDst<D, E> extends BulkResponse<D> {
    public List<E> dstList = new ArrayList<>();

    public BulkErrorDst<D, E> addToList(E item) {
        dstList.add(item);
        return this;
    }

}
