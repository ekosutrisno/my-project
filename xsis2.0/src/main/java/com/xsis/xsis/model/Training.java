package com.xsis.xsis.model;

import javax.persistence.*;

import com.xsis.xsis.dto.TraiDto;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "trainingMapping", classes = { @ConstructorResult(targetClass = TraiDto.class, columns = { 
    @ColumnResult(name = "id", type = Long.class),
    @ColumnResult(name = "biodata_id", type = Long.class),
    @ColumnResult(name = "training_name", type = String.class),
    @ColumnResult(name = "organizer", type = String.class),
    @ColumnResult(name = "training_year", type = String.class),
    @ColumnResult(name = "training_duration", type = Integer.class),
    @ColumnResult(name = "time_period_id", type = Long.class),
    @ColumnResult(name = "isdelete", type = Boolean.class)}) })

// List Training Join Biodata
@NamedNativeQuery(name = "Training.getTrainingBiodata", 
query = "select a.id,a.biodata_id,a.training_name,a.organizer,a.training_year,a.training_duration,a.time_period_id,a.isdelete from x_riwayat_pelatihan a " +
"join x_biodata b on b.id=a.biodata_id where a.biodata_id=:biodataId and a.isdelete=false and b.isdelete=false", resultSetMapping = "trainingMapping")


/**
 * Training
 */
@Entity
@Table(name="x_riwayat_pelatihan")
public class Training extends CommonEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id")
    private Long biodataId;
    
    @Column(name = "training_name")
    private String trainingName;

    @Column(name = "organizer")
    private String organizer;

    @Column(name = "training_year")
    private String trainingYear;

    @Column(name = "training_month")
    private String trainingMonth;

    @Column(name = "training_duration")
    private Integer trainingDuration;

    @Column(name = "time_period_id")
    private Long timePeriodId;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "notes")
    private String notes;

    public Training(){}

    public Training(Long id, Long biodataId, String trainingName, String organizer, String trainingYear, String trainingMonth, Integer trainingDuration, Long timePeriodId, String city, String country, String notes) {
        this.id = id;
        this.biodataId = biodataId;
        this.trainingName = trainingName;
        this.organizer = organizer;
        this.trainingYear = trainingYear;
        this.trainingMonth = trainingMonth;
        this.trainingDuration = trainingDuration;
        this.timePeriodId = timePeriodId;
        this.city = city;
        this.country = country;
        this.notes = notes;
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

    public String getTrainingName() {
        return this.trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getOrganizer() {
        return this.organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getTrainingYear() {
        return this.trainingYear;
    }

    public void setTrainingYear(String trainingYear) {
        this.trainingYear = trainingYear;
    }

    public String getTrainingMonth() {
        return this.trainingMonth;
    }

    public void setTrainingMonth(String trainingMonth) {
        this.trainingMonth = trainingMonth;
    }

    public Integer getTrainingDuration() {
        return this.trainingDuration;
    }

    public void setTrainingDuration(Integer trainingDuration) {
        this.trainingDuration = trainingDuration;
    }

    public Long getTimePeriodId() {
        return this.timePeriodId;
    }

    public void setTimePeriodId(Long timePeriodId) {
        this.timePeriodId = timePeriodId;
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

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}