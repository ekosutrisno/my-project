package com.xsis.xsis.dto;

/**
 * PeKerDto
 */
public class PeKerDto {

    private Long id;
    private Long biodataId;
    private String companyName;
    private String joinYear;
    private String resignYear;
    private String lastPosition;
    private Boolean isDelete;

    public PeKerDto(){}

    public PeKerDto(Long id, Long biodataId, String companyName, String joinYear, String resignYear, String lastPosition, Boolean isDelete) {
        this.id = id;
        this.biodataId = biodataId;
        this.companyName = companyName;
        this.joinYear = joinYear;
        this.resignYear = resignYear;
        this.lastPosition = lastPosition;
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

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJoinYear() {
        return this.joinYear;
    }

    public void setJoinYear(String joinYear) {
        this.joinYear = joinYear;
    }

    public String getResignYear() {
        return this.resignYear;
    }

    public void setResignYear(String resignYear) {
        this.resignYear = resignYear;
    }

    public String getLastPosition() {
        return this.lastPosition;
    }

    public void setLastPosition(String lastPosition) {
        this.lastPosition = lastPosition;
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