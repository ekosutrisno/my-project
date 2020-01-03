package com.xsis.xsis.services;

import java.util.List;

import com.xsis.xsis.models.entity.UndanganView;

import org.springframework.data.repository.query.Param;

/**
 * IViewService
 */
public interface IViewService {
    List<UndanganView> getAll();

    List<UndanganView> searchDataByName(@Param("name") String name);
}