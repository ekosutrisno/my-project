package com.xsis.xsis.dto;

/**
 * EduDto
 */
public class EduDto {

    private Long id;
    private Boolean isDelete;
    private Long biodataId;
    private Long educationLevelId;
    private String schoolName;
    private String name;
    private String entryYear;
    private String graduationYear;
    private String major;
    private Double gpa;

    public EduDto() {
    }

    public EduDto(Long id, Boolean isDelete, Long biodataId, Long educationLevelId, String schoolName, String name, String entryYear, String graduationYear, String major, Double gpa) {
        this.id = id;
        this.isDelete = isDelete;
        this.biodataId = biodataId;
        this.educationLevelId = educationLevelId;
        this.schoolName = schoolName;
        this.name = name;
        this.entryYear = entryYear;
        this.graduationYear = graduationYear;
        this.major = major;
        this.gpa = gpa;
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

    public Long getBiodataId() {
        return this.biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public Long getEducationLevelId() {
        return this.educationLevelId;
    }

    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntryYear() {
        return this.entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    public String getGraduationYear() {
        return this.graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGpa() {
        return this.gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }



    
}