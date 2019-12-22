package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.MaritalStatusEntity;

/**
 * IMaritalService
 */
public interface IMaritalService {

    List<MaritalStatusEntity> getAll();

    MaritalStatusEntity save(MaritalStatusEntity maritalStatusEntity);

    Optional<MaritalStatusEntity> getById(Long id);

    MaritalStatusEntity update(MaritalStatusEntity maritalStatusEntity);

    MaritalStatusEntity delete(Long id);
}