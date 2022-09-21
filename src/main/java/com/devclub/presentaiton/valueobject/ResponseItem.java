package com.devclub.presentaiton.valueobject;

public class ResponseItem {
    private final String name;
    private final String value;

    public ResponseItem(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
