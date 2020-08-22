package com.hmtmcse.student.model.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Department extends Base {

    public String name;
    public String code;

    @Column(columnDefinition = "TEXT")
    public String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

}
