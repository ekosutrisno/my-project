package com.xsis.xsis.dto;

import java.util.Date;

import com.xsis.xsis.models.entity.BiodataEntity;
import com.xsis.xsis.models.entity.EmployeeEntity;
import com.xsis.xsis.models.entity.ScheduleTypeEntity;
import com.xsis.xsis.models.entity.UndanganEntity;

/**
 * UndanganDto
 */
public class UndanganDto {
    private Long id;
    private ScheduleTypeEntity scheduleTypeId;
    private Date invitationDate;
    private String invitationCode;
    private String time;
    private String otherRoTro;
    private String location;

    private EmployeeEntity ro;
    private EmployeeEntity tro;
    private String status;

    private Long detId;
    private UndanganEntity undanganId;
    private BiodataEntity biodataId;
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScheduleTypeEntity getScheduleTypeId() {
        return scheduleTypeId;
    }

    public void setScheduleTypeId(ScheduleTypeEntity scheduleTypeId) {
        this.scheduleTypeId = scheduleTypeId;
    }

    public Date getInvitationDate() {
        return invitationDate;
    }

    public void setInvitationDate(Date invitationDate) {
        this.invitationDate = invitationDate;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOtherRoTro() {
        return otherRoTro;
    }

    public void setOtherRoTro(String otherRoTro) {
        this.otherRoTro = otherRoTro;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EmployeeEntity getRo() {
        return ro;
    }

    public void setRo(EmployeeEntity ro) {
        this.ro = ro;
    }

    public EmployeeEntity getTro() {
        return tro;
    }

    public void setTro(EmployeeEntity tro) {
        this.tro = tro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDetId() {
        return detId;
    }

    public void setDetId(Long detId) {
        this.detId = detId;
    }

    public UndanganEntity getUndanganId() {
        return undanganId;
    }

    public void setUndanganId(UndanganEntity undanganId) {
        this.undanganId = undanganId;
    }

    public BiodataEntity getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(BiodataEntity biodataId) {
        this.biodataId = biodataId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}