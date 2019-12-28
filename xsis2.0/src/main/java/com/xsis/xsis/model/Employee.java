package com.xsis.xsis.model;

import javax.persistence.*;

import com.xsis.xsis.models.common.CommonEntity;

/**
 * Employee
 */
@Entity
@Table(name = "x_employee")
public class Employee extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "is_idle")
    private Boolean isIdle;

    @Column(name = "is_ero")
    private Boolean isEro;

    @Column(name = "is_user_client")
    private Boolean isUserClient;

    @Column(name = "ero_email")
    private String eroEmail;

    public Employee(){}

    public Employee(Long id, Long biodataId, Boolean isIdle, Boolean isEro, Boolean isUserClient, String eroEmail) {
        this.id = id;
        this.biodataId = biodataId;
        this.isIdle = isIdle;
        this.isEro = isEro;
        this.isUserClient = isUserClient;
        this.eroEmail = eroEmail;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBiodataId() {
        return this.biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public Boolean isIsIdle() {
        return this.isIdle;
    }

    public Boolean getIsIdle() {
        return this.isIdle;
    }

    public void setIsIdle(Boolean isIdle) {
        this.isIdle = isIdle;
    }

    public Boolean isIsEro() {
        return this.isEro;
    }

    public Boolean getIsEro() {
        return this.isEro;
    }

    public void setIsEro(Boolean isEro) {
        this.isEro = isEro;
    }

    public Boolean isIsUserClient() {
        return this.isUserClient;
    }

    public Boolean getIsUserClient() {
        return this.isUserClient;
    }

    public void setIsUserClient(Boolean isUserClient) {
        this.isUserClient = isUserClient;
    }

    public String getEroEmail() {
        return this.eroEmail;
    }

    public void setEroEmail(String eroEmail) {
        this.eroEmail = eroEmail;
    }
}