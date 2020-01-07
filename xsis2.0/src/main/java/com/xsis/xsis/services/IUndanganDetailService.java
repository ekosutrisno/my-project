package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.UndanganDetailEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 * IUndanganDetailService
 */
public interface IUndanganDetailService {

    List<UndanganDetailEntity> getAll();

    Page<UndanganDetailEntity> findByPaging(Pageable pageable, String key);

    List<UndanganDetailEntity> getDetailByUndanganId(Long id);

    UndanganDetailEntity save(UndanganDetailEntity undanganDetailEntity);

    Optional<UndanganDetailEntity> getById(Long id);

    UndanganDetailEntity update(UndanganDetailEntity undanganDetailEntity);

    UndanganDetailEntity delete(Long id);

    List<UndanganDetailEntity> searchDataByName(@Param("name") String name);

}