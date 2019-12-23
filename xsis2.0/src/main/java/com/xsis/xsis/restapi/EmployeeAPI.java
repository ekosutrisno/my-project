package com.xsis.xsis.restapi;

import com.xsis.xsis.services.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeAPI
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/employee")
public class EmployeeAPI {
    @Autowired
    private IEmployeeService employeeService;

}