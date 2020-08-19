package com.hmtmcse.student.model.entity;

import com.problemfighter.appcommon.AppCommonUtil;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column(unique = true)
    private String uuid;

    private Boolean isDeleted = false;

    @OneToOne(fetch = FetchType.LAZY)
    @CreatedBy
    private Identity createdBy;

    @OneToOne(fetch = FetchType.LAZY)
    @LastModifiedBy
    public Identity updatedBy;


    @PrePersist
    private void onBasePersist() {
        this.created = new Date();
        this.lastUpdated = new Date();
        if (this.uuid == null || this.uuid.isEmpty()){
            this.uuid = AppCommonUtil.uuid();
        }
    }

    @PreUpdate
    private void onBaseUpdate() {
        this.lastUpdated = new Date();
    }
}
