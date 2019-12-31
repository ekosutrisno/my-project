package com.xsis.xsis.services;

import java.util.Optional;

import com.xsis.xsis.models.entity.UndanganEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * IUndanganService
 */
public interface IUndanganService {
    Page<UndanganEntity> findByPaging(Pageable pageable, String key);

    UndanganEntity save(UndanganEntity undanganEntity);

    Optional<UndanganEntity> getById(Long id);

    UndanganEntity update(UndanganEntity undanganEntity);

    UndanganEntity delete(Long id);
}