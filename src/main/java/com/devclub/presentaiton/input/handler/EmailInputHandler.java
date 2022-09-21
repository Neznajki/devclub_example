package com.devclub.presentaiton.input.handler;

import com.devclub.presentaiton.contract.SingleInputHandlerInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;
import com.devclub.presentaiton.input.EmailInput;
import org.springframework.lang.NonNull;

public class EmailInputHandler implements SingleInputHandlerInterface {
    private final SingleInputInterface currentInput = new EmailInput();

    @Override
    public String getTargetFieldName() {
        return "email";
    }

    @Override
    public String getSourceFieldName() {
        return currentInput.getName();
    }

    @Override
    @NonNull
    public String prepareValue(String existingValue, String currentValue) {
        return currentValue;
    }
}
