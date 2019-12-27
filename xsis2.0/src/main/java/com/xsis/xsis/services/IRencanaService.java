package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;
import com.xsis.xsis.models.entity.RencanaEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 * IRencanaService
 */
public interface IRencanaService {

    List<RencanaEntity> getAll();

    List<RencanaEntity> getAscending();

    List<RencanaEntity> getDescending();

    List<RencanaEntity> searchData(@Param("tgl_mulai") String tgl_mulai, @Param("tgl_sampai") String tgl_sampai);

    Page<RencanaEntity> findByPaging(Pageable pageable, String key);

    RencanaEntity save(RencanaEntity rencanaEntity);

    Optional<RencanaEntity> getById(Long id);

    RencanaEntity update(RencanaEntity rencanaEntity);

    RencanaEntity delete(Long id);
}