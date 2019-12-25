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
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.models.common.CommonEntity;

/**
 * BiodataEntity
 */
@Entity
@Table(name = BiodataEntity.TABLE_NAME)
public class BiodataEntity extends CommonEntity {

    public static final String TABLE_NAME = "x_biodata";

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "gender", nullable = false)
    private Boolean gender;

    // Join dengan table religion
    @ManyToOne
    @JoinColumn(name = "religion_id", referencedColumnName = "id")
    private ReligionEntity religion;

    // Mapping ke table address
    @OneToMany(mappedBy = "biodataId")
    private List<AddressEntity> address;

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

    // Join Dengan table Identitas_type_id
    @ManyToOne
    @JoinColumn(name = "identity_type_id", nullable = false, referencedColumnName = "id")
    private IdentitasTypeEntity identityType;

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

    // Join dengan maritak status
    @ManyToOne
    @JoinColumn(name = "marital_status_id", nullable = false, referencedColumnName = "id")
    private MaritalStatusEntity maritalStatus;

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

    public BiodataEntity() {
    }

    public BiodataEntity(Long id, String fullName, String nickName, String pob, Date dob, Boolean gender, Integer hight,
            Integer weight, String nationality, String ethnic, String hobby, Long identityTypeId, String email,
            String identityNo, String phoneNumber1, String phoneNumber2, String parentPhoneNumber, String childSequence,
            String howManyBrothers, Long addrbookId, String token, Date expiredToken, String marriageYear,
            Long companyId, Boolean isProcess, Boolean isComplete, ReligionEntity religion,
            MaritalStatusEntity maritalStatus, IdentitasTypeEntity identityType) {
        this.id = id;
        this.fullName = fullName;
        this.nickName = nickName;
        this.pob = pob;
        this.dob = dob;
        this.gender = gender;
        this.hight = hight;
        this.weight = weight;
        this.nationality = nationality;
        this.ethnic = ethnic;
        this.hobby = hobby;
        this.identityType = identityType;
        this.email = email;
        this.identityNo = identityNo;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.parentPhoneNumber = parentPhoneNumber;
        this.childSequence = childSequence;
        this.howManyBrothers = howManyBrothers;
        this.maritalStatus = maritalStatus;
        this.addrbookId = addrbookId;
        this.token = token;
        this.expiredToken = expiredToken;
        this.marriageYear = marriageYear;
        this.companyId = companyId;
        this.isProcess = isProcess;
        this.isComplete = isComplete;
        this.religion = religion;
    }

    public BiodataEntity(Date createdOn, Long createdBy, Date modifiedOn, Long modifiedBy, Date deleteddOn,
            Long deletedBy, Boolean isDelete, Long id, String fullName, String nickName, String pob, Date dob,
            Boolean gender, Integer hight, Integer weight, String nationality, String ethnic, String hobby,
            Long identityTypeId, String email, String identityNo, String phoneNumber1, String phoneNumber2,
            String parentPhoneNumber, String childSequence, String howManyBrothers, Long addrbookId, String token,
            Date expiredToken, String marriageYear, Long companyId, Boolean isProcess, Boolean isComplete,
            ReligionEntity religion, MaritalStatusEntity maritalStatus, IdentitasTypeEntity identityType) {
        super(createdOn, createdBy, modifiedOn, modifiedBy, deleteddOn, deletedBy, isDelete);
        this.id = id;
        this.fullName = fullName;
        this.nickName = nickName;
        this.pob = pob;
        this.dob = dob;
        this.gender = gender;
        this.hight = hight;
        this.weight = weight;
        this.nationality = nationality;
        this.ethnic = ethnic;
        this.hobby = hobby;
        this.identityType = identityType;
        this.email = email;
        this.identityNo = identityNo;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.parentPhoneNumber = parentPhoneNumber;
        this.childSequence = childSequence;
        this.howManyBrothers = howManyBrothers;
        this.maritalStatus = maritalStatus;
        this.addrbookId = addrbookId;
        this.token = token;
        this.expiredToken = expiredToken;
        this.marriageYear = marriageYear;
        this.companyId = companyId;
        this.isProcess = isProcess;
        this.isComplete = isComplete;
        this.religion = religion;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getHight() {
        return hight;
    }

    public void setHight(Integer hight) {
        this.hight = hight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getChildSequence() {
        return childSequence;
    }

    public void setChildSequence(String childSequence) {
        this.childSequence = childSequence;
    }

    public String getHowManyBrothers() {
        return howManyBrothers;
    }

    public void setHowManyBrothers(String howManyBrothers) {
        this.howManyBrothers = howManyBrothers;
    }

    public Long getAddrbookId() {
        return addrbookId;
    }

    public void setAddrbookId(Long addrbookId) {
        this.addrbookId = addrbookId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiredToken() {
        return expiredToken;
    }

    public void setExpiredToken(Date expiredToken) {
        this.expiredToken = expiredToken;
    }

    public String getMarriageYear() {
        return marriageYear;
    }

    public void setMarriageYear(String marriageYear) {
        this.marriageYear = marriageYear;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Boolean getIsProcess() {
        return isProcess;
    }

    public void setIsProcess(Boolean isProcess) {
        this.isProcess = isProcess;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    public ReligionEntity getReligion() {
        return religion;
    }

    public void setReligion(ReligionEntity religion) {
        this.religion = religion;
    }

    public MaritalStatusEntity getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatusEntity maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public IdentitasTypeEntity getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentitasTypeEntity identityType) {
        this.identityType = identityType;
    }

}