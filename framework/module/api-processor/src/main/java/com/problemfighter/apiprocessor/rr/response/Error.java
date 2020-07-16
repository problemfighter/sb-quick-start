package com.problemfighter.apiprocessor.rr.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.LinkedHashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "error")
public class Error {

    public String message;
    @Schema(example = "name: Name")
    public LinkedHashMap<String, String> fields;

}
