package com.devclub.presentaiton.collection;

import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.contract.SingleNavInterface;
import com.devclub.presentaiton.valueobject.ContentReplacerItem;

import java.util.ArrayList;
import java.util.List;

public class NavContentReplaceCollection implements ContentReplaceCollectionInterface {
    private final SingleNavInterface singleNav;

    public NavContentReplaceCollection(SingleNavInterface singleNav) {
        this.singleNav = singleNav;
    }

    @Override
    public List<ContentReplacerItem> getContentReplacerItems() {
        List<ContentReplacerItem> collection = new ArrayList<>();

        collection.add(new ContentReplacerItem("{{link}}", singleNav.getLink()));
        collection.add(new ContentReplacerItem("{{label}}", singleNav.getLabel()));

        return collection;
    }
}
