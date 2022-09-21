package com.devclub.presentaiton.controller;

import com.devclub.presentaiton.form.LoginWebForm;
import com.devclub.presentaiton.service.MultiFormRequestHandlingService;
import com.devclub.presentaiton.service.MultiFormRenderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MultiFormWebPageController {
    @Autowired
    private MultiFormRenderingService multiFormRenderingService;
    @Autowired
    private MultiFormRequestHandlingService multiFormHandlingService;

    @GetMapping("/v2")
    public RedirectView index() {
        return new RedirectView("/v2/" + LoginWebForm.FORM_ID);
    }

    @GetMapping("/v2/{formId}")
    public String index(@PathVariable("formId") String id) {
        return multiFormRenderingService.getContent(id);
    }

    @PostMapping("/v2/{formId}")
    public String index(@PathVariable("formId") String formId, @RequestBody String requestBody) {
        return multiFormHandlingService.handleRequest(formId, requestBody);
    }
}
