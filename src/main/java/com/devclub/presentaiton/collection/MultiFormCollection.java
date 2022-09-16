package com.devclub.presentaiton.collection;

import com.devclub.presentaiton.contract.FieldCollectionInterface;

import java.util.ArrayList;
import java.util.List;

public class MultiFormCollection {
    private final List<FieldCollectionInterface> supportedFieldCollection = new ArrayList<>();

    public MultiFormCollection() {
        this.supportedFieldCollection.add(new LoginFormFieldCollection());
    }

    public FieldCollectionInterface getSelectedFieldCollection(String formId) {
        if (formId == null) {
            return supportedFieldCollection.get(0);
        }

        for (FieldCollectionInterface fieldCollection: supportedFieldCollection) {
            if (formId.equals(fieldCollection.getId())) {
                return fieldCollection;
            }
        }

        throw new RuntimeException(String.format("could not find field collection with id %s", formId));
    }

    public List<FieldCollectionInterface> getSupportedFieldCollection() {
        return supportedFieldCollection;
    }
}
