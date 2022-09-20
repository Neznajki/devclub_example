package com.devclub.presentaiton.dto;

public class FormDTO {
    private final String name;
    private final String value;

    public FormDTO(String name, String value) {
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
