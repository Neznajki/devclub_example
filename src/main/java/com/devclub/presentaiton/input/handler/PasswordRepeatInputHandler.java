package com.devclub.presentaiton.input.handler;

import com.devclub.presentaiton.contract.SingleInputHandlerInterface;
import com.devclub.presentaiton.contract.SingleInputInterface;
import com.devclub.presentaiton.input.PasswordRepeatInput;
import org.springframework.lang.NonNull;

import java.util.Base64;

public class PasswordRepeatInputHandler implements SingleInputHandlerInterface {
    private final SingleInputInterface currentInput = new PasswordRepeatInput();

    @Override
    public String getTargetFieldName() {
        return "passwordRepeat";
    }

    @Override
    public String getSourceFieldName() {
        return currentInput.getName();
    }

    @Override
    @NonNull
    public String prepareValue(String existingValue, String currentValue) {
        return Base64.getEncoder().withoutPadding().encodeToString(currentValue.getBytes());
    }
}