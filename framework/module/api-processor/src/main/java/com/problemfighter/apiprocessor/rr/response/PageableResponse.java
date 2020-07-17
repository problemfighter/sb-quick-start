package com.problemfighter.apiprocessor.rr.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "pageable", description = "status success response")
public class PageableResponse<T> extends DetailsResponse<T> {
    public PaginationData pagination;
}
