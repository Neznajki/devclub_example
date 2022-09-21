package com.devclub.presentaiton.collection;

import com.devclub.presentaiton.contract.SingleInputHandlerInterface;
import com.devclub.presentaiton.dto.FormDTO;
import com.devclub.presentaiton.input.handler.*;

import java.util.HashMap;
import java.util.Map;

public class InputHandlerCollection {
    private final Map<String, SingleInputHandlerInterface> handlers = new HashMap<>();

    public InputHandlerCollection() {
        this.addHandler(new EmailInputHandler());
        this.addHandler(new FirstNameInputHandler());
        this.addHandler(new LastNameInputHandler());
        this.addHandler(new PasswordInputHandler());
        this.addHandler(new PasswordRepeatInputHandler());
    }

    public SingleInputHandlerInterface getInputHandlerByDTO(FormDTO formInputDTO) {
        if (! this.handlers.containsKey(formInputDTO.getName())) {
            throw new RuntimeException(String.format("could not find handler item for : %s DTO", formInputDTO.getName()));
        }

        return this.handlers.get(formInputDTO.getName());
    }

    private void addHandler(SingleInputHandlerInterface inputHandler) {
        this.handlers.put(inputHandler.getSourceFieldName(), inputHandler);
    }
}
