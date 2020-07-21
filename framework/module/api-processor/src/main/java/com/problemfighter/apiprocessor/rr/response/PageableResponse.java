package com.problemfighter.apiprocessor.rr.response;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "pageable", description = "status success response")
public class PageableResponse<T> extends DetailsResponse<T> {
    public PaginationData pagination;
}
