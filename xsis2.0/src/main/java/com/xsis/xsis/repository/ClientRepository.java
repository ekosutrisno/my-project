package com.xsis.xsis.repository;

import com.xsis.xsis.dto.ClientEmployeeDto;
import com.xsis.xsis.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * ClientRepository
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(nativeQuery = true)
    Iterable<ClientEmployeeDto> getClientSelectOption();

}