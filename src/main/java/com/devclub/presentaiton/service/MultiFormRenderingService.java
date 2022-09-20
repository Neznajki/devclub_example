package com.devclub.presentaiton.service;

import com.devclub.presentaiton.contract.AdjustContentInterface;
import com.devclub.presentaiton.helper.FileHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MultiFormRenderingService {
    private final List<AdjustContentInterface> generatorList = new ArrayList<>();

    public MultiFormRenderingService(
        MultiFormNavGenerationService multiFormNavGenerationService,
        MultiFormInputGenerationService multiFormInputGenerationService,
        ActionReplacerService actionReplacerService
    ) {
        this.generatorList.add(multiFormNavGenerationService);
        this.generatorList.add(multiFormInputGenerationService);
        this.generatorList.add(actionReplacerService);
    }

    public String getContent(String formId) {
        String content = FileHelper.getFileContents("templates/split/index.html");

        for (AdjustContentInterface contentGeneration: generatorList) {
            content = contentGeneration.adjustContent(content, formId);
        }

        return content;
    }
}
