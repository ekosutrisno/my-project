package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.UndanganView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 * IViewService
 */
public interface IViewService {
    List<UndanganView> getAll();

    Optional<UndanganView> getById(Long id);

    Page<UndanganView> getPagingView(Pageable pageable, String key);

    List<UndanganView> searchDataByName(@Param("name") String name);
}