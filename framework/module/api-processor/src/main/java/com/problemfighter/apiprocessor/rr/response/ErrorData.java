package com.problemfighter.apiprocessor.rr.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.LinkedHashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "error", description = "status error response")
public class ErrorData {

    public String message;
    @Schema(example = "key: explanation", description = "")
    public LinkedHashMap<String, String> details;

}
