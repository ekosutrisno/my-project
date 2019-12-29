package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.RencanaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * RencanaRepository
 */
@Repository
public interface RencanaRepository extends JpaRepository<RencanaEntity, Long> {

  @Query(value = "SELECT*FROM x_rencana_jadwal ORDER BY schedule_code ASC", nativeQuery = true)
  List<RencanaEntity> getRencanaAsc();

  @Query(value = "SELECT*FROM x_rencana_jadwal ORDER BY schedule_code DESC", nativeQuery = true)
  List<RencanaEntity> getRencanaDesc();

  // to_date('20170103','YYYYMMDD')
  static final String CARI_DATA = "SELECT * FROM x_rencana_jadwal WHERE CAST(schedule_date AS VARCHAR) BETWEEN :tgl_mulai AND :tgl_sampai ORDER BY schedule_date";

  @Query(value = CARI_DATA, nativeQuery = true)
  List<RencanaEntity> searchData(@Param("tgl_mulai") String tgl_mulai, @Param("tgl_sampai") String tgl_sampai);

}