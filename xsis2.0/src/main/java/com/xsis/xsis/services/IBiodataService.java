package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.AddressEntity;
import com.xsis.xsis.models.entity.BiodataEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 * IBiodataService
 */
public interface IBiodataService {
    List<BiodataEntity> getAll();

    Page<BiodataEntity> findByPaging(Pageable pageable, String key);

    Optional<BiodataEntity> getById(Long id);

    List<BiodataEntity> getBiodataByReligion(Long id);

    List<BiodataEntity> getBiodataByMarital(Long id);

    List<BiodataEntity> getBiodataByIdentity(Long id);

    List<AddressEntity> getAddressByBiodata(Long id);

    BiodataEntity save(BiodataEntity biodataEntity);

    BiodataEntity update(BiodataEntity biodataEntity);

    BiodataEntity delete(Long id);

    List<BiodataEntity> searchDataByName(@Param("name") String name);

}