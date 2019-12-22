package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.AddressEntity;
import com.xsis.xsis.models.entity.BiodataEntity;

/**
 * IBiodataService
 */
public interface IBiodataService {
    List<BiodataEntity> getAll();

    Optional<BiodataEntity> getById(Long id);

    List<BiodataEntity> getBiodataByReligion(Long id);

    List<BiodataEntity> getBiodataByMarital(Long id);

    List<BiodataEntity> getBiodataByIdentity(Long id);

    List<AddressEntity> getAddressByBiodata(Long id);

    BiodataEntity save(BiodataEntity biodataEntity);

    BiodataEntity update(BiodataEntity biodataEntity);

    BiodataEntity delete(Long id);

}