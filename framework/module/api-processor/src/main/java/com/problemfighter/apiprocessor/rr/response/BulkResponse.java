package com.problemfighter.apiprocessor.rr.response;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BulkResponse<D> extends BaseData {
    public BulkSuccessData<D> success = null;
    public BulkErrorData<D> failed = null;
}
