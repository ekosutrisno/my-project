package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;
import com.xsis.xsis.models.entity.RencanaEntity;
import org.springframework.data.repository.query.Param;

/**
 * IRencanaService
 */
public interface IRencanaService {

    List<RencanaEntity> getAll();

    List<RencanaEntity> searchData(@Param("tgl_mulai") String tgl_mulai, @Param("tgl_sampai") String tgl_sampai);

    RencanaEntity save(RencanaEntity rencanaEntity);

    Optional<RencanaEntity> getById(Long id);

    RencanaEntity update(RencanaEntity rencanaEntity);

    RencanaEntity delete(Long id);
}