package br.edu.unoesc.desafio_2025_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String exibirHome() {
        return "home";
    }
}
