package com.xsis.xsis.restapi;

import java.util.ArrayList;
import java.util.List;

import com.xsis.xsis.model.Client;
import com.xsis.xsis.services.ClientServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientAPI
 */
@RestController
@RequestMapping(path = "/api/client", produces = "application/json")
@CrossOrigin(origins = "*")
public class ClientAPI {

    @Autowired
    private ClientServices clientServices;

    @GetMapping
    public Iterable<Client> showAllClient() {
        List<Client> client = new ArrayList<>();
        for (Client clients : clientServices.findAllClient()) {
            if (!clients.getIsDelete()) {
                client.add(clients);
            }
        }
        return client;
    }

    @GetMapping("/employee")
    public ResponseEntity<?> showAllClientEmployee() {
        return new ResponseEntity<>(clientServices.getClientSelectOption(), HttpStatus.OK);
    }

}