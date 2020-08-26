package com.problemfighter.apiprocessor.rr.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "pageable", description = "status success response")
public class PageableResponse<T> extends ErrorAndBaseData {
    public List<T> data;
    public PaginationData pagination;

    public PaginationData addPagination(Integer page, Integer itemPerPage){
        if (pagination == null){
            pagination = new PaginationData();
        }
        pagination.page = page;
        pagination.itemPerPage = itemPerPage;
        return pagination;
    }
}
