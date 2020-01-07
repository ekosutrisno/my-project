package com.xsis.xsis.models.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.models.common.CommonEntity;

/**
 * UndanganEntity
 */
@Entity
@Table(name = UndanganEntity.TABLE_NAME)
public class UndanganEntity extends CommonEntity {
  public static final String TABLE_NAME = "x_undangan";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "schedule_type_id")
  private ScheduleTypeEntity scheduleTypeId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
  @Column(name = "invitation_date")
  private Date invitationDate;

  @Column(name = "invitation_code", length = 20)
  private String invitationCode;

  @Column(name = "time", length = 10)
  private String time;

  @OneToMany(mappedBy = "undanganId")
  private List<UndanganDetailEntity> undanganDetail;

  @Column(name = "other_ro_tro", length = 100)
  private String otherRoTro;

  @Column(name = "location", length = 100)
  private String location;

  @OneToOne
  @JoinColumn(name = "ro")
  private EmployeeEntity ro;

  @OneToOne
  @JoinColumn(name = "tro")
  private EmployeeEntity tro;

  @Column(name = "status", length = 50)
  private String status;

  public UndanganEntity() {
  }

  public UndanganEntity(Long id, ScheduleTypeEntity scheduleTypeId, Date invitationDate, String invitationCode,
      String location, String otherRoTro, String time, EmployeeEntity ro, EmployeeEntity tro, String status) {
    this.id = id;
    this.scheduleTypeId = scheduleTypeId;
    this.invitationDate = invitationDate;
    this.invitationCode = invitationCode;
    this.location = location;
    this.otherRoTro = otherRoTro;
    this.time = time;
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}