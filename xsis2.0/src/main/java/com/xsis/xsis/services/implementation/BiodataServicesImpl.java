package com.xsis.xsis.services.implementation;

import java.util.Optional;

import com.xsis.xsis.model.Biodata;
import com.xsis.xsis.repository.BiodataRepository;
import com.xsis.xsis.services.BiodataServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BiodataServicesImpl
 */
@Service
public class BiodataServicesImpl implements BiodataServices {

    @Autowired
    private BiodataRepository biodataRepository;

    @Override
    public Iterable<Biodata> getBiodata() {
        return biodataRepository.findAll();
    }

    @Override
    public Optional<Biodata> getBiodataById(Long id) {
        return biodataRepository.findById(id);
    }
}