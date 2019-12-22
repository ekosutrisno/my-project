package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BiodataController
 */
@Controller
@RequestMapping("/biodata")
public class BiodataController {

    @GetMapping("/")
    public String viewBiodataAPI() {
        return "pages/biodata";
    }

    @GetMapping("/identitas")
    public String viewIdentitasAPI() {
        return "pages/identitas";
    }

    @GetMapping("/marital")
    public String viewMaritalAPI() {
        return "pages/marital";
    }

    @GetMapping("/religion")
    public String viewReligionAPI() {
        return "pages/religion";
    }

    @GetMapping("/address")
    public String viewAddressAPI() {
        return "pages/address";
    }
}