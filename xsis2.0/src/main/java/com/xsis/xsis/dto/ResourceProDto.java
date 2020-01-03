package com.xsis.xsis.dto.vacancy_pendidikan_resourceproject;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ResourceProDto
 */
public class ResourceProDto {

    private Long id;
    private Boolean isDelete;
    private Long clientId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Temporal(TemporalType.DATE)
    private Date startProject;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Temporal(TemporalType.DATE)
    private Date endProject;

    private String department;
    private String picName;
    private String name;
    private String userClientName;
    private Long ero;
    private Boolean isEro;

    public ResourceProDto() {
    }

    public ResourceProDto(Long id, Boolean isDelete, Long clientId, Date startProject, Date endProject,
            String department, String picName, String name, String userClientName, Long ero, Boolean isEro) {
        this.id = id;
        this.isDelete = isDelete;
        this.clientId = clientId;
        this.startProject = startProject;
        this.endProject = endProject;
        this.department = department;
        this.picName = picName;
        this.name = name;
        this.userClientName = userClientName;
        this.ero = ero;
        this.isEro = isEro;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isIsDelete() {
        return this.isDelete;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getStartProject() {
        return this.startProject;
    }

    public void setStartProject(Date startProject) {
        this.startProject = startProject;
    }

    public Date getEndProject() {
        return this.endProject;
    }

    public void setEndProject(Date endProject) {
        this.endProject = endProject;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPicName() {
        return this.picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserClientName() {
        return this.userClientName;
    }

    public void setUserClientName(String userClientName) {
        this.userClientName = userClientName;
    }

    public Long getEro() {
        return this.ero;
    }

    public void setEro(Long ero) {
        this.ero = ero;
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

}