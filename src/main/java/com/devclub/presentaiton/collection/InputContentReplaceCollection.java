package com.devclub.presentaiton.collection;

import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;
import com.devclub.presentaiton.valueobject.ContentReplacerItem;

import java.util.ArrayList;
import java.util.List;

public class InputContentReplaceCollection implements ContentReplaceCollectionInterface {
    private final SingleInputInterface singleInput;

    public InputContentReplaceCollection(SingleInputInterface singleInput) {
        this.singleInput = singleInput;
    }

    @Override
    public List<ContentReplacerItem> getContentReplacerItems() {
        List<ContentReplacerItem> collection = new ArrayList<>();

        collection.add(new ContentReplacerItem("{{name}}", singleInput.getName()));
        collection.add(new ContentReplacerItem("{{type}}", singleInput.getType()));
        collection.add(new ContentReplacerItem("{{label}}", singleInput.getLabel()));

        return collection;
    }
}
