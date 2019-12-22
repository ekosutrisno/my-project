package com.xsis.xsis.dto;

import java.util.Date;

import com.xsis.xsis.models.entity.IdentitasTypeEntity;
import com.xsis.xsis.models.entity.MaritalStatusEntity;
import com.xsis.xsis.models.entity.ReligionEntity;

/**
 * BiodataDto
 */
public class BiodataDto {

    private Long id;
    private String fullName;
    private String nickName;
    private String pob;
    private Date dob;
    private Boolean gender;
    private Integer hight;
    private Integer weight;
    private String nationality;
    private String ethnic;
    private String hobby;
    private String email;
    private String identityNo;
    private String phoneNumber1;
    private String phoneNumber2;
    private String parentPhoneNumber;
    private String childSequence;
    private String howManyBrothers;
    private Long addrbookId;
    private String token;
    private Date expiredToken;
    private String marriageYear;
    private Long companyId;
    private Boolean isProcess;
    private Boolean isComplete;

    private String address1;
    private String postalCode1;
    private String rt1;
    private String rw1;
    private String kelurahan1;
    private String kecamatan1;
    private String region1;

    private String address2;
    private String postalCode2;
    private String rt2;
    private String rw2;
    private String kelurahan2;
    private String kecamatan2;
    private String region2;
    private Long idA;

    private ReligionEntity religion;
    private MaritalStatusEntity maritalStatus;
    private IdentitasTypeEntity identityType;

    public BiodataDto() {
    }

    public BiodataDto(Long id, String fullName, String nickName, String pob, Date dob, Boolean gender, Integer hight,
            Integer weight, String nationality, String ethnic, String hobby, String email, String identityNo,
            String phoneNumber1, String phoneNumber2, String parentPhoneNumber, String childSequence,
            String howManyBrothers, Long addrbookId, String token, Date expiredToken, String marriageYear,
            Long companyId, Boolean isProcess, Boolean isComplete, String address1, String postalCode1, String rt1,
            String rw1, String kelurahan1, String kecamatan1, String region1, String address2, String postalCode2,
            String rt2, String rw2, String kelurahan2, String kecamatan2, String region2, ReligionEntity religion,
            MaritalStatusEntity maritalStatus, IdentitasTypeEntity identityType, Long idA) {
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
        this.email = email;
        this.identityNo = identityNo;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.parentPhoneNumber = parentPhoneNumber;
        this.childSequence = childSequence;
        this.howManyBrothers = howManyBrothers;
        this.addrbookId = addrbookId;
        this.token = token;
        this.expiredToken = expiredToken;
        this.marriageYear = marriageYear;
        this.companyId = companyId;
        this.isProcess = isProcess;
        this.isComplete = isComplete;
        this.address1 = address1;
        this.postalCode1 = postalCode1;
        this.rt1 = rt1;
        this.rw1 = rw1;
        this.kelurahan1 = kelurahan1;
        this.kecamatan1 = kecamatan1;
        this.region1 = region1;
        this.address2 = address2;
        this.postalCode2 = postalCode2;
        this.rt2 = rt2;
        this.rw2 = rw2;
        this.kelurahan2 = kelurahan2;
        this.kecamatan2 = kecamatan2;
        this.region2 = region2;
        this.religion = religion;
        this.maritalStatus = maritalStatus;
        this.identityType = identityType;
        this.idA = idA;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getPostalCode1() {
        return postalCode1;
    }

    public void setPostalCode1(String postalCode1) {
        this.postalCode1 = postalCode1;
    }

    public String getRt1() {
        return rt1;
    }

    public void setRt1(String rt1) {
        this.rt1 = rt1;
    }

    public String getRw1() {
        return rw1;
    }

    public void setRw1(String rw1) {
        this.rw1 = rw1;
    }

    public String getKelurahan1() {
        return kelurahan1;
    }

    public void setKelurahan1(String kelurahan1) {
        this.kelurahan1 = kelurahan1;
    }

    public String getKecamatan1() {
        return kecamatan1;
    }

    public void setKecamatan1(String kecamatan1) {
        this.kecamatan1 = kecamatan1;
    }

    public String getRegion1() {
        return region1;
    }

    public void setRegion1(String region1) {
        this.region1 = region1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostalCode2() {
        return postalCode2;
    }

    public void setPostalCode2(String postalCode2) {
        this.postalCode2 = postalCode2;
    }

    public String getRt2() {
        return rt2;
    }

    public void setRt2(String rt2) {
        this.rt2 = rt2;
    }

    public String getRw2() {
        return rw2;
    }

    public void setRw2(String rw2) {
        this.rw2 = rw2;
    }

    public String getKelurahan2() {
        return kelurahan2;
    }

    public void setKelurahan2(String kelurahan2) {
        this.kelurahan2 = kelurahan2;
    }

    public String getKecamatan2() {
        return kecamatan2;
    }

    public void setKecamatan2(String kecamatan2) {
        this.kecamatan2 = kecamatan2;
    }

    public String getRegion2() {
        return region2;
    }

    public void setRegion2(String region2) {
        this.region2 = region2;
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

    public Long getIdA() {
        return idA;
    }

    public void setIdA(Long idA) {
        this.idA = idA;
    }

}