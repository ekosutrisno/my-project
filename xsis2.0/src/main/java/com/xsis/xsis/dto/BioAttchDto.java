package com.xsis.xsis.dto;

/**
 * BioAttchDto
 */
public class BioAttchDto {

    private Long id;
    private Long biodataId;
    private String fileName;
    private String filePath;
    private String notes;
    private Boolean isPhoto;
    private Boolean isDelete;

    public BioAttchDto() {
    }

    public BioAttchDto(Long id, Long biodataId, String fileName, String filePath, String notes, Boolean isPhoto,
            Boolean isDelete) {
        this.id = id;
        this.biodataId = biodataId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.notes = notes;
        this.isPhoto = isPhoto;
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

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean isIsPhoto() {
        return this.isPhoto;
    }

    public Boolean getIsPhoto() {
        return this.isPhoto;
    }

    public void setIsPhoto(Boolean isPhoto) {
        this.isPhoto = isPhoto;
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