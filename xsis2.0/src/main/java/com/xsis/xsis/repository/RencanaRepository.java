package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.RencanaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * RencanaRepository
 */
@Repository
public interface RencanaRepository extends JpaRepository<RencanaEntity, Long> {

  @Query(value = "SELECT*FROM x_rencana_jadwal ORDER BY id ASC", nativeQuery = true)
  List<RencanaEntity> getRencana();

  static String TGL_MULAI = "";
  static String TGL_SAMPAI = "";
  static final String CARI_DATA = "SELECT*FROM x_rencana_jadwal WHERE schedule_date BETWEEN '" + TGL_MULAI + "' AND '"
      + TGL_MULAI + "'";

  @Query(value = CARI_DATA, nativeQuery = true)
  List<RencanaEntity> searchData(String tgl_mulai, String tgl_akhir);
}