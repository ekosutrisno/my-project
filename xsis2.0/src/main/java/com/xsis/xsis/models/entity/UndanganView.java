package com.xsis.xsis.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.Immutable;

/**
 * UndanganView
 */
@Entity
@Immutable
@Table(name = "x_data_search")
public class UndanganView {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "invitation_code")
    private String invitation_code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Column(name = "invitation_date")
    private Date invitation_date;

    @Column(name = "time")
    private String time;

    @Column(name = "major")
    private String major;

    @Column(name = "notes")
    private String notes;

    @Column(name = "school_name")
    private String school_name;

    public String getFullname() {
        return fullname;
    }

    public String getInvitation_code() {
        return invitation_code;
    }

    public Date getInvitation_date() {
        return invitation_date;
    }

    public String getTime() {
        return time;
    }

    public String getMajor() {
        return major;
    }

    public String getSchool_name() {
        return school_name;
    }

    public Long getId() {
        return id;
    }

    public String getNotes() {
        return notes;
    }
}