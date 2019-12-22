package com.xsis.xsis.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.xsis.xsis.models.common.CommonEntity;

/**
 * MaritalStatusEntity
 */
@Entity
@Table(name = MaritalStatusEntity.TABLE_NAME)
public class MaritalStatusEntity extends CommonEntity {
    public static final String TABLE_NAME = "x_marital_status";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(max = 50)
    private String name;

    @Column(name = "description")
    @Size(max = 100)
    private String description;

    public MaritalStatusEntity() {
    }

    public MaritalStatusEntity(Long id, @Size(max = 50) String name, @Size(max = 100) String description) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}