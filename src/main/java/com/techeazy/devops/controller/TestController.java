package com.techeazy.devops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public  String test() {
        return "A simple Java application was deployed using a Jenkins CI/CD pipeline.";
    }
}
