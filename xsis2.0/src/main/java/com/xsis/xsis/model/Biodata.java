package com.xsis.xsis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.xsis.xsis.models.common.CommonEntity;

/**
 * BiodataEntity
 */
@Entity
@Table(name = "x_biodata")
public class Biodata extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "nick_name", nullable = false)
    @Size(max = 100)
    private String nickName;

    @Column(name = "pob", nullable = false)
    @Size(max = 100)
    private String pob;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "gender", nullable = false)
    private Boolean gender;

    @Column(name = "religion_id", nullable = false)
    private Long religionId;

    @Column(name = "hight")
    private Integer hight;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "nationality")
    @Size(max = 100)
    private String nationality;

    @Column(name = "ethnic")
    @Size(max = 50)
    private String ethnic;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "identity_type_id", nullable = false)
    private Long identityTypeId;

    @Column(name = "email", nullable = false)
    @Size(max = 100)
    private String email;

    @Column(name = "identity_no", nullable = false)
    @Size(max = 50)
    private String identityNo;

    @Column(name = "phone_number1", nullable = false)
    @Size(max = 50)
    private String phoneNumber1;

    @Column(name = "phone_number2")
    @Size(max = 50)
    private String phoneNumber2;

    @Column(name = "parent_phone_number", nullable = false)
    @Size(max = 50)
    private String parentPhoneNumber;

    @Column(name = "child_sequence")
    @Size(max = 5)
    private String childSequence;

    @Column(name = "how_many_brothers")
    @Size(max = 5)
    private String howManyBrothers;

    @Column(name = "marital_status_id", nullable = false)
    private Long maritalStatusId;

    @Column(name = "addrbook_id")
    private Long addrbookId;

    @Column(name = "token")
    @Size(max = 10)
    private String token;

    @Column(name = "expired_token")
    private Date expiredToken;

    @Column(name = "marriage_year")
    @Size(max = 10)
    private String marriageYear;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "is_process")
    private Boolean isProcess;

    @Column(name = "is_complete")
    private Boolean isComplete;

    public Biodata() {
    }

    public Biodata(Long id, String fullName, String nickName, String pob, Date dob, Boolean gender, Long religionId, Integer hight, Integer weight, String nationality, String ethnic, String hobby, Long identityTypeId, String email, String identityNo, String phoneNumber1, String phoneNumber2, String parentPhoneNumber, String childSequence, String howManyBrothers, Long maritalStatusId, Long addrbookId, String token, Date expiredToken, String marriageYear, Long companyId, Boolean isProcess, Boolean isComplete) {
        this.id = id;
        this.fullName = fullName;
        this.nickName = nickName;
        this.pob = pob;
        this.dob = dob;
        this.gender = gender;
        this.religionId = religionId;
        this.hight = hight;
        this.weight = weight;
        this.nationality = nationality;
        this.ethnic = ethnic;
        this.hobby = hobby;
        this.identityTypeId = identityTypeId;
        this.email = email;
        this.identityNo = identityNo;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.parentPhoneNumber = parentPhoneNumber;
        this.childSequence = childSequence;
        this.howManyBrothers = howManyBrothers;
        this.maritalStatusId = maritalStatusId;
        this.addrbookId = addrbookId;
        this.token = token;
        this.expiredToken = expiredToken;
        this.marriageYear = marriageYear;
        this.companyId = companyId;
        this.isProcess = isProcess;
        this.isComplete = isComplete;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPob() {
        return this.pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean isGender() {
        return this.gender;
    }

    public Boolean getGender() {
        return this.gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Long getReligionId() {
        return this.religionId;
    }

    public void setReligionId(Long religionId) {
        this.religionId = religionId;
    }

    public Integer getHight() {
        return this.hight;
    }

    public void setHight(Integer hight) {
        this.hight = hight;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEthnic() {
        return this.ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getHobby() {
        return this.hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Long getIdentityTypeId() {
        return this.identityTypeId;
    }

    public void setIdentityTypeId(Long identityTypeId) {
        this.identityTypeId = identityTypeId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityNo() {
        return this.identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getPhoneNumber1() {
        return this.phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return this.phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getParentPhoneNumber() {
        return this.parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getChildSequence() {
        return this.childSequence;
    }

    public void setChildSequence(String childSequence) {
        this.childSequence = childSequence;
    }

    public String getHowManyBrothers() {
        return this.howManyBrothers;
    }

    public void setHowManyBrothers(String howManyBrothers) {
        this.howManyBrothers = howManyBrothers;
    }

    public Long getMaritalStatusId() {
        return this.maritalStatusId;
    }

    public void setMaritalStatusId(Long maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public Long getAddrbookId() {
        return this.addrbookId;
    }

    public void setAddrbookId(Long addrbookId) {
        this.addrbookId = addrbookId;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiredToken() {
        return this.expiredToken;
    }

    public void setExpiredToken(Date expiredToken) {
        this.expiredToken = expiredToken;
    }

    public String getMarriageYear() {
        return this.marriageYear;
    }

    public void setMarriageYear(String marriageYear) {
        this.marriageYear = marriageYear;
    }

    public Long getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Boolean isIsProcess() {
        return this.isProcess;
    }

    public Boolean getIsProcess() {
        return this.isProcess;
    }

    public void setIsProcess(Boolean isProcess) {
        this.isProcess = isProcess;
    }

    public Boolean isIsComplete() {
        return this.isComplete;
    }

    public Boolean getIsComplete() {
        return this.isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    


}