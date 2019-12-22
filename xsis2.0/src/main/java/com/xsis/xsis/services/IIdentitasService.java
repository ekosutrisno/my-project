package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.IdentitasTypeEntity;

/**
 * IIdentitasService
 */
public interface IIdentitasService {

    List<IdentitasTypeEntity> getAll();

    IdentitasTypeEntity save(IdentitasTypeEntity identitasTypeEntity);

    Optional<IdentitasTypeEntity> getById(Long id);

    IdentitasTypeEntity update(IdentitasTypeEntity identitasTypeEntity);

    IdentitasTypeEntity delete(Long id);
}