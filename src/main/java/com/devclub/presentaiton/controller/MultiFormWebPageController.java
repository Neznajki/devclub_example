package com.devclub.presentaiton.controller;

import com.devclub.presentaiton.form.LoginWebForm;
import com.devclub.presentaiton.service.MultiFormRenderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MultiFormWebPageController {
    @Autowired
    private MultiFormRenderingService multiFormRenderingService;

    @GetMapping("/v2")
    public RedirectView index() {
        return new RedirectView("/v2/" + LoginWebForm.FORM_ID);
    }

    @GetMapping("/v2/{id}")
    public String index(@PathVariable("id") String id) {
        return multiFormRenderingService.getContent(id);
    }
}
