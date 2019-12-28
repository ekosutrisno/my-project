package com.xsis.xsis.dto;

/**
 * KeahDto
 */
public class KeahDto {

    private Long id;
    private Long biodataId;
    private String skillName;
    private Long skillLevelId;
    private Boolean isDelete;

    public KeahDto(){}

    public KeahDto(Long id, Long biodataId, String skillName, Long skillLevelId, Boolean isDelete) {
        this.id = id;
        this.biodataId = biodataId;
        this.skillName = skillName;
        this.skillLevelId = skillLevelId;
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

    public String getSkillName() {
        return this.skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Long getSkillLevelId() {
        return this.skillLevelId;
    }

    public void setSkillLevelId(Long skillLevelId) {
        this.skillLevelId = skillLevelId;
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