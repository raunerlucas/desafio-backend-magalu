package com.programin.rauner.magaludesafio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/")
    public String swaggerUi() {
        return "redirect:/swagger-ui/index.html";
    }
}
