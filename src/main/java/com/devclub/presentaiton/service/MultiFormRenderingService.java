package com.devclub.presentaiton.service;

import com.devclub.presentaiton.contract.ContentGenerationInterface;
import com.devclub.presentaiton.helper.FileHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MultiFormRenderingService {
    private final List<ContentGenerationInterface> generatorList = new ArrayList<>();

    public MultiFormRenderingService(
        MultiFormNavGenerationService multiFormNavGenerationService,
        MultiFormInputGenerationService multiFormInputGenerationService
    ) {
        this.generatorList.add(multiFormNavGenerationService);
        this.generatorList.add(multiFormInputGenerationService);
    }

    public String getContent(String formId) {
        String content = FileHelper.getFileContents("templates/split/index.html");

        for (ContentGenerationInterface contentGeneration: generatorList) {
            content = contentGeneration.adjustContent(content, formId);
        }

        return content;
    }
}
