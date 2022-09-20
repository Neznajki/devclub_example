package com.devclub.presentaiton.collection;

import com.devclub.presentaiton.contract.WebFormInterface;

import java.util.ArrayList;
import java.util.List;

public class MultiFormCollection {
    private final List<WebFormInterface> supportedFieldCollection = new ArrayList<>();

    public MultiFormCollection() {
        this.supportedFieldCollection.add(new LoginWebForm());
    }

    public WebFormInterface getSelectedFieldCollection(String formId) {
        if (formId == null) {
            return supportedFieldCollection.get(0);
        }

        for (WebFormInterface fieldCollection: supportedFieldCollection) {
            if (formId.equals(fieldCollection.getId())) {
                return fieldCollection;
            }
        }

        throw new RuntimeException(String.format("could not find field collection with id %s", formId));
    }

    public List<WebFormInterface> getSupportedFieldCollection() {
        return supportedFieldCollection;
    }
}
