package com.problemfighter.apiprocessor.rr.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BulkSuccessData<T> {
    public I18nMessage message = null;
    public List<T> dataList;
}