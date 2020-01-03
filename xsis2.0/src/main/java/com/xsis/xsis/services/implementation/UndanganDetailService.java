package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.UndanganDetailEntity;
import com.xsis.xsis.repository.PagingUndanganDetailRepository;
import com.xsis.xsis.repository.UndanganDetailRepository;
import com.xsis.xsis.services.IUndanganDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

/**
 * UndanganDetailService
 */
@Service
public class UndanganDetailService implements IUndanganDetailService {

    @Autowired
    private UndanganDetailRepository undanganDetailRepository;

    @Autowired
    private PagingUndanganDetailRepository undanganDetailPage;

    @Override
    public List<UndanganDetailEntity> getAll() {
        List<UndanganDetailEntity> detailEntity = new ArrayList<>();
        for (UndanganDetailEntity detailEntities : undanganDetailRepository.findAll()) {
            if (!detailEntities.getIsDelete()) {
                detailEntity.add(detailEntities);
            }
        }
        return detailEntity;
    }

    @Override
    public Page<UndanganDetailEntity> findByPaging(@PageableDefault(value = 10, sort = "id") Pageable pageable,
            String key) {

        return undanganDetailPage.findByPaging(pageable, key);
    }

    @Override
    public UndanganDetailEntity save(UndanganDetailEntity undanganDetailEntity) {

        undanganDetailEntity.setCreatedBy(1L);
        undanganDetailEntity.setCreatedOn(new Date());
        return undanganDetailRepository.save(undanganDetailEntity);
    }

    @Override
    public Optional<UndanganDetailEntity> getById(Long id) {
        return undanganDetailRepository.findById(id);
    }

    @Override
    public UndanganDetailEntity update(UndanganDetailEntity undanganDetailEntity) {
        UndanganDetailEntity undanganDetail = undanganDetailRepository.findById(undanganDetailEntity.getId()).get();
        undanganDetail.setId(undanganDetailEntity.getId());
        undanganDetail.setBiodataId(undanganDetailEntity.getBiodataId());
        undanganDetail.setUndanganId(undanganDetailEntity.getUndanganId());
        undanganDetail.setNotes(undanganDetailEntity.getNotes());

        undanganDetail.setModifiedBy(2L);
        undanganDetail.setModifiedOn(new Date());

        return undanganDetailRepository.save(undanganDetail);
    }

    @Override
    public UndanganDetailEntity delete(Long id) {
        UndanganDetailEntity undangan = undanganDetailRepository.findById(id).get();
        undangan.setIsDelete(true);
        undangan.setDeletedBy(3L);
        undangan.setDeleteddOn(new Date());
        return undanganDetailRepository.save(undangan);
    }

    @Override
    public List<UndanganDetailEntity> searchDataByName(String name) {
        return undanganDetailRepository.searchDataByName(name);
    }

}