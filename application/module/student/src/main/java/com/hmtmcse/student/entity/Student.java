package com.hmtmcse.student.entity;


import javax.persistence.*;

@Entity
public class Student {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String firstName;
    public String lastName;

    @Column(nullable = false, unique = true)
    public String identity;
    public String mobile;
    public String address;
    public String identityUuid;

}
