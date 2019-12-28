package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.ResourceProDto;
import com.xsis.xsis.model.ResourceProject;

import org.springframework.data.repository.query.Param;

/**
 * ResourceProjectService
 */
public interface ResourceProjectService {

    // Get Data Resource Project
    Iterable<ResourceProject> getResourceProject();

    // Get Data Resource Project Detail by Id
    Optional<ResourceProject> getResourceProjectById(Long id);

    // Post Data Resource Project
    ResourceProject saveResourceProject(ResourceProject resourceProject);

    // Get Data Resource Project Join Client Join Employee
    Iterable<ResourceProDto> getResourceProjectClientEmployee();

    // Get Data Resource Project Join Client Join Employee Ascending
    Iterable<ResourceProDto> getResourceProjectClientEmployeeAscending();

    // Get Data Resource Project Join Client Join Employee Descending
    Iterable<ResourceProDto> getResourceProjectClientEmployeeDescending();

    // Search Resource Project
    List<ResourceProDto> getResultSearcDateResourceProject(@Param("sp") String startProject,
            @Param("ep") String endProject);

    List<ResourceProDto> getResultSearcNameClientResourceProject(@Param("name_client") String name);

    // Paging & Sorting Resource Project Join Client Join Employee
    Iterable<ResourceProDto> findAllResourceProjectPandS(Integer pageNo, Integer pageSize);
}