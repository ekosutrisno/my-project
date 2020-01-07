package com.xsis.xsis.repository;

import java.util.Optional;

import com.xsis.xsis.dto.BioAttchDto;
import com.xsis.xsis.model.BiodataAttch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * BiodataAttachmentRepository
 */
public interface BiodataAttachmentRepository extends JpaRepository<BiodataAttch, Long> {

    @Query(nativeQuery = true)
    Optional<BioAttchDto> getBiodataAttachment(Long biodataId);
}