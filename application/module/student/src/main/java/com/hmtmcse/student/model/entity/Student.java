package com.hmtmcse.student.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Student extends Base {

    public String firstName;
    public String lastName;
    public String identity;
    public String mobile;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    public Address address;

    @ManyToOne
    @JoinColumn(name = "department_id")
    public Department department;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    public Set<Registration> registrations = new HashSet<>();


}
