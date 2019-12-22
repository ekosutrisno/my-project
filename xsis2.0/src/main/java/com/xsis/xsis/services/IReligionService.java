package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.ReligionEntity;

/**
 * IReligionService
 */
public interface IReligionService {
    List<ReligionEntity> getAll();

    ReligionEntity save(ReligionEntity biodataEntity);

    Optional<ReligionEntity> getById(Long id);

    ReligionEntity update(ReligionEntity biodataEntity);

    ReligionEntity delete(Long id);
}