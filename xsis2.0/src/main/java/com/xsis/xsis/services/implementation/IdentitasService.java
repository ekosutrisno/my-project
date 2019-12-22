package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.IdentitasTypeEntity;
import com.xsis.xsis.repository.IdentitasRepository;
import com.xsis.xsis.services.IIdentitasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * IdentitasService
 */
@Service
public class IdentitasService implements IIdentitasService {
    @Autowired
    private IdentitasRepository identitasRepository;

    @Override
    public List<IdentitasTypeEntity> getAll() {
        List<IdentitasTypeEntity> identitas = new ArrayList<>();
        for (IdentitasTypeEntity identitass : identitasRepository.findAll()) {
            if (!identitass.getIsDelete()) {
                identitas.add(identitass);
            }
        }
        return identitas;
    }

    @Override
    public IdentitasTypeEntity save(IdentitasTypeEntity identitasTypeEntity) {
        identitasTypeEntity.setCreatedBy(1L);
        identitasTypeEntity.setCreatedOn(new Date());
        return identitasRepository.save(identitasTypeEntity);
    }

    @Override
    public Optional<IdentitasTypeEntity> getById(Long id) {
        return identitasRepository.findById(id);
    }

    @Override
    public IdentitasTypeEntity update(IdentitasTypeEntity identitasTypeEntity) {
        IdentitasTypeEntity maritalDetail = identitasRepository.findById(identitasTypeEntity.getId()).get();

        maritalDetail.setName(identitasTypeEntity.getName());
        maritalDetail.setDescription(identitasTypeEntity.getDescription());

        maritalDetail.setModifiedBy(1L);
        maritalDetail.setModifiedOn(new Date());
        return identitasRepository.save(maritalDetail);
    }

    @Override
    public IdentitasTypeEntity delete(Long id) {
        IdentitasTypeEntity identitasTypeEntity = identitasRepository.findById(id).get();
        identitasTypeEntity.setIsDelete(true);
        identitasTypeEntity.setDeletedBy(1L);
        identitasTypeEntity.setDeleteddOn(new Date());
        return identitasRepository.save(identitasTypeEntity);
    }

}