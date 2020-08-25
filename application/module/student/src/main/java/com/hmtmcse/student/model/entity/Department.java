package com.hmtmcse.student.model.entity;


import com.problemfighter.appcommon.model.EntityCommon;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Department extends EntityCommon {

    @Column(nullable = false)
    public String name;

    @Column(unique = true)
    public String code;

    @Column(columnDefinition = "TEXT")
    public String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

}
