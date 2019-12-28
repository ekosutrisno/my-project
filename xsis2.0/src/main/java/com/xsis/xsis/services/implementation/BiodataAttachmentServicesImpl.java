package com.xsis.xsis.services.implementation;

import java.util.Optional;

import com.xsis.xsis.dto.BioAttchDto;
import com.xsis.xsis.repository.BiodataAttachmentRepository;
import com.xsis.xsis.services.BiodataAttachmentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BiodataAttachmentServicesImpl
 */
@Service
public class BiodataAttachmentServicesImpl implements BiodataAttachmentServices {

    @Autowired
    private BiodataAttachmentRepository biodataAttachmentRepository;

    @Override
    public Optional<BioAttchDto> getBiodataAttachment(Long biodataId) {
        return biodataAttachmentRepository.getBiodataAttachment(biodataId);
    }
    
}