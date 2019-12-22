package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.ReligionEntity;
import com.xsis.xsis.repository.ReligionRepository;
import com.xsis.xsis.services.IReligionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ReligionService
 */
@Service
public class ReligionService implements IReligionService {
    @Autowired
    private ReligionRepository religionRepository;

    @Override
    public List<ReligionEntity> getAll() {
        List<ReligionEntity> religion = new ArrayList<>();
        for (ReligionEntity religions : religionRepository.findAll()) {
            if (!religions.getIsDelete()) {
                religion.add(religions);
            }
        }
        return religion;
    }

    @Override
    public ReligionEntity save(ReligionEntity religionEntity) {
        religionEntity.setCreatedBy(1L);
        religionEntity.setCreatedOn(new Date());
        return religionRepository.save(religionEntity);
    }

    @Override
    public Optional<ReligionEntity> getById(Long id) {
        return religionRepository.findById(id);
    }

    @Override
    public ReligionEntity update(ReligionEntity religionEntity) {
        ReligionEntity religionDetail = religionRepository.findById(religionEntity.getId()).get();

        religionDetail.setName(religionEntity.getName());
        religionDetail.setDescription(religionEntity.getDescription());

        religionDetail.setModifiedBy(1L);
        religionDetail.setModifiedOn(new Date());
        return religionRepository.save(religionDetail);
    }

    @Override
    public ReligionEntity delete(Long id) {
        ReligionEntity religion = religionRepository.findById(id).get();
        religion.setIsDelete(true);
        religion.setDeletedBy(1L);
        religion.setDeleteddOn(new Date());
        return religionRepository.save(religion);
    }

}