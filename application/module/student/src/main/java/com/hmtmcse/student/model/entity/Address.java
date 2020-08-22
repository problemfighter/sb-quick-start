package com.hmtmcse.student.model.entity;

import javax.persistence.Entity;

@Entity
public class Address extends Base {
    public String details;
    public String postCode;
    public String country;
    public String stateDistrict;
    public String cityUpozila;
}
