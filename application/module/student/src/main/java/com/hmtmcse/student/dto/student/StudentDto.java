package com.hmtmcse.student.dto.student;

import javax.validation.constraints.NotNull;

public class StudentDto {

    @NotNull(message = "Please Enter Firstname.")
    public String firstName;


    public String lastName;

    @NotNull(message = "Please Enter Student ID.")
    public String identity;

    public String mobile;
    public String address;
    public String identityUuid;

}
