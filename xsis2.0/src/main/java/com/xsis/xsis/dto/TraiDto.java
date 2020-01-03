package com.xsis.xsis.dto.vacancy_pendidikan_resourceproject;

/**
 * TraiDto
 */
public class TraiDto {

    private Long id;
    private Long biodataId;
    private String trainingName;
    private String organizer;
    private String trainingYear;
    private Integer trainingDuration;
    private Long timePeriodId;
    private Boolean isDelete;

    public TraiDto(){}

    public TraiDto(Long id, Long biodataId, String trainingName, String organizer, String trainingYear, Integer trainingDuration, Long timePeriodId, Boolean isDelete) {
        this.id = id;
        this.biodataId = biodataId;
        this.trainingName = trainingName;
        this.organizer = organizer;
        this.trainingYear = trainingYear;
        this.trainingDuration = trainingDuration;
        this.timePeriodId = timePeriodId;
        this.isDelete = isDelete;
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

    public Boolean isIsDelete() {
        return this.isDelete;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    
}