package com.hmtmcse.student.model.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course extends Base {

    public String name;
    public String code;
    public String creditHour;

    @Column(columnDefinition = "TEXT")
    public String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Student> students = new HashSet<>();

}
