package com.devclub.presentaiton.service;

import com.devclub.presentaiton.contract.ContentGenerationInterface;
import com.devclub.presentaiton.contract.ContentReplaceCollectionInterface;
import com.devclub.presentaiton.helper.LogicHelper;

abstract public class AbstractGenerationService implements ContentGenerationInterface {
    @Override
    public String adjustContent(String content, String formId) {
        for (ContentReplaceCollectionInterface replacer : this.getCollectionItems(formId)) {
            String itemHtml = LogicHelper.useReplacer(this.getHtmlContent(), replacer)
                    + this.getReplacingIndex();//append for next item replacement
            content = content.replace(this.getReplacingIndex(), itemHtml);
        }

        content = content.replace(this.getReplacingIndex(), "");//cleanup after all item generation done

        return content;
    }
}
