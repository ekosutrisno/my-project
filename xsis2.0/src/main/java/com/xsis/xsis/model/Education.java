package com.xsis.xsis.model;

import javax.persistence.*;

import com.xsis.xsis.dto.EduDto;
import com.xsis.xsis.models.common.CommonEntity;


@SqlResultSetMapping(name = "educationMapping", classes = { @ConstructorResult(targetClass = EduDto.class, columns = { 
    @ColumnResult(name = "id", type = Long.class),
    @ColumnResult(name = "isdelete", type = Boolean.class),
    @ColumnResult(name = "biodata_id", type = Long.class),
    @ColumnResult(name = "education_level_id", type = Long.class),
    @ColumnResult(name = "school_name", type = String.class),
    @ColumnResult(name = "name", type = String.class),
    @ColumnResult(name = "entry_year", type = String.class),
    @ColumnResult(name = "graduation_year", type = String.class),
    @ColumnResult(name = "major", type = String.class),
    @ColumnResult(name = "gpa", type = Double.class)}) })

// List Category Join Brand
@NamedNativeQuery(name = "Education.getEduName", 
query = "select a.id,a.isdelete,a.education_level_id,a.biodata_id,a.school_name,b.name,a.entry_year,a.graduation_year,a.major,a.gpa from x_riwayat_pendidikan a " +
"join x_education_level b on b.id=a.education_level_id where a.biodata_id=:biodataId and a.isdelete=false", resultSetMapping = "educationMapping")

@NamedNativeQuery(name = "Education.getEduNameDetail", 
query = "select a.id,a.isdelete,a.education_level_id,a.biodata_id,a.school_name,b.name,a.entry_year,a.graduation_year,a.major,a.gpa from x_riwayat_pendidikan a " +
"join x_education_level b on b.id=a.education_level_id where (a.biodata_id=:biodataId and a.id=:id) and a.isdelete=false", resultSetMapping = "educationMapping")

/**
 * Pendidikan
 */
@Entity
@Table(name = "x_riwayat_pendidikan")
public class Education extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "education_level_id")
    private Long educationLevelId;

    @Column(name = "entry_year")
    private String entryYear;

    @Column(name = "graduation_year")
    private String graduationYear;

    @Column(name = "major")
    private String major;

    @Column(name = "gpa")
    private Double gpa;

    @Column(name = "notes")
    private String notes;

    @Column(name = "orders")
    private Integer orders;

    @Column(name = "judul_ta")
    private String judulTa;

    @Column(name = "deskripsi_ta")
    private String deskripsiTa;

    public Education() {
    }

    public Education(Long id, Long biodataId, String schoolName, String city, String country, Long educationLevelId, String entryYear, String graduationYear, String major, Double gpa, String notes, Integer orders, String judulTa, String deskripsiTa) {
        this.id = id;
        this.biodataId = biodataId;
        this.schoolName = schoolName;
        this.city = city;
        this.country = country;
        this.educationLevelId = educationLevelId;
        this.entryYear = entryYear;
        this.graduationYear = graduationYear;
        this.major = major;
        this.gpa = gpa;
        this.notes = notes;
        this.orders = orders;
        this.judulTa = judulTa;
        this.deskripsiTa = deskripsiTa;
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

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getEducationLevelId() {
        return this.educationLevelId;
    }

    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
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

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getOrders() {
        return this.orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getJudulTa() {
        return this.judulTa;
    }

    public void setJudulTa(String judulTa) {
        this.judulTa = judulTa;
    }

    public String getDeskripsiTa() {
        return this.deskripsiTa;
    }

    public void setDeskripsiTa(String deskripsiTa) {
        this.deskripsiTa = deskripsiTa;
    }

}