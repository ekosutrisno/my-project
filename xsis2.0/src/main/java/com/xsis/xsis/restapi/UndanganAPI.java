package com.xsis.xsis.restapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UndanganAPI
 */
@RestController
@RequestMapping(path = "api/undangan", consumes = "application/json")
@CrossOrigin(origins = "*")
public class UndanganAPI {

}