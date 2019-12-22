package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.MaritalStatusEntity;
import com.xsis.xsis.repository.MaritalRepository;
import com.xsis.xsis.services.IMaritalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MaritalService
 */
@Service
public class MaritalService implements IMaritalService {
    @Autowired
    private MaritalRepository maritalRepository;

    @Override
    public List<MaritalStatusEntity> getAll() {
        List<MaritalStatusEntity> marital = new ArrayList<>();
        for (MaritalStatusEntity maritals : maritalRepository.findAll()) {
            if (!maritals.getIsDelete()) {
                marital.add(maritals);
            }
        }
        return marital;
    }

    @Override
    public MaritalStatusEntity save(MaritalStatusEntity maritalStatusEntity) {
        maritalStatusEntity.setCreatedBy(1L);
        maritalStatusEntity.setCreatedOn(new Date());
        return maritalRepository.save(maritalStatusEntity);
    }

    @Override
    public Optional<MaritalStatusEntity> getById(Long id) {
        return maritalRepository.findById(id);
    }

    @Override
    public MaritalStatusEntity update(MaritalStatusEntity maritalStatusEntity) {
        MaritalStatusEntity maritalDetail = maritalRepository.findById(maritalStatusEntity.getId()).get();

        maritalDetail.setName(maritalStatusEntity.getName());
        maritalDetail.setDescription(maritalStatusEntity.getDescription());

        maritalDetail.setModifiedBy(1L);
        maritalDetail.setModifiedOn(new Date());
        return maritalRepository.save(maritalDetail);
    }

    @Override
    public MaritalStatusEntity delete(Long id) {
        MaritalStatusEntity maritalStatusEntity = maritalRepository.findById(id).get();
        maritalStatusEntity.setIsDelete(true);
        maritalStatusEntity.setDeletedBy(1L);
        maritalStatusEntity.setDeleteddOn(new Date());
        return maritalRepository.save(maritalStatusEntity);
    }

}