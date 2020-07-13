package com.hmtmcse.student.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
public class SwaggerDTO {

    @ApiModelProperty(notes = "Please Specify Name", example = "Mia")
    public String name;

    @ApiModelProperty(notes = "Please Specify Age", example = "20")
    public Integer age;


}
