package com.xsis.xsis.restapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeAPI
 */
@RestController
@RequestMapping(path = "/api/employee", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeAPI {

}