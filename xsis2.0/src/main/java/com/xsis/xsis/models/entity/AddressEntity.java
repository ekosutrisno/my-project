package com.xsis.xsis.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.xsis.xsis.models.common.CommonEntity;

/**
 * AddressEntity
 */
@Entity
@Table(name = AddressEntity.TABLE_NAME)
public class AddressEntity extends CommonEntity {

    public static final String TABLE_NAME = "x_address";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "biodata_id", nullable = false, referencedColumnName = "id")
    private BiodataEntity biodataId;

    @Column(name = "address1")
    @Size(max = 1000)
    private String address1;

    @Column(name = "postal_code1")
    @Size(max = 20)
    private String postalCode1;

    @Column(name = "rt1")
    @Size(max = 5)
    private String rt1;

    @Column(name = "rw1")
    @Size(max = 5)
    private String rw1;

    @Column(name = "kelurahan1")
    @Size(max = 100)
    private String kelurahan1;

    @Column(name = "kecamatan1")
    @Size(max = 100)
    private String kecamatan1;

    @Column(name = "region1")
    @Size(max = 100)
    private String region1;

    @Column(name = "address2")
    @Size(max = 1000)
    private String address2;

    @Column(name = "postal_code2")
    @Size(max = 20)
    private String postalCode2;

    @Column(name = "rt2")
    @Size(max = 5)
    private String rt2;

    @Column(name = "rw2")
    @Size(max = 5)
    private String rw2;

    @Column(name = "kelurahan2")
    @Size(max = 100)
    private String kelurahan2;

    @Column(name = "kecamatan2")
    @Size(max = 100)
    private String kecamatan2;

    @Column(name = "region2")
    @Size(max = 100)
    private String region2;

    public AddressEntity() {
    }

    public AddressEntity(Long id, BiodataEntity biodataId, @Size(max = 1000) String address1,
            @Size(max = 20) String postalCode1, @Size(max = 5) String rt1, @Size(max = 5) String rw1,
            @Size(max = 100) String kelurahan1, @Size(max = 100) String kecamatan1, @Size(max = 100) String region1,
            @Size(max = 1000) String address2, @Size(max = 20) String postalCode2, @Size(max = 5) String rt2,
            @Size(max = 5) String rw2, @Size(max = 100) String kelurahan2, @Size(max = 100) String kecamatan2,
            @Size(max = 100) String region2) {
        this.id = id;
        this.biodataId = biodataId;
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BiodataEntity getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(BiodataEntity biodataId) {
        this.biodataId = biodataId;
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

}