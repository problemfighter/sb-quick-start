package com.problemfighter.apiprocessor.rr.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "pagination")
public class PaginationData {
    public Long total;
    public Long offset;
    public Long itemPerPage;
}
