package com.problemfighter.apiprocessor.dto;



import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "swagger")
public class SwaggerDTO {

    @Schema(title = "Please Specify Name", example = "Mia")
    public String name;

    @Schema(title = "Please Specify Age", example = "20")
    public Integer age;


}
