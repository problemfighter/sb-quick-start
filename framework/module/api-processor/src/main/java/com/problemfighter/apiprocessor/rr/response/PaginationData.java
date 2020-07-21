package com.problemfighter.apiprocessor.rr.response;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "pagination")
public class PaginationData {
    public Long total;
    public Long offset;
    public Long itemPerPage;
}
