package com.devclub.presentaiton.valueobject;

public class ContentReplacerItem {
    private final String replaceString;
    private final String replaceValue;

    public ContentReplacerItem(String replaceString, String replaceValue) {
        this.replaceString = replaceString;
        this.replaceValue = replaceValue;
    }

    public String getReplaceString() {
        return replaceString;
    }

    public String getReplaceValue() {
        return replaceValue;
    }
}
