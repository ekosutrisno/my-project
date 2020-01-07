package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.BiodataView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 * IBiodataViewService
 */
public interface IBiodataViewService {

  List<BiodataView> getAll();

  Optional<BiodataView> getById(Long id);

  Page<BiodataView> getPagingView(Pageable pageable, String key);

  List<BiodataView> searchDataByName(@Param("name") String name);

}