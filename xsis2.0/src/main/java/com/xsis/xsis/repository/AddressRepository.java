package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.AddressEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * AddressRepository
 */
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query(value = "SELECT * FROM x_address WHERE biodata_id = ?1", nativeQuery = true)
    List<AddressEntity> getAddressByBiodata(Long id);

}