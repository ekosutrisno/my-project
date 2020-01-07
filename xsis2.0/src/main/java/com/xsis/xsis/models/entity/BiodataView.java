package com.xsis.xsis.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * BiodataView
 */
@Entity
@Immutable
@Table(name = "x_data_vacancy")
public class BiodataView {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "fullname")
  private String fullname;

  @Column(name = "nick_name")
  private String nick_name;

  @Column(name = "email")
  private String email;

  @Column(name = "phone_number1")
  private String phone_number1;

  @Column(name = "school_name")
  private String school_name;

  public Long getId() {
    return id;
  }

  public String getFullname() {
    return fullname;
  }

  public String getNick_name() {
    return nick_name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone_number1() {
    return phone_number1;
  }

  public String getSchool_name() {
    return school_name;
  }

}