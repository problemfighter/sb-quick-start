package com.hmtmcse.student.model.dto.department;

import com.problemfighter.appcommon.model.DTOCommon;

import javax.validation.constraints.NotNull;


public class DepartmentMasterDTO extends DTOCommon {

    @NotNull(message = "Please enter department name")
    public String name;

    @NotNull(message = "Please enter department code")
    public String code;
    public String description;
}
