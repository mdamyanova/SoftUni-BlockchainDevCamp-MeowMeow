package org.meow.meow.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "";
    }

    @GetMapping("/about")
    public String about() {
        return "about here";
    }
}