package com.xsis.xsis.services.implementation;

import com.xsis.xsis.dto.ClientEmployeeDto;
import com.xsis.xsis.model.Client;
import com.xsis.xsis.repository.ClientRepository;
import com.xsis.xsis.services.ClientServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClientServicesImpl
 */
@Service
public class ClientServicesImpl implements ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Iterable<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Iterable<ClientEmployeeDto> getClientSelectOption() {
        return clientRepository.getClientSelectOption();
    }

}