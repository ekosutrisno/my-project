package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RencanaController
 */
@Controller
@RequestMapping("/undangan")
public class UndanganController {

  @GetMapping("/")
  public String viewUndanganAPI() {
    return "pages/undangan";
  }
}