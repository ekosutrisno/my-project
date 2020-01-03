package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.AddressEntity;
import com.xsis.xsis.models.entity.BiodataEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * BiodataRepository
 */
public interface BioRepoBackup extends JpaRepository<BiodataEntity, Long> {

  @Query(value = "SELECT * FROM x_biodata WHERE religion_id = ?1", nativeQuery = true)
  List<BiodataEntity> getBiodataByReligion(Long id);

  @Query(value = "SELECT * FROM x_biodata WHERE marital_status_id = ?1", nativeQuery = true)
  List<BiodataEntity> getBiodataByMarital(Long id);

  @Query(value = "SELECT * FROM x_biodata WHERE identity_type_id = ?1", nativeQuery = true)
  List<BiodataEntity> getBiodataByIdentity(Long id);

  @Query(value = "SELECT * FROM x_address WHERE biodata_id = ?1", nativeQuery = true)
  List<AddressEntity> getAddressByBiodata(Long id);

  static final String CARI_DATA = "SELECT * FROM x_biodata WHERE isdelete='false' AND LOWER(fullname) LIKE %:name%";

  @Query(value = CARI_DATA, nativeQuery = true)
  List<BiodataEntity> searchDataByName(@Param("name") String name);
}