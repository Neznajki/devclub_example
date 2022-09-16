package com.devclub.presentaiton.helper;

import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.valueobject.ContentReplacerItem;

public class LogicHelper {
    public static String useReplacer(String content, ContentReplaceCollectionInterface collection) {
        for (ContentReplacerItem item: collection.getContentReplacerItems()) {
            content = content.replace(item.getReplaceString(), item.getReplaceValue());
        }

        return content;
    }
}
