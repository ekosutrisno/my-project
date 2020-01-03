package com.xsis.xsis.repository.vacancy_pendidikan_resourceproject;

import com.xsis.xsis.dto.vacancy_pendidikan_resourceproject.ClientEmployeeDto;
import com.xsis.xsis.model.vacancy_pendidikan_resourceproject.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * ClientRepository
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(nativeQuery = true)
    Iterable<ClientEmployeeDto> getClientSelectOption();

}