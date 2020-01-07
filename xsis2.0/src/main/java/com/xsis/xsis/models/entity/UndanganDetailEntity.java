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
 * UndanganDetail
 */
@Entity
@Table(name = UndanganDetailEntity.TABLE_NAME)
public class UndanganDetailEntity extends CommonEntity {
    public static final String TABLE_NAME = "x_undangan_detail";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "undangan_id", nullable = false, referencedColumnName = "id")
    private UndanganEntity undanganId;

    @ManyToOne
    @JoinColumn(name = "biodata_id", nullable = false)
    private BiodataEntity biodataId;

    @Column(name = "notes")
    @Size(max = 1000)
    private String notes;

    public UndanganDetailEntity() {
    }

    public UndanganDetailEntity(Long id, UndanganEntity undanganId, BiodataEntity biodataId,
            @Size(max = 1000) String notes) {
        this.id = id;
        this.undanganId = undanganId;
        this.biodataId = biodataId;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UndanganEntity getUndanganId() {
        return undanganId;
    }

    public void setUndanganId(UndanganEntity undanganId) {
        this.undanganId = undanganId;
    }

    public BiodataEntity getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(BiodataEntity biodataId) {
        this.biodataId = biodataId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}