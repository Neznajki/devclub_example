package com.devclub.presentaiton.input;

import com.devclub.presentaiton.collection.InputContentReplaceCollection;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;

public class PasswordRepeatInput implements SingleInputInterface {
    @Override
    public String getName() {
        return "passwordRepeat";
    }

    @Override
    public String getLabel() {
        return "Password Repeat";
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
