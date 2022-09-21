package com.devclub.presentaiton.contract;

public interface SingleInputHandlerInterface {
    String FULL_NAME_INDEX = "fullName";

    String getTargetFieldName();
    String getSourceFieldName();
    String prepareValue(String existingValue, String currentValue);
}
