package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ResourceProjectController
 */
@Controller
@RequestMapping("/resource-project")
public class ResourceProjectController {

    @GetMapping("/")
    public String showResourceProject(Model model) {
        return "pages/resource_project";
    }
    
}