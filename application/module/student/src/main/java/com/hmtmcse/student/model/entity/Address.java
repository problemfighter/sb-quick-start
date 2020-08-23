package com.hmtmcse.student.model.entity;

import com.problemfighter.appcommon.model.EntityCommon;

import javax.persistence.Entity;

@Entity
public class Address extends EntityCommon {
    public String details;
    public String postCode;
    public String country;
    public String stateDistrict;
    public String cityUpozila;
}
