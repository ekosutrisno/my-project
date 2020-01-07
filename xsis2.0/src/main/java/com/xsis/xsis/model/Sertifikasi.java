package com.xsis.xsis.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.xsis.xsis.dto.SertDto;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "sertifikasiMapping", classes = {
        @ConstructorResult(targetClass = SertDto.class, columns = { @ColumnResult(name = "id", type = Long.class),
                @ColumnResult(name = "biodata_id", type = Long.class),
                @ColumnResult(name = "certificate_name", type = String.class),
                @ColumnResult(name = "publisher", type = String.class),
                @ColumnResult(name = "valid_start_year", type = String.class),
                @ColumnResult(name = "until_year", type = String.class),
                @ColumnResult(name = "isdelete", type = Boolean.class) }) })

// List Sertifikasi Join Biodata
@NamedNativeQuery(name = "Sertifikasi.getSertifikasiBiodata", query = "select a.id,a.biodata_id,a.certificate_name,a.publisher,a.valid_start_year,a.until_year,a.isdelete from x_sertifikasi a "
        + "join x_biodata b on b.id=a.biodata_id where a.biodata_id=:biodataId and a.isdelete=false and b.isdelete=false", resultSetMapping = "sertifikasiMapping")

/**
 * Sertifikasi
 */
@Entity
@Table(name = "x_sertifikasi")
public class Sertifikasi extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    private Long biodataId;

    @Column(name = "certificate_name")
    @Size(max = 200)
    private String certificateName;

    @Column(name = "publisher")
    @Size(max = 100)
    private String publisher;

    @Column(name = "valid_start_year")
    @Size(max = 10)
    private String validStartYear;

    @Column(name = "valid_start_month")
    @Size(max = 10)
    private String validStartMonth;

    @Column(name = "until_year")
    @Size(max = 10)
    private String untilYear;

    @Column(name = "until_month")
    @Size(max = 10)
    private String untilMonth;

    @Column(name = "notes")
    @Size(max = 1000)
    private String notes;

    public Sertifikasi() {
    }

    public Sertifikasi(Long biodataId, String certificateName, String publisher, String validStartYear,
            String validStartMonth, String untilYear, String untilMonth, String notes) {
        this.biodataId = biodataId;
        this.certificateName = certificateName;
        this.publisher = publisher;
        this.validStartYear = validStartYear;
        this.validStartMonth = validStartMonth;
        this.untilYear = untilYear;
        this.untilMonth = untilMonth;
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
     * @return String return the certificateName
     */
    public String getCertificateName() {
        return certificateName;
    }

    /**
     * @param certificateName the certificateName to set
     */
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    /**
     * @return String return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return String return the validStartYear
     */
    public String getValidStartYear() {
        return validStartYear;
    }

    /**
     * @param validStartYear the validStartYear to set
     */
    public void setValidStartYear(String validStartYear) {
        this.validStartYear = validStartYear;
    }

    /**
     * @return String return the validStartMonth
     */
    public String getValidStartMonth() {
        return validStartMonth;
    }

    /**
     * @param validStartMonth the validStartMonth to set
     */
    public void setValidStartMonth(String validStartMonth) {
        this.validStartMonth = validStartMonth;
    }

    /**
     * @return String return the untilYear
     */
    public String getUntilYear() {
        return untilYear;
    }

    /**
     * @param untilYear the untilYear to set
     */
    public void setUntilYear(String untilYear) {
        this.untilYear = untilYear;
    }

    /**
     * @return String return the untilMonth
     */
    public String getUntilMonth() {
        return untilMonth;
    }

    /**
     * @param untilMonth the untilMonth to set
     */
    public void setUntilMonth(String untilMonth) {
        this.untilMonth = untilMonth;
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