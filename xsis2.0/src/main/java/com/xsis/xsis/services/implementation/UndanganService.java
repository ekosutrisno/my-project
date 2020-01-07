package com.xsis.xsis.services.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.UndanganEntity;
import com.xsis.xsis.repository.PagingUndanganRepository;
import com.xsis.xsis.repository.UndanganRepository;
import com.xsis.xsis.services.IUndanganService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

/**
 * UndanganService
 */
@Service
public class UndanganService implements IUndanganService {

    @Autowired
    private UndanganRepository undanganRepository;

    @Autowired
    private PagingUndanganRepository pagingRepository;

    @Override
    public Page<UndanganEntity> findByPaging(@PageableDefault(value = 10, sort = "id") Pageable pageable, String key) {

        return pagingRepository.finduUndanganByPaging(pageable, key);
    }

    @Override
    public UndanganEntity save(UndanganEntity undanganEntity) {
        undanganEntity.setCreatedBy(1L);
        undanganEntity.setCreatedOn(new Date());
        return undanganRepository.save(undanganEntity);
    }

    @Override
    public Optional<UndanganEntity> getById(Long id) {
        return undanganRepository.findById(id);
    }

    @Override
    public UndanganEntity update(UndanganEntity undanganEntity) {
        UndanganEntity undanganDetail = undanganRepository.findById(undanganEntity.getId()).get();

        undanganDetail.setId(undanganEntity.getId());
        undanganDetail.setInvitationCode(undanganEntity.getInvitationCode());
        undanganDetail.setInvitationDate(undanganEntity.getInvitationDate());
        undanganDetail.setScheduleTypeId(undanganEntity.getScheduleTypeId());
        undanganDetail.setTime(undanganEntity.getTime());
        undanganDetail.setOtherRoTro(undanganEntity.getOtherRoTro());
        undanganDetail.setLocation(undanganEntity.getLocation());
        undanganDetail.setRo(undanganEntity.getRo());
        undanganDetail.setTro(undanganEntity.getTro());
        undanganDetail.setStatus(undanganEntity.getStatus());

        undanganDetail.setModifiedBy(1L);
        undanganDetail.setModifiedOn(new Date());
        return undanganRepository.save(undanganDetail);
    }

    @Override
    public UndanganEntity delete(Long id) {
        UndanganEntity undangan = undanganRepository.findById(id).get();
        undangan.setIsDelete(true);
        undangan.setDeletedBy(1L);
        undangan.setDeleteddOn(new Date());
        return undanganRepository.save(undangan);
    }

    @Override
    public List<UndanganEntity> searchDataByName(String name) {
        return undanganRepository.searchDataByName(name);
    }

    @Override
    public List<UndanganEntity> getDescendings() {
        return undanganRepository.getUndanganDesc();
    }

}