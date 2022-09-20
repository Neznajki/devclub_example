package com.devclub.presentaiton.collection;

import com.devclub.presentaiton.contract.WebFormInterface;
import com.devclub.presentaiton.form.LoginWebForm;
import com.devclub.presentaiton.form.RegisterWebForm;

import java.util.ArrayList;
import java.util.List;

public class MultiFormCollection {
    private final List<WebFormInterface> supportedFormCollection = new ArrayList<>();

    public MultiFormCollection() {
        this.supportedFormCollection.add(new LoginWebForm());
        this.supportedFormCollection.add(new RegisterWebForm());
    }

    public WebFormInterface getSelectedFieldCollection(String formId) {
        for (WebFormInterface fieldCollection: supportedFormCollection) {
            if (formId.equals(fieldCollection.getId())) {
                return fieldCollection;
            }
        }

        throw new RuntimeException(String.format("could not find field collection with id %s", formId));
    }

    public List<WebFormInterface> getSupportedFormCollection() {
        return supportedFormCollection;
    }
}
