package com.xsis.xsis.services.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xsis.xsis.model.entity.PengalamanKerja;
import com.xsis.xsis.repository.PengalamanKerjaRepository;
import com.xsis.xsis.services.PengalamanKerjaService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * PengalamanKerjaServiceImpl
 */
public class PengalamanKerjaServiceImpl implements PengalamanKerjaService {

    @Autowired
    private PengalamanKerjaRepository pengalamanKerjaRepository;

    @Override
    public PengalamanKerja getById(Long id) {
        return pengalamanKerjaRepository.findById(id).get();
    }

    @Override
    public List<PengalamanKerja> getAll() {
        List<PengalamanKerja> pengKerja = new ArrayList<>();
        for (PengalamanKerja pengKerjas : pengalamanKerjaRepository.findAll()) {
            if (!pengKerjas.getIsDelete()) {
                pengKerja.add(pengKerjas);
            }
        }
        return pengKerja;
    }

    @Override
    public PengalamanKerja save(PengalamanKerja pengalamanKerja) {
        pengalamanKerja.setCreatedBy(1L);
        pengalamanKerja.setCreatedOn(new Date());
        return pengalamanKerjaRepository.save(pengalamanKerja);
    }

    @Override
    public PengalamanKerja update(PengalamanKerja pengalamanKerja) {
        PengalamanKerja pengalaman = pengalamanKerjaRepository.findById(pengalamanKerja.getId()).get();
        pengalaman.setModifiedBy(1L);

        // common entity
        pengalaman.setModifiedBy(1L);
        pengalaman.setModifiedOn(new Date());

        // normal Entity
        pengalaman.setBiodataId(pengalamanKerja.getBiodataId());
        pengalaman.setCompanyName(pengalamanKerja.getCompanyName());
        pengalaman.setCity(pengalamanKerja.getCity());
        pengalaman.setCountry(pengalamanKerja.getCountry());
        pengalaman.setJoinYear(pengalamanKerja.getJoinYear());
        pengalaman.setJoinMonth(pengalamanKerja.getJoinMonth());
        pengalaman.setResignYear(pengalamanKerja.getResignYear());
        pengalaman.setResignMonth(pengalamanKerja.getResignMonth());
        pengalaman.setLastPosition(pengalamanKerja.getLastPosition());
        pengalaman.setIncome(pengalamanKerja.getIncome());
        pengalaman.setIsItRelated(pengalamanKerja.getIsItRelated());
        pengalaman.setAboutJob(pengalamanKerja.getAboutJob());
        pengalaman.setExitReason(pengalamanKerja.getExitReason());
        pengalaman.setAboutJob(pengalamanKerja.getAboutJob());
        pengalaman.setNotes(pengalamanKerja.getNotes());

        return pengalamanKerjaRepository.save(pengalaman);

    }

    @Override
    public PengalamanKerja delete(Long id) {
        PengalamanKerja pengalaman = pengalamanKerjaRepository.findById(id).get();
        pengalaman.setIsDelete(true);
        pengalaman.setDeletedBy(1L);
        pengalaman.setDeleteddOn(new Date());
        return pengalamanKerjaRepository.save(pengalaman);
    }

}