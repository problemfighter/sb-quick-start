package com.hmtmcse.student.model.entity;


import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Semester extends Base {

    public String name;
    public String description;
    public Date start;
    public Date end;

}
