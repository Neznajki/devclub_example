package com.devclub.presentaiton.collection;

import com.devclub.presentaiton.contract.SingleNavInterface;

import java.util.ArrayList;
import java.util.List;

public class MultiNavCollection {
    private final List<SingleNavInterface> supportedFieldCollection = new ArrayList<>();

    public MultiNavCollection() {
        this.supportedFieldCollection.add(new LoginWebForm());
    }

    public List<SingleNavInterface> getNavItemCollection(String formId) {
        return supportedFieldCollection;
    }
}
