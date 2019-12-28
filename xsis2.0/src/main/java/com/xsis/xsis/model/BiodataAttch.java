package com.xsis.xsis.model;

import javax.persistence.*;

import com.xsis.xsis.dto.BioAttchDto;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "biodataAttchMapping", classes = { @ConstructorResult(targetClass = BioAttchDto.class, columns = { 
    @ColumnResult(name = "id", type = Long.class),
    @ColumnResult(name = "biodata_id", type = Long.class),
    @ColumnResult(name = "file_name", type = String.class),
    @ColumnResult(name = "file_path", type = String.class),
    @ColumnResult(name = "notes", type = String.class),
    @ColumnResult(name = "is_photo", type = Boolean.class),
    @ColumnResult(name = "isdelete", type = Boolean.class)}) })

// List Biodata Attachment Join Biodata
@NamedNativeQuery(name = "BiodataAttch.getBiodataAttachment", 
query = "select a.id,a.biodata_id,a.file_name,a.file_path,a.notes,a.is_photo,a.isdelete from x_biodata_attachment a " +
"join x_biodata b on b.id=a.biodata_id where a.biodata_id=:biodataId and a.isdelete=false", resultSetMapping = "biodataAttchMapping")

/**
 * BiodataAttch
 */
@Entity
@Table(name = "x_biodata_attachment")
public class BiodataAttch extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "notes")
    private String notes;

    @Column(name = "is_photo")
    private Boolean isPhoto;

    public BiodataAttch(){}

    public BiodataAttch(Long id, Long biodataId, String fileName, String filePath, String notes, Boolean isPhoto) {
        this.id = id;
        this.biodataId = biodataId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.notes = notes;
        this.isPhoto = isPhoto;
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
}