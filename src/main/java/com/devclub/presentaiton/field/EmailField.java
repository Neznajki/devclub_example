package com.devclub.presentaiton.field;

import com.devclub.presentaiton.collection.FieldContentReplaceCollection;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.SingleFieldInterface;

public class EmailField implements SingleFieldInterface {
    @Override
    public String getLabel() {
        return "Email address";
    }

    @Override
    public String getName() {
        return "email";
    }

    @Override
    public String getType() {
        return "email";
    }

    @Override
    public ContentReplaceCollectionInterface getContentReplaceCollection() {
        return new FieldContentReplaceCollection(this);
    }
}
