package com.xsis.xsis.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.dto.ResourceProDto;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "resourceProjectMapping", classes = {
        @ConstructorResult(targetClass = ResourceProDto.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "isdelete", type = Boolean.class),
                @ColumnResult(name = "client_id", type = Long.class),
                @ColumnResult(name = "start_project", type = Date.class),
                @ColumnResult(name = "end_project", type = Date.class),
                @ColumnResult(name = "department", type = String.class),
                @ColumnResult(name = "pic_name", type = String.class),
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "user_client_name", type = String.class),
                @ColumnResult(name = "ero", type = Long.class),
                @ColumnResult(name = "is_ero", type = Boolean.class) }) })

// List Resource Project Join Client Join Employee
@NamedNativeQuery(name = "ResourceProject.getResourceProjectClientEmployee", query = "select a.id,a.isdelete,a.client_id,a.start_project,a.end_project,a.department,a.pic_name,"
        + "b.name,b.user_client_name,b.ero,c.is_ero from x_resource_project a "
        + "join x_client b on b.id=a.client_id join x_employee c on c.id=b.ero "
        + "where a.isdelete=false and b.isdelete=false and c.isdelete=false", resultSetMapping = "resourceProjectMapping")

// Page & Sorting Resource Project Join Client Join Employee
@NamedNativeQuery(name = "ResourceProject.getResourceProjectClientEmployeePandS", query = "select a.id,a.isdelete,a.client_id,a.start_project,a.end_project,a.department,a.pic_name,"
        + "b.name,b.user_client_name,b.ero,c.is_ero from x_resource_project a "
        + "join x_client b on b.id=a.client_id join x_employee c on c.id=b.ero "
        + "where (a.isdelete=false and b.isdelete=false and c.isdelete=false)", resultSetMapping = "resourceProjectMapping")

// List Resource Project Join Client Join Employee Ascending
@NamedNativeQuery(name = "ResourceProject.getResourceProjectClientEmployeeAscending", query = "select a.id,a.isdelete,a.client_id,a.start_project,a.end_project,a.department,a.pic_name,"
        + "b.name,b.user_client_name,b.ero,c.is_ero from x_resource_project a "
        + "join x_client b on b.id=a.client_id join x_employee c on c.id=b.ero "
        + "where a.isdelete=false and b.isdelete=false and c.isdelete=false order by b.name asc", resultSetMapping = "resourceProjectMapping")

// List Resource Project Join Client Join Employee Descending
@NamedNativeQuery(name = "ResourceProject.getResourceProjectClientEmployeeDescending", query = "select a.id,a.isdelete,a.client_id,a.start_project,a.end_project,a.department,a.pic_name,"
        + "b.name,b.user_client_name,b.ero,c.is_ero from x_resource_project a "
        + "join x_client b on b.id=a.client_id join x_employee c on c.id=b.ero "
        + "where a.isdelete=false and b.isdelete=false and c.isdelete=false order by b.name desc", resultSetMapping = "resourceProjectMapping")

// Search Date Resource Project Join Client Join Employee
@NamedNativeQuery(name = "ResourceProject.searchDateResourceProject", query = "select a.id,a.isdelete,a.client_id,a.start_project,a.end_project,a.department,a.pic_name,"
        + "b.name,b.user_client_name,b.ero,c.is_ero from x_resource_project a "
        + "join x_client b on b.id=a.client_id join x_employee c on c.id=b.ero "
        + "where (a.isdelete=false and b.isdelete=false and c.isdelete=false) and "
        + "(CAST(a.start_project as varchar) BETWEEN :sp AND :ep) OR (CAST(a.end_project as varchar) BETWEEN :sp AND :ep) order by b.name asc", resultSetMapping = "resourceProjectMapping")

// Search Name Client Resource Project Join Client Join Employee
@NamedNativeQuery(name = "ResourceProject.searchNameClientResourceProject", query = "select a.id,a.isdelete,a.client_id,a.start_project,a.end_project,a.department,a.pic_name,"
        + "b.name,b.user_client_name,b.ero,c.is_ero from x_resource_project a "
        + "join x_client b on b.id=a.client_id join x_employee c on c.id=b.ero "
        + "where (a.isdelete=false and b.isdelete=false and c.isdelete=false) and "
        + "(LOWER(b.name) like LOWER(concat('%',:name_client,'%'))) ", resultSetMapping = "resourceProjectMapping")

/**
 * ResourceProject
 */
@Entity
@Table(name = "x_resource_project")
public class ResourceProject extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "location")
    private String location;

    @Column(name = "department")
    private String department;

    @Column(name = "pic_name")
    private String picName;

    @Column(name = "project_name")
    private String projectName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "start_project")
    private Date startProject;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "end_project")
    private Date endProject;

    @Column(name = "project_role")
    private String projectRole;

    @Column(name = "project_phase")
    private String projectPhase;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_technology")
    private String projectTechnology;

    @Column(name = "main_task")
    private String mainTask;

    public ResourceProject() {
    }

    public ResourceProject(Long id, Long clientId, String location, String department, String picName,
            String projectName, Date startProject, Date endProject, String projectRole, String projectPhase,
            String projectDescription, String projectTechnology, String mainTask) {
        this.id = id;
        this.clientId = clientId;
        this.location = location;
        this.department = department;
        this.picName = picName;
        this.projectName = projectName;
        this.startProject = startProject;
        this.endProject = endProject;
        this.projectRole = projectRole;
        this.projectPhase = projectPhase;
        this.projectDescription = projectDescription;
        this.projectTechnology = projectTechnology;
        this.mainTask = mainTask;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public String getProjectRole() {
        return this.projectRole;
    }

    public void setProjectRole(String projectRole) {
        this.projectRole = projectRole;
    }

    public String getProjectPhase() {
        return this.projectPhase;
    }

    public void setProjectPhase(String projectPhase) {
        this.projectPhase = projectPhase;
    }

    public String getProjectDescription() {
        return this.projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectTechnology() {
        return this.projectTechnology;
    }

    public void setProjectTechnology(String projectTechnology) {
        this.projectTechnology = projectTechnology;
    }

    public String getMainTask() {
        return this.mainTask;
    }

    public void setMainTask(String mainTask) {
        this.mainTask = mainTask;
    }
}