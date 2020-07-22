package com.problemfighter.apiprocessor.rr.response;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "pageable", description = "status success response")
public class PageableResponse<T> extends ErrorAndBaseData {
    public List<T> data;
    public PaginationData pagination;
}
