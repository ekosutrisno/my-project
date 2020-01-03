package com.xsis.xsis.restapi.vacancy_pendidikan_resourceproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.vacancy_pendidikan_resourceproject.ResourceProDto;
import com.xsis.xsis.model.vacancy_pendidikan_resourceproject.ResourceProject;
import com.xsis.xsis.services.vacancy_pendidikan_resourceproject.ResourceProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * ResourceProjectAPI
 */
@RestController
@RequestMapping(path = "/api/resource-project", produces = "application/json")
@CrossOrigin(origins = "*")
public class ResourceProjectAPI {

    @Autowired
    private ResourceProjectService resourceProjectService;

    @GetMapping
    public Iterable<ResourceProject> findAllEducationVacancy() {
        List<ResourceProject> resourceproject = new ArrayList<>();
        for (ResourceProject resourceprojects : resourceProjectService.getResourceProject()) {
            if (!resourceprojects.getIsDelete()) {
                resourceproject.add(resourceprojects);
            }
        }
        return resourceproject;
    }

    @GetMapping("/ascending")
    public ResponseEntity<?> findResourceProjectClientEmployeeAscending() {
        return new ResponseEntity<>(resourceProjectService.getResourceProjectClientEmployeeAscending(), HttpStatus.OK);
    }

    @GetMapping("/descending")
    public ResponseEntity<?> findResourceProjectClientEmployeeDescending() {
        return new ResponseEntity<>(resourceProjectService.getResourceProjectClientEmployeeDescending(), HttpStatus.OK);
    }

    @GetMapping("/client-employee")
    public ResponseEntity<?> findResourceProjectClientEmployee() {
        return new ResponseEntity<>(resourceProjectService.getResourceProjectClientEmployee(), HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<Iterable<ResourceProDto>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "2 ") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
        Iterable<ResourceProDto> list = resourceProjectService.getPagingResourceProjectClientEmployee(pageNo, pageSize,
                sortBy);

        return new ResponseEntity<Iterable<ResourceProDto>>(list, HttpStatus.OK);
    }

    // @GetMapping("/paging")
    // public Page<ResourceProDto> findByPaging(Pageable pageable,
    // @RequestParam(name = "key", defaultValue = "") String key) {
    // return
    // resourceProjectService.getPagingResourceProjectClientEmployee(pageable, key);
    // }

    // @GetMapping("/order")
    // public ResponseEntity<?> findAllResourceProjectByPage(@RequestParam Integer
    // pageNo,
    // @RequestParam Integer pageSize) {
    // return new
    // ResponseEntity<>(resourceProjectService.findAllResourceProjectPandS(pageNo,
    // pageSize),
    // HttpStatus.OK);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<?> brandById(@PathVariable("id") Long id) {
        Optional<ResourceProject> optResourceProject = resourceProjectService.getResourceProjectById(id);
        if (optResourceProject.isPresent()) {
            return new ResponseEntity<>(optResourceProject.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search2")
    public List<ResourceProDto> searchDateResourceProject(@RequestParam(name = "sp") String startProject,
            @RequestParam(name = "ep") String endProject) {
        return resourceProjectService.getResultSearcDateResourceProject(startProject, endProject);
    }

    @GetMapping("/search1")
    public List<ResourceProDto> searchNameClientResourceProject(@RequestParam(name = "name_client") String name) {
        return resourceProjectService.getResultSearcNameClientResourceProject(name);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResourceProject postBrand(@RequestBody ResourceProject resourceProject) {
        resourceProject.setCreatedBy(1L);
        resourceProject.setCreatedOn(new Date());
        resourceProject.setIsDelete(false);
        return resourceProjectService.saveResourceProject(resourceProject);
    }

    @DeleteMapping("/{id}")
    public ResourceProject deleteEducationVacancy(@PathVariable(value = "id") Long id) {
        ResourceProject rp = resourceProjectService.getResourceProjectById(id).get();
        rp.setIsDelete(true);
        rp.setDeletedBy(1L);
        rp.setDeleteddOn(new Date());
        return resourceProjectService.saveResourceProject(rp);
    }

    @PutMapping(path = "/{id}")
    public ResourceProject putEducationVacancy(@RequestBody ResourceProject resourceProject) {
        ResourceProject resourceProjectDetail = resourceProjectService.getResourceProjectById(resourceProject.getId())
                .get();
        resourceProjectDetail.setModifiedBy(1L);
        resourceProjectDetail.setModifiedOn(new Date());
        resourceProjectDetail.setId(resourceProject.getId());
        resourceProjectDetail.setClientId(resourceProject.getClientId());
        resourceProjectDetail.setLocation(resourceProject.getLocation());
        resourceProjectDetail.setDepartment(resourceProject.getDepartment());
        resourceProjectDetail.setPicName(resourceProject.getPicName());
        resourceProjectDetail.setProjectName(resourceProject.getProjectName());
        resourceProjectDetail.setStartProject(resourceProject.getStartProject());
        resourceProjectDetail.setEndProject(resourceProject.getEndProject());
        resourceProjectDetail.setProjectRole(resourceProject.getProjectRole());
        resourceProjectDetail.setProjectPhase(resourceProject.getProjectPhase());
        resourceProjectDetail.setProjectDescription(resourceProject.getProjectDescription());
        resourceProjectDetail.setProjectTechnology(resourceProject.getProjectTechnology());
        resourceProjectDetail.setMainTask(resourceProject.getMainTask());
        return resourceProjectService.saveResourceProject(resourceProjectDetail);
    }

}