package com.devclub.presentaiton.collection;

import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.SingleFieldInterface;
import com.devclub.presentaiton.valueobject.ContentReplacerItem;

import java.util.ArrayList;
import java.util.List;

public class FieldContentReplaceCollection implements ContentReplaceCollectionInterface {
    private final SingleFieldInterface singleField;

    public FieldContentReplaceCollection(SingleFieldInterface singleField) {
        this.singleField = singleField;
    }

    @Override
    public List<ContentReplacerItem> getContentReplacerItems() {
        List<ContentReplacerItem> collection = new ArrayList<>();

        collection.add(new ContentReplacerItem("{{name}}", singleField.getName()));
        collection.add(new ContentReplacerItem("{{type}}", singleField.getType()));
        collection.add(new ContentReplacerItem("{{label}}", singleField.getLabel()));

        return collection;
    }
}
