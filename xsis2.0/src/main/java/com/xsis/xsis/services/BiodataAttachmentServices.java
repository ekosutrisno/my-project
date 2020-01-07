package com.xsis.xsis.services;

import java.util.Optional;

import com.xsis.xsis.dto.BioAttchDto;

/**
 * BiodataAttachmentServices
 */
public interface BiodataAttachmentServices {

    Optional<BioAttchDto> getBiodataAttachment(Long biodataId);
}