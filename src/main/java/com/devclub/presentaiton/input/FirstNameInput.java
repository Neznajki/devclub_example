package com.devclub.presentaiton.input;

import com.devclub.presentaiton.collection.InputContentReplaceCollection;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;

public class FirstNameInput implements SingleInputInterface {
    @Override
    public String getName() {
        return "firstName";
    }

    @Override
    public String getLabel() {
        return "First Name";
    }

    @Override
    public String getType() {
        return "text";
    }

    @Override
    public ContentReplaceCollectionInterface getContentReplaceCollection() {
        return new InputContentReplaceCollection(this);
    }
}
