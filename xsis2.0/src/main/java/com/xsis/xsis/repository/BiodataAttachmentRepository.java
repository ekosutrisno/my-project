package com.xsis.xsis.repository.vacancy_pendidikan_resourceproject;

import java.util.Optional;

import com.xsis.xsis.dto.vacancy_pendidikan_resourceproject.BioAttchDto;
import com.xsis.xsis.model.vacancy_pendidikan_resourceproject.BiodataAttch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * BiodataAttachmentRepository
 */
public interface BiodataAttachmentRepository extends JpaRepository <BiodataAttch, Long>{

    @Query(nativeQuery = true)
    Optional<BioAttchDto> getBiodataAttachment(Long biodataId);
}