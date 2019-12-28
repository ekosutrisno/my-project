package com.xsis.xsis.services.implementation;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.ResourceProDto;
import com.xsis.xsis.model.ResourceProject;
import com.xsis.xsis.repository.ResourceProjectRepository;
import com.xsis.xsis.services.ResourceProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ResourceProjectServiceImpl
 */
@Service
public class ResourceProjectServiceImpl implements ResourceProjectService {

    @Autowired
    private ResourceProjectRepository resourceProjectRepository;

    @Override
    public ResourceProject saveResourceProject(ResourceProject resourceProject) {
        return resourceProjectRepository.save(resourceProject);
    }

    @Override
    public Iterable<ResourceProDto> getResourceProjectClientEmployee() {
        return resourceProjectRepository.getResourceProjectClientEmployee();
    }

    @Override
    public Iterable<ResourceProject> getResourceProject() {
        return resourceProjectRepository.findAll();
    }

    @Override
    public Optional<ResourceProject> getResourceProjectById(Long id) {
        return resourceProjectRepository.findById(id);
    }

    @Override
    public Iterable<ResourceProDto> getResourceProjectClientEmployeeAscending() {
        return resourceProjectRepository.getResourceProjectClientEmployeeAscending();
    }

    @Override
    public Iterable<ResourceProDto> getResourceProjectClientEmployeeDescending() {
        return resourceProjectRepository.getResourceProjectClientEmployeeDescending();
    }

    @Override
    public List<ResourceProDto> getResultSearcDateResourceProject(String startProject, String endProject) {
        return resourceProjectRepository.searchDateResourceProject(startProject, endProject);
    }

    @Override
    public Iterable<ResourceProDto> findAllResourceProjectPandS(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<ResourceProDto> pagedResult = resourceProjectRepository.getResourceProjectClientEmployeePandS(paging);

        return pagedResult.getContent();
    }

    @Override
    public List<ResourceProDto> getResultSearcNameClientResourceProject(String name) {
        return resourceProjectRepository.searchNameClientResourceProject(name);
    }

}