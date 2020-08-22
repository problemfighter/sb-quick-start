package com.hmtmcse.student.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Semester extends Base {

    public String name;

    @Column(columnDefinition = "TEXT")
    public String description;
    public Date start;
    public Date end;

    @OneToMany(mappedBy = "semester", fetch = FetchType.LAZY)
    public Set<Registration> registrations = new HashSet<>();

}
