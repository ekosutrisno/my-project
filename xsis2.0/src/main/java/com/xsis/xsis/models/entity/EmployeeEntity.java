package com.xsis.xsis.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xsis.xsis.models.common.CommonEntity;

/**
 * EmployeeEntity
 */
@Entity
@Table(name = EmployeeEntity.TABLE_NAME)
public class EmployeeEntity extends CommonEntity {

    public static final String TABLE_NAME = "x_employee";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    private Long biodataId;

    @Column(name = "is_idle")
    private boolean isIdle;

    @Column(name = "is_ero")
    private boolean isEro;

    @Column(name = "is_user_client")
    private boolean isUserClient;

    @Column(name = "ero_email")
    private String eroEmail;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, Long biodataId, boolean isIdle, boolean isEro, boolean isUserClient,
            String eroEmail) {
        this.id = id;
        this.biodataId = biodataId;
        this.isIdle = isIdle;
        this.isEro = isEro;
        this.isUserClient = isUserClient;
        this.eroEmail = eroEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public boolean isIdle() {
        return isIdle;
    }

    public void setIdle(boolean isIdle) {
        this.isIdle = isIdle;
    }

    public boolean isEro() {
        return isEro;
    }

    public void setEro(boolean isEro) {
        this.isEro = isEro;
    }

    public boolean isUserClient() {
        return isUserClient;
    }

    public void setUserClient(boolean isUserClient) {
        this.isUserClient = isUserClient;
    }

    public String getEroEmail() {
        return eroEmail;
    }

    public void setEroEmail(String eroEmail) {
        this.eroEmail = eroEmail;
    }

}