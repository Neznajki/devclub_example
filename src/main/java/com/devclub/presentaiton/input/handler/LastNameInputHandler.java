package com.devclub.presentaiton.input.handler;

import com.devclub.presentaiton.contract.SingleInputHandlerInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;
import com.devclub.presentaiton.input.LastNameInput;
import org.springframework.lang.NonNull;

public class LastNameInputHandler implements SingleInputHandlerInterface {
    private final SingleInputInterface currentInput = new LastNameInput();

    @Override
    public String getTargetFieldName() {
        return this.FULL_NAME_INDEX;
    }

    @Override
    public String getSourceFieldName() {
        return currentInput.getName();
    }

    @Override
    @NonNull
    public String prepareValue(String existingValue, String currentValue) {
        return String.format("%s %s", existingValue, currentValue);
    }
}