package com.devclub.presentaiton.service;

import com.devclub.presentaiton.collection.MultiFormCollection;
import com.devclub.presentaiton.contract.ContentGenerationInterface;
import com.devclub.presentaiton.contract.ContentReplaceCollectionContainerInterface;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.helper.FileHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MultiFormInputGenerationService extends AbstractGenerationService implements ContentGenerationInterface {
    private final MultiFormCollection multiFormCollection = new MultiFormCollection();

    @Override
    public String getReplacingIndex() {
        return "{{input}}";
    }

    @Override
    public String getHtmlContent() {
        return FileHelper.getFileContents("templates/split/input.html");
    }

    @Override
    public List<ContentReplaceCollectionInterface> getCollectionItems(String formId) {
        return this.multiFormCollection.getSelectedFieldCollection(formId)
                .getFieldList()
                .stream()
                .map(ContentReplaceCollectionContainerInterface::getContentReplaceCollection)
                .collect(Collectors.toList());
    }
}
