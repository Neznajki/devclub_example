package com.devclub.presentaiton.controller;

import com.devclub.presentaiton.service.MonolithService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SingleFormWebPageController {
    @Autowired
    private MonolithService monolithService;

    @GetMapping("/v1")
    public String index() throws IOException {
        return monolithService.getHomePage();
    }

    @PostMapping("/v1")
    public String index(@RequestBody String requestBody) throws JsonProcessingException {
        return monolithService.handleRequest(requestBody);
    }
}
