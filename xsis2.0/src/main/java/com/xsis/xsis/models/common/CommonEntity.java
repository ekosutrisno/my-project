package com.xsis.xsis.models.common;

import java.util.Date;

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
    private Long createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_on")
    private Date modifiedOn;
    @Column(name = "modified_by")
    private Long modifiedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_on")
    private Date deleteddOn;
    @Column(name = "deleted_by")
    private Long deletedBy;

    @Column(name = "isdelete", nullable = false)
    private Boolean isDelete = false;

    public CommonEntity() {
    }

    public CommonEntity(Date createdOn, Long createdBy, Date modifiedOn, Long modifiedBy, Date deleteddOn, Long deletedBy, Boolean isDelete) {
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
        this.deleteddOn = deleteddOn;
        this.deletedBy = deletedBy;
        this.isDelete = isDelete;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return this.modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Long getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getDeleteddOn() {
        return this.deleteddOn;
    }

    public void setDeleteddOn(Date deleteddOn) {
        this.deleteddOn = deleteddOn;
    }

    public Long getDeletedBy() {
        return this.deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
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