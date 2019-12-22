package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.AddressEntity;
import com.xsis.xsis.models.entity.BiodataEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * BiodataRepository
 */
@Repository
public interface BiodataRepository extends JpaRepository<BiodataEntity, Long> {

    @Query(value = "select * from x_biodata where religion_id = ?1", nativeQuery = true)
    List<BiodataEntity> getBiodataByReligion(Long id);

    @Query(value = "select * from x_biodata where marital_status_id = ?1", nativeQuery = true)
    List<BiodataEntity> getBiodataByMarital(Long id);

    @Query(value = "select * from x_biodata where identity_type_id = ?1", nativeQuery = true)
    List<BiodataEntity> getBiodataByIdentity(Long id);

    @Query(value = "select * from x_address where biodata_id = ?1", nativeQuery = true)
    List<AddressEntity> getAddressByBiodata(Long id);

}