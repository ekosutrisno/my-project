package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * VacancyController
 */
@Controller
@RequestMapping("/vacancy")
public class VacancyController {

    @GetMapping("/show")
    public String showVacancy(Model model) {
        return "pages/show_vacancy";
    }

    @GetMapping("/vac")
    public String showVacancyBackup(Model model) {
        return "pages/vacancy";
    }
}