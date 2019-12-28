package com.xsis.xsis.services;

import java.util.List;

import com.xsis.xsis.dto.SertDto;

/**
 * SertifikasiServices
 */
public interface SertifikasiServices {

    List<SertDto> getSertifikasiBiodata(Long biodataId);

}