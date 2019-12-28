package com.xsis.xsis.services.implementation;

import java.util.List;

import com.xsis.xsis.dto.SertDto;
import com.xsis.xsis.repository.SertifikasiRepository;
import com.xsis.xsis.services.SertifikasiServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SertifikasiServicesImpl
 */
@Service
public class SertifikasiServicesImpl implements SertifikasiServices {

    @Autowired
    private SertifikasiRepository sertifikasiRepository;

    @Override
    public List<SertDto> getSertifikasiBiodata(Long biodataId) {
        return sertifikasiRepository.getSertifikasiBiodata(biodataId);
    }
    
}