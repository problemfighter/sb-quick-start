package com.hmtmcse.student.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    public Long id;

    public String firstName;
    public String lastName;
    public String identity;
    public String mobile;
    public String address;
    public String identityUuid;

}
