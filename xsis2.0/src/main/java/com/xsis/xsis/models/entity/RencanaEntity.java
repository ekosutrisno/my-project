package com.xsis.xsis.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.models.common.CommonEntity;

/**
 * RencanaEntity
 */
@Entity
@Table(name = RencanaEntity.TABLE_NAME)
public class RencanaEntity extends CommonEntity {
    public static final String TABLE_NAME = "x_rencana_jadwal";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = " schedule_code", length = 20)
    private String scheduleCode;

    @Column(name = " schedule_date")
    private String scheduleDate;

    @Column(name = "time", length = 10)
    private String time;

    @Column(name = "ro")
    private Long ro;

    @Column(name = "tro")
    private Long tro;

    @Column(name = "schedule_type_id")
    private Long scheduleTypeId;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "other_ro_tro", length = 100)
    private String otherRoTro;

    @Column(name = "note", length = 1000)
    private String note;

    @Column(name = "is_automatic_mail")
    private boolean isAutomaticMail;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "sent_date")
    private Date sentDate;

    @Column(name = "status", length = 50)
    private String status;

    public RencanaEntity() {
    }

    public RencanaEntity(Long id, String scheduleCode, String scheduleDate, String time, Long ro, Long tro,
            Long scheduleTypeId, String location, String otherRoTro, String note, boolean isAutomaticMail,
            Date sentDate, String status) {
        this.id = id;
        this.scheduleCode = scheduleCode;
        this.scheduleDate = scheduleDate;
        this.time = time;
        this.ro = ro;
        this.tro = tro;
        this.scheduleTypeId = scheduleTypeId;
        this.location = location;
        this.otherRoTro = otherRoTro;
        this.note = note;
        this.isAutomaticMail = isAutomaticMail;
        this.sentDate = sentDate;
        this.status = status;
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

    public Long getScheduleTypeId() {
        return scheduleTypeId;
    }

    public void setScheduleTypeId(Long scheduleTypeId) {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isAutomaticMail() {
        return isAutomaticMail;
    }

    public void setAutomaticMail(boolean isAutomaticMail) {
        this.isAutomaticMail = isAutomaticMail;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}