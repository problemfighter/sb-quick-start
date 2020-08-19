package com.hmtmcse.student.model.entity;

import javax.persistence.Entity;


@Entity
public class Student extends Base {

    public String firstName;
    public String lastName;
    public String identity;
    public String mobile;


}
