package com.devclub.presentaiton.input;

import com.devclub.presentaiton.collection.InputContentReplaceCollection;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;

public class LastNameInput implements SingleInputInterface {
    @Override
    public String getName() {
        return "lastName";
    }

    @Override
    public String getLabel() {
        return "Last Name";
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
