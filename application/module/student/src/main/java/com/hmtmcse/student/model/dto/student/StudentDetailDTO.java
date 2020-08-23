package com.hmtmcse.student.model.dto.student;

import javax.validation.constraints.NotNull;

public class StudentDetailDTO extends StudentMasterDTO {


    @NotNull(message = "Please Enter Email.")
    public String mobile;

    public String address;
    public String identityUuid;

}
