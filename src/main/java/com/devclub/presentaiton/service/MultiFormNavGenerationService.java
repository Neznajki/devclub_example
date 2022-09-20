package com.devclub.presentaiton.service;

import com.devclub.presentaiton.collection.MultiFormCollection;
import com.devclub.presentaiton.contract.ContentReplaceCollectionContainerInterface;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.helper.FileHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                .getSupportedFieldCollection()
                .stream()
                .map(ContentReplaceCollectionContainerInterface::getContentReplaceCollection)
                .collect(Collectors.toList());
    }
}
