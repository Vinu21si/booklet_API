package com.booklet.booklet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthcheck {
    @GetMapping("/health")
    public String health() {
        return "the api is live!!!";
    }
}
