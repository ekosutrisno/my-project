package com.xsis.xsis.dto;

import com.xsis.xsis.models.entity.ScheduleTypeEntity;

/**
 * RencanaDto
 */
public class RencanaDto {

    private Long id;
    private String scheduleCode;
    private String scheduleDate;
    private String time;
    private Long ro;
    private Long tro;
    private ScheduleTypeEntity scheduleTypeId;
    private String location;
    private String otherRoTro;
    private String notes;
    private boolean isAutomaticMail;
    // private Date sentDate;

    public RencanaDto() {
    }

    public RencanaDto(Long id, String scheduleCode, String scheduleDate, String time, Long ro, Long tro,
            ScheduleTypeEntity scheduleTypeId, String location, String otherRoTro, String notes,
            boolean isAutomaticMail) {
        this.id = id;
        this.scheduleCode = scheduleCode;
        this.scheduleDate = scheduleDate;
        this.time = time;
        this.ro = ro;
        this.tro = tro;
        this.scheduleTypeId = scheduleTypeId;
        this.location = location;
        this.otherRoTro = otherRoTro;
        this.notes = notes;
        this.isAutomaticMail = isAutomaticMail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(String scheduleCode) {
        this.scheduleCode = scheduleCode;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getRo() {
        return ro;
    }

    public void setRo(Long ro) {
        this.ro = ro;
    }

    public Long getTro() {
        return tro;
    }

    public void setTro(Long tro) {
        this.tro = tro;
    }

    public ScheduleTypeEntity getScheduleTypeId() {
        return scheduleTypeId;
    }

    public void setScheduleTypeId(ScheduleTypeEntity scheduleTypeId) {
        this.scheduleTypeId = scheduleTypeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOtherRoTro() {
        return otherRoTro;
    }

    public void setOtherRoTro(String otherRoTro) {
        this.otherRoTro = otherRoTro;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isAutomaticMail() {
        return isAutomaticMail;
    }

    public void setAutomaticMail(boolean isAutomaticMail) {
        this.isAutomaticMail = isAutomaticMail;
    }

}