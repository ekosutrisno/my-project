package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RencanaController
 */
@Controller
@RequestMapping("/rencana")
public class RencanaController {

    @GetMapping("/")
    public String viewRencanaAPI() {
        return "pages/rencana";
    }
}