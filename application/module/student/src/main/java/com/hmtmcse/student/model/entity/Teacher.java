package com.hmtmcse.student.model.entity;

import com.problemfighter.appcommon.model.EntityCommon;

import javax.persistence.Entity;


@Entity
public class Teacher extends EntityCommon {

    public String firstName;
    public String lastName;
    public String teacherCode;
    public String mobile;


}
