package com.techeazy.devops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public  String test() {
        return "A simple Java application has been deployed using Docker, with Jenkins CI/CD pipeline automatically trigger builds via webhooks.";
    }
}
