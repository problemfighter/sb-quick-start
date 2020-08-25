package com.hmtmcse.student.model.dto.department;

import com.problemfighter.appcommon.model.DTOCommon;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotNull;


@ApiModel(description = "Department Master DTO")
public class DepartmentMasterDTO extends DTOCommon {

    @NotNull(message = "Please enter department name")
    public String name;

    @NotNull(message = "Please enter department code")
    public String code;
    public String description;
}
