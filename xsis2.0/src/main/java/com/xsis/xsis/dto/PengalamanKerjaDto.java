package com.xsis.xsis.dto;

/**
 * PengalamanKerjaDto
 */
public class PengalamanKerjaDto {
    private long id;
    private long biodataId;
    private String companyName;
    private String city;
    private String country;
    private String joinYear;
    private String joinMonth;
    private String resignYear;
    private String resignMonth;
    private String lastPosition;
    private String income;
    private Boolean isItRelated;
    private String aboutJob;
    private String exitReason;
    private String notes;

    public PengalamanKerjaDto() {
    }

    public PengalamanKerjaDto(long id, long biodataId, String companyName, String city, String country, String joinYear,
            String joinMonth, String resignYear, String resignMonth, String lastPosition, String income,
            Boolean isItRelated, String aboutJob, String exitReason, String notes) {
        this.id = id;
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
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return long return the biodataId
     */
    public long getBiodataId() {
        return biodataId;
    }

    /**
     * @param biodataId the biodataId to set
     */
    public void setBiodataId(long biodataId) {
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
    public Boolean isIsItRelated() {
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