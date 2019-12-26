package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.RencanaEntity;
import com.xsis.xsis.repository.RencanaRepository;
import com.xsis.xsis.services.IRencanaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RencanaService
 */
@Service
public class RencanaService implements IRencanaService {

    @Autowired
    private RencanaRepository rencanaRepository;

    public List<RencanaEntity> getAll() {
        List<RencanaEntity> rencana = new ArrayList<>();
        for (RencanaEntity rencanas : rencanaRepository.getRencanaAsc()) {
            if (!rencanas.getIsDelete()) {
                rencana.add(rencanas);
            }
        }
        return rencana;
    }

    @Override
    public List<RencanaEntity> searchData(String tgl_mulai, String tgl_sampai) {
        return rencanaRepository.searchData(tgl_mulai, tgl_sampai);
    }

    @Override
    public RencanaEntity save(RencanaEntity rencanaEntity) {
        rencanaEntity.setCreatedBy(1L);
        rencanaEntity.setCreatedOn(new Date());
        return rencanaRepository.save(rencanaEntity);
    }

    @Override
    public Optional<RencanaEntity> getById(Long id) {
        return rencanaRepository.findById(id);
    }

    @Override
    public RencanaEntity update(RencanaEntity rencanaEntity) {
        RencanaEntity rencanaDetail = rencanaRepository.findById(rencanaEntity.getId()).get();

        rencanaDetail.setId(rencanaEntity.getId());
        rencanaDetail.setScheduleCode(rencanaEntity.getScheduleCode());
        rencanaDetail.setScheduleDate(rencanaEntity.getScheduleDate());
        rencanaDetail.setTime(rencanaEntity.getTime());
        rencanaDetail.setTime(rencanaEntity.getTime());
        rencanaDetail.setRo(rencanaEntity.getRo());
        rencanaDetail.setTro(rencanaEntity.getTro());
        rencanaDetail.setScheduleTypeId(rencanaEntity.getScheduleTypeId());
        rencanaDetail.setLocation(rencanaEntity.getLocation());
        rencanaDetail.setOtherRoTro(rencanaEntity.getOtherRoTro());
        rencanaDetail.setNotes(rencanaEntity.getNotes());
        rencanaDetail.setSentDate(rencanaEntity.getSentDate());

        rencanaDetail.setAutomaticMail(false);

        rencanaDetail.setModifiedBy(1L);
        rencanaDetail.setModifiedOn(new Date());
        return rencanaRepository.save(rencanaDetail);
    }

    @Override
    public RencanaEntity delete(Long id) {
        RencanaEntity rencana = rencanaRepository.findById(id).get();
        rencana.setIsDelete(true);
        rencana.setDeletedBy(1L);
        rencana.setDeleteddOn(new Date());
        return rencanaRepository.save(rencana);
    }

}