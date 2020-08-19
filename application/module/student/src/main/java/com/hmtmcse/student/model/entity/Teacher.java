package com.hmtmcse.student.model.entity;

import javax.persistence.Entity;


@Entity
public class Teacher extends Base {

    public String firstName;
    public String lastName;
    public String teacherCode;
    public String mobile;


}
