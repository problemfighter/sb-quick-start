package com.problemfighter.apiprocessor.rr.request;

import java.util.List;

public class RequestBulkData<T> {

    public List<T> data;

    public List<T> getData() {
        return this.data;
    }
}
