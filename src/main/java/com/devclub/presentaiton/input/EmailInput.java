package com.devclub.presentaiton.input;

import com.devclub.presentaiton.collection.InputContentReplaceCollection;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;

public class EmailInput implements SingleInputInterface {
    @Override
    public String getName() {
        return "email";
    }

    @Override
    public String getLabel() {
        return "Email address";
    }

    @Override
    public String getType() {
        return "email";
    }

    @Override
    public ContentReplaceCollectionInterface getContentReplaceCollection() {
        return new InputContentReplaceCollection(this);
    }
}
