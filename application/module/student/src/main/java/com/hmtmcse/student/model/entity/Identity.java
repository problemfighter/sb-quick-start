package com.hmtmcse.student.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Identity extends Base {

    public String name;

    @Column(unique = true, nullable = false)
    public String email;

    @Column(nullable = false)
    public String password;


}
