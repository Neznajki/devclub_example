package com.devclub.presentaiton.service;

import com.devclub.presentaiton.collection.MultiFormCollection;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.helper.FileHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("Convert2MethodRef")
@Service
public class MultiFormNavGenerationService extends AbstractGenerationService {
    private final MultiFormCollection multiFormCollection = new MultiFormCollection();

    @Override
    public String getReplacingIndex() {
        return "{{navItem}}";
    }

    @Override
    public String getHtmlContent() {
        return FileHelper.getFileContents("templates/split/nav.html");
    }

    @Override
    public List<ContentReplaceCollectionInterface> getCollectionItems(String formId) {
        return multiFormCollection
                .getSupportedFormCollection()
                .stream()
                .map(nav -> nav.getContentReplaceCollection())
                .collect(Collectors.toList());
    }
}
