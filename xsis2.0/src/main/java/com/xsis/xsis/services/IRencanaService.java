package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;
import com.xsis.xsis.models.entity.RencanaEntity;

/**
 * IRencanaService
 */
public interface IRencanaService {

    List<RencanaEntity> getAll();

    RencanaEntity save(RencanaEntity rencanaEntity);

    Optional<RencanaEntity> getById(Long id);

    RencanaEntity update(RencanaEntity rencanaEntity);

    RencanaEntity delete(Long id);
}