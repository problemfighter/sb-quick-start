package com.problemfighter.apiprocessor.rr;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springdoc.demo.services.book.response.ApiResponseBasicDTO;
import org.springdoc.demo.services.book.response.ApiResponsePaginationDTO;

@Data
@Builder
@Schema(anyOf = {ApiResponseBasicDTO.class, ApiResponsePaginationDTO.class})
public class ResponseDTO<T> {
    private String status;

    @Builder.Default
    private String message = "Success!";

    private T data;
}
