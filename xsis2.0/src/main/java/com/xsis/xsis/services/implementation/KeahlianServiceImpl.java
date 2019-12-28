package com.xsis.xsis.services.implementation;

import java.util.List;

import com.xsis.xsis.dto.KeahDto;
import com.xsis.xsis.repository.KeahlianRepository;
import com.xsis.xsis.services.KeahlianService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * KeahlianServiceImpl
 */
@Service
public class KeahlianServiceImpl implements KeahlianService {

    @Autowired
    private KeahlianRepository keahlianRepository;

    @Override
    public List<KeahDto> getKeahlianBiodata(Long biodataId) {
        return keahlianRepository.getKeahlianBiodata(biodataId);
    }

    
}