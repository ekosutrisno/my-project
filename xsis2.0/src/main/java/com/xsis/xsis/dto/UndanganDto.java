package com.xsis.xsis.dto;

import java.util.Date;

import com.xsis.xsis.models.entity.EmployeeEntity;
import com.xsis.xsis.models.entity.ScheduleTypeEntity;

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

    public UndanganDto() {
    }

    public UndanganDto(Long id, ScheduleTypeEntity scheduleTypeId, Date invitationDate, String invitationCode,
            String time, String otherRoTro, String location, EmployeeEntity ro, EmployeeEntity tro, String status) {
        this.id = id;
        this.scheduleTypeId = scheduleTypeId;
        this.invitationDate = invitationDate;
        this.invitationCode = invitationCode;
        this.time = time;
        this.otherRoTro = otherRoTro;
        this.location = location;
        this.ro = ro;
        this.tro = tro;
        this.status = status;
    }

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

}