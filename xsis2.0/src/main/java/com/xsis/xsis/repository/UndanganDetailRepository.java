package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.UndanganDetailEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * UndanganDetailRepository
 */
public interface UndanganDetailRepository extends JpaRepository<UndanganDetailEntity, Long> {

    static final String CARI_DATA = "SELECT * FROM x_undangan WHERE isdelete='false' AND LOWER(location) LIKE %:name%";

    @Query(value = CARI_DATA, nativeQuery = true)
    List<UndanganDetailEntity> searchDataByName(@Param("name") String name);

    @Query(value = "SELECT * FROM x_undangan_detail WHERE undangan_id = ?1", nativeQuery = true)
    List<UndanganDetailEntity> getDetailByUndanganId(Long id);
}