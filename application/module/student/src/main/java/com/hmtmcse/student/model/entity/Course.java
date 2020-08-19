package com.hmtmcse.student.model.entity;


import javax.persistence.Entity;

@Entity
public class Course extends Base {

    public String name;
    public String code;
    public String creditHour;
    public String description;

}
