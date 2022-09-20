package com.devclub.presentaiton.input;

import com.devclub.presentaiton.collection.InputContentReplaceCollection;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;

public class PasswordInput implements SingleInputInterface {
    @Override
    public String getName() {
        return "password";
    }

    @Override
    public String getLabel() {
        return "Password";
    }

    @Override
    public String getType() {
        return "password";
    }

    @Override
    public ContentReplaceCollectionInterface getContentReplaceCollection() {
        return new InputContentReplaceCollection(this);
    }
}
