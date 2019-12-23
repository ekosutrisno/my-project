package com.xsis.xsis.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xsis.xsis.models.common.CommonEntity;

/**
 * ScheduleTypeEntity
 */
@Entity
@Table(name = ScheduleTypeEntity.TABLE_NAME)
public class ScheduleTypeEntity extends CommonEntity {

    public static final String TABLE_NAME = "x_schedule_type";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    public ScheduleTypeEntity() {
    }

    public ScheduleTypeEntity(Date createdOn, Long createdBy, Date modifiedOn, Long modifiedBy, Date deleteddOn,
            Long deletedBy, Boolean isDelete, Long id, String name, String description) {
        super(createdOn, createdBy, modifiedOn, modifiedBy, deleteddOn, deletedBy, isDelete);
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}