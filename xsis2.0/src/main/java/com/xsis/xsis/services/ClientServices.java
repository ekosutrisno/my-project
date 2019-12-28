package com.xsis.xsis.services;

import com.xsis.xsis.dto.ClientEmployeeDto;
import com.xsis.xsis.model.Client;

/**
 * ClientServices
 */
public interface ClientServices {

    // Get List Data Client
    Iterable<Client> findAllClient();

    // Get List Data Client Join Employee
    Iterable<ClientEmployeeDto> getClientSelectOption();

}