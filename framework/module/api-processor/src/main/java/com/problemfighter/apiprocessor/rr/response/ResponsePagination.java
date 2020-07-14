package com.problemfighter.apiprocessor.rr.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "pagination")
public class ResponsePagination extends ResponseBasic {
    public Long total;
    public Long offset;
    public Long itemPerPage;
}
