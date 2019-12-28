package com.xsis.xsis.services;

import java.util.Optional;

import com.xsis.xsis.model.Biodata;

import org.springframework.data.repository.query.Param;

/**
 * BiodataServices
 */
public interface BiodataServices {

    //Get Data Biodata
    Iterable<Biodata> getBiodata();

    //Get Data Biodata Detail
    Optional<Biodata> getBiodataById(@Param("id") Long id);
}