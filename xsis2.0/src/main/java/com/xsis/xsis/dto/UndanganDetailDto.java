package com.xsis.xsis.dto;

import com.xsis.xsis.models.entity.BiodataEntity;
import com.xsis.xsis.models.entity.UndanganEntity;

/**
 * UndanganDetailDto
 */
public class UndanganDetailDto {

    private Long id;

    private UndanganEntity undanganId;

    private BiodataEntity biodataId;

    private String notes;

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