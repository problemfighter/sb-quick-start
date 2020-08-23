package com.hmtmcse.student.model.dto.student;

import com.problemfighter.appcommon.model.DTOCommon;

import javax.validation.constraints.NotNull;

public class StudentMasterDTO extends DTOCommon {

    @NotNull(message = "Please Enter Firstname.")
    public String firstName;
    public String lastName;

    @NotNull(message = "Please Enter Student ID.")
    public String identity;


}
