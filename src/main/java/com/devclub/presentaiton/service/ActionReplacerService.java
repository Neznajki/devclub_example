package com.devclub.presentaiton.service;

import com.devclub.presentaiton.contract.AdjustContentInterface;
import org.springframework.stereotype.Service;

@Service
public class ActionReplacerService implements AdjustContentInterface {
    @Override
    public String adjustContent(String content, String formId) {
        return content.replace("{{action}}", formId);
    }
}
