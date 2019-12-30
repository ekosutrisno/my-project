package com.xsis.xsis.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Column(name = " schedule_date")
    private Date scheduleDate;

    @Column(name = "time", length = 10)
    private String time;

    @OneToOne
    @JoinColumn(name = "ro")
    private EmployeeEntity ro;

    @OneToOne
    @JoinColumn(name = "tro")
    private EmployeeEntity tro;

    @ManyToOne
    @JoinColumn(name = "schedule_type_id", nullable = false, referencedColumnName = "id")
    private ScheduleTypeEntity scheduleTypeId;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "other_ro_tro", length = 100)
    private String otherRoTro;

    @Column(name = "notes", length = 1000)
    private String notes;

    @Column(name = "is_automatic_mail")
    private boolean isAutomaticMail;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "sent_date")
    private Date sentDate;

    @Column(name = "status", length = 50)
    private String status;

    public RencanaEntity() {
    }

    public RencanaEntity(Long id, String scheduleCode, Date scheduleDate, String time, EmployeeEntity ro,
            EmployeeEntity tro, ScheduleTypeEntity scheduleTypeId, String location, String otherRoTro, String notes,
            boolean isAutomaticMail, Date sentDate, String status) {
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

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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