package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.UndanganEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * UndanganRepository
 */
@Repository
public interface UndanganRepository extends JpaRepository<UndanganEntity, Long> {

  static final String CARI_DATA = "SELECT * FROM x_undangan WHERE LOWER(location) LIKE %:name%";

  @Query(value = CARI_DATA, nativeQuery = true)
  List<UndanganEntity> searchDataByName(@Param("name") String name);

}