package com.xsis.xsis.models.common;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CommonEntity
 */

/**
 * Model CommonEntity digunakan untuk merecord History action yang terjadi pada
 * tabel yang bersangkutan cara menggunakannya tinggal extend saja kesetiap
 * model... thanks ALl. By Eko sutrisno
 */

@MappedSuperclass
public class CommonEntity {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", nullable = false)
    private Date createdOn;
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_on")
    private Date modifiedOn;
    @Column(name = "modified_by")
    private String modifiedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_on")
    private Date deleteddOn;
    @Column(name = "deleted_by")
    private String deletedBy;

    @Column(name = "isdelete", nullable = false)
    private Boolean isDelete = false;

    public CommonEntity() {
    }

    public CommonEntity(Date createdOn, String createdBy, Date modifiedOn, String modifiedBy, Date deleteddOn,
            String deletedBy, Boolean isDelete) {
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
        this.deleteddOn = deleteddOn;
        this.deletedBy = deletedBy;
        this.isDelete = isDelete;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getDeleteddOn() {
        return deleteddOn;
    }

    public void setDeleteddOn(Date deleteddOn) {
        this.deleteddOn = deleteddOn;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

}