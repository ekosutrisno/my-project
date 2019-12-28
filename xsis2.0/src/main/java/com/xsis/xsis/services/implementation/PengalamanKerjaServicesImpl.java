package com.xsis.xsis.services.implementation;

import java.util.List;

import com.xsis.xsis.dto.PeKerDto;
import com.xsis.xsis.repository.PengalamanKerjaRepository;
import com.xsis.xsis.services.PengalamanKerjaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PengalamanKerjaServicesImpl
 */
@Service
public class PengalamanKerjaServicesImpl implements PengalamanKerjaServices {

    @Autowired
    private PengalamanKerjaRepository pengalamanKerjaRepository;

    @Override
    public List<PeKerDto> getPengalamanKerjaBiodata(Long biodataId) {
        return pengalamanKerjaRepository.getPengalamanKerjaBiodata(biodataId);
    }
}