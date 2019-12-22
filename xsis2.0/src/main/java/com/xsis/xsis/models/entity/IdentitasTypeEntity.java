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
 * IdentitasTypeEntity
 */
@Entity
@Table(name = IdentitasTypeEntity.TABLE_NAME)
public class IdentitasTypeEntity extends CommonEntity {
    public static final String TABLE_NAME = "x_identity_type";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @Size(max = 50)
    private String name;

    @Column(name = "description")
    @Size(max = 50)
    private String description;

    public IdentitasTypeEntity() {
    }

    public IdentitasTypeEntity(Long id, @Size(max = 50) String name, @Size(max = 50) String description) {
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