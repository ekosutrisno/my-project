package com.xsis.xsis.restapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.Education;
import com.xsis.xsis.services.EducationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * PendidikanAPI
 */
@RestController
@RequestMapping(path = "/api/education", produces = "application/json")
@CrossOrigin(origins = "*")
public class EducationAPI {

    @Autowired
    private EducationServices educationServices;

    @GetMapping
    public Iterable<Education> findAllEducationVacancy() {
        List<Education> education = new ArrayList<>();
        for (Education educations : educationServices.findAllEducation()) {
            if (!educations.getIsDelete()) {
                education.add(educations);
            }
        }
        return education;

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> brandById(@PathVariable("id") Long id) {
        Optional<Education> optPendidikan = educationServices.getEducationById(id);
        if (optPendidikan.isPresent()) {
            return new ResponseEntity<>(optPendidikan.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Education postBrand(@RequestBody Education education) {
        education.setCreatedBy(1L);
        education.setCreatedOn(new Date());
        education.setIsDelete(false);
        education.setOrders(1);
        return educationServices.saveEducation(education);
    }

    @PutMapping(path = "/{id}")
    public Education putEducationVacancy(@RequestBody Education education) {
        Education educationDetail = educationServices.getEducationById(education.getId()).get();
        educationDetail.setModifiedBy(1L);
        educationDetail.setModifiedOn(new Date());  
        educationDetail.setIsDelete(false);
        educationDetail.setId(education.getId());
        educationDetail.setBiodataId(education.getBiodataId());
        educationDetail.setSchoolName(education.getSchoolName());
        educationDetail.setCity(education.getCity());
        educationDetail.setCountry(education.getCountry());
        educationDetail.setEducationLevelId(education.getEducationLevelId());
        educationDetail.setEntryYear(education.getEntryYear());
        educationDetail.setGraduationYear(education.getGraduationYear());
        educationDetail.setMajor(education.getMajor());
        educationDetail.setGpa(education.getGpa());
        educationDetail.setNotes(education.getNotes());
        educationDetail.setOrders(education.getOrders());
        educationDetail.setJudulTa(education.getJudulTa());
        educationDetail.setDeskripsiTa(education.getDeskripsiTa());
        return educationServices.saveEducation(education);
    }

    @DeleteMapping("/{id}")
    public Education deleteEducationVacancy(@PathVariable(value = "id") Long id) {
        Education edu = educationServices.getEducationById(id).get();
        edu.setIsDelete(true);
        edu.setDeletedBy(1L);
        edu.setDeleteddOn(new Date());
        return educationServices.saveEducation(edu);
    }

    //Join with Education Level
    @GetMapping("/level/{biodata_id}")
    public ResponseEntity<?> findCategoryBrand(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(educationServices.getEduName(biodataId), HttpStatus.OK);
    }

    @GetMapping("/level/{biodata_id}/{id}")
    public ResponseEntity<?> findCategoryBrand(@PathVariable("biodata_id") Long biodataId, @PathVariable("id") Long id) {
        return new ResponseEntity<>(educationServices.getEduNameDetail(biodataId, id), HttpStatus.OK);
    }
   
    

}