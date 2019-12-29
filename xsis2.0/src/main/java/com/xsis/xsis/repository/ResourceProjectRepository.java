package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.dto.ResourceProDto;
import com.xsis.xsis.model.ResourceProject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * ResourceProjectRepository
 */
public interface ResourceProjectRepository extends PagingAndSortingRepository<ResourceProject, Long> {

    @Query(nativeQuery = true)
    Page<ResourceProDto> getPagingResourceProjectClientEmployee(Pageable pageable);

    // @Query(nativeQuery = true)
    // Page<ResourceProDto> getPagingResourceProjectClientEmployee(Pageable
    // pageable, String key);

    @Query(nativeQuery = true)
    List<ResourceProDto> getResourceProjectClientEmployee();

    @Query(nativeQuery = true)
    Iterable<ResourceProDto> getResourceProjectClientEmployeeAscending();

    @Query(nativeQuery = true)
    Iterable<ResourceProDto> getResourceProjectClientEmployeeDescending();

    @Query(nativeQuery = true)
    List<ResourceProDto> searchDateResourceProject(@Param("sp") String startProject, @Param("ep") String endProject);

    @Query(nativeQuery = true)
    List<ResourceProDto> searchNameClientResourceProject(@Param("name_client") String name);

    @Query(nativeQuery = true)
    Page<ResourceProDto> getResourceProjectClientEmployeePandS(Pageable pageable);
}