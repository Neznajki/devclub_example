package com.devclub.presentaiton.controller;

import com.devclub.presentaiton.service.MultiFormRenderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MultiFormWebPageController {
    @Autowired
    private MultiFormRenderingService multiFormRenderingService;

    @GetMapping("/v2")
    public String index() {
        return multiFormRenderingService.getContent("loginForm");
    }

    @GetMapping("/v2/{id}")
    public String index(@PathVariable("id") String id) {
        return multiFormRenderingService.getContent(id);
    }
}
