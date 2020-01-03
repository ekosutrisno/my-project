package com.xsis.xsis.model.vacancy_pendidikan_resourceproject;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.xsis.xsis.dto.vacancy_pendidikan_resourceproject.PeKerDto;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "pengalamanKerjaMapping", classes = { @ConstructorResult(targetClass = PeKerDto.class, columns = { 
    @ColumnResult(name = "id", type = Long.class),
    @ColumnResult(name = "biodata_id", type = Long.class),
    @ColumnResult(name = "company_name", type = String.class),
    @ColumnResult(name = "join_year", type = String.class),
    @ColumnResult(name = "resign_year", type = String.class),
    @ColumnResult(name = "last_position", type = String.class),
    @ColumnResult(name = "isdelete", type = Boolean.class)}) })

// List Pengalaman Kerja Join Biodata
@NamedNativeQuery(name = "PengalamanKerja.getPengalamanKerjaBiodata", 
query = "select a.id,a.biodata_id,a.company_name,a.join_year,a.resign_year,a.last_position,a.isdelete from x_riwayat_pekerjaan a " +
"join x_biodata b on b.id=a.biodata_id where a.biodata_id=:biodataId and a.isdelete=false and b.isdelete=false", resultSetMapping = "pengalamanKerjaMapping")

/**
 * PengalamanKerja
 */
@Entity
@Table(name = "x_riwayat_pekerjaan")
public class PengalamanKerja extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 11)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    @Size(max = 11)
    private Long biodataId;

    @Column(name = "company_name")
    @Size(max = 100)
    private String companyName;

    @Column(name = "city")
    @Size(max = 50)
    private String city;

    @Column(name = "country")
    @Size(max = 50)
    private String country;

    @Column(name = "join_year")
    @Size(max = 10)
    private String joinYear;

    @Column(name = "join_month")
    @Size(max = 10)
    private String joinMonth;

    @Column(name = "resign_year")
    @Size(max = 10)
    private String resignYear;

    @Column(name = "resignMonth")
    @Size(max = 10)
    private String resignMonth;

    @Column(name = "last_position")
    @Size(max = 100)
    private String lastPosition;

    @Column(name = "income")
    @Size(max = 20)
    private String income;

    @Column(name = "is_it_related")
    private Boolean isItRelated = false;

    @Column(name = "about_job")
    @Size(max = 1000)
    private String aboutJob;

    @Column(name = "exit_reason")
    @Size(max = 500)
    private String exitReason;

    @Column(name = "notes")
    @Size(max = 5000)
    private String notes;

    public PengalamanKerja() {
    }

    public PengalamanKerja(Long biodataId, String companyName, String city, String country, String joinYear,
            String joinMonth, String resignYear, String resignMonth, String lastPosition, String income,
            Boolean isItRelated, String aboutJob, String exitReason, String notes) {
        this.biodataId = biodataId;
        this.companyName = companyName;
        this.city = city;
        this.country = country;
        this.joinYear = joinYear;
        this.joinMonth = joinMonth;
        this.resignYear = resignYear;
        this.resignMonth = resignMonth;
        this.lastPosition = lastPosition;
        this.income = income;
        this.isItRelated = isItRelated;
        this.aboutJob = aboutJob;
        this.exitReason = exitReason;
        this.notes = notes;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Long return the biodataId
     */
    public Long getBiodataId() {
        return biodataId;
    }

    /**
     * @param biodataId the biodataId to set
     */
    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    /**
     * @return String return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return String return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return String return the joinYear
     */
    public String getJoinYear() {
        return joinYear;
    }

    /**
     * @param joinYear the joinYear to set
     */
    public void setJoinYear(String joinYear) {
        this.joinYear = joinYear;
    }

    /**
     * @return String return the joinMonth
     */
    public String getJoinMonth() {
        return joinMonth;
    }

    /**
     * @param joinMonth the joinMonth to set
     */
    public void setJoinMonth(String joinMonth) {
        this.joinMonth = joinMonth;
    }

    /**
     * @return String return the resignYear
     */
    public String getResignYear() {
        return resignYear;
    }

    /**
     * @param resignYear the resignYear to set
     */
    public void setResignYear(String resignYear) {
        this.resignYear = resignYear;
    }

    /**
     * @return String return the resignMonth
     */
    public String getResignMonth() {
        return resignMonth;
    }

    /**
     * @param resignMonth the resignMonth to set
     */
    public void setResignMonth(String resignMonth) {
        this.resignMonth = resignMonth;
    }

    /**
     * @return String return the lastPosition
     */
    public String getLastPosition() {
        return lastPosition;
    }

    /**
     * @param lastPosition the lastPosition to set
     */
    public void setLastPosition(String lastPosition) {
        this.lastPosition = lastPosition;
    }

    /**
     * @return String return the income
     */
    public String getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(String income) {
        this.income = income;
    }

    /**
     * @return Boolean return the isItRelated
     */
    public Boolean getIsItRelated() {
        return isItRelated;
    }

    /**
     * @param isItRelated the isItRelated to set
     */
    public void setIsItRelated(Boolean isItRelated) {
        this.isItRelated = isItRelated;
    }

    /**
     * @return String return the aboutJob
     */
    public String getAboutJob() {
        return aboutJob;
    }

    /**
     * @param aboutJob the aboutJob to set
     */
    public void setAboutJob(String aboutJob) {
        this.aboutJob = aboutJob;
    }

    /**
     * @return String return the exitReason
     */
    public String getExitReason() {
        return exitReason;
    }

    /**
     * @param exitReason the exitReason to set
     */
    public void setExitReason(String exitReason) {
        this.exitReason = exitReason;
    }

    /**
     * @return String return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

}