package com.devclub.presentaiton.service;

import com.devclub.presentaiton.collection.InputHandlerCollection;
import com.devclub.presentaiton.contract.SingleInputHandlerInterface;
import com.devclub.presentaiton.dto.FormDTO;
import com.devclub.presentaiton.valueobject.ResponseItem;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MultiFormDTOHandlingService {
    private final InputHandlerCollection inputHandlerCollection = new InputHandlerCollection();

    public void handleDTO(FormDTO formInputDTO, Map<String, ResponseItem> existingItems) {
        SingleInputHandlerInterface singleInputHandler = this.inputHandlerCollection.getInputHandlerByDTO(formInputDTO);

        String targetFieldName = singleInputHandler.getTargetFieldName();
        if (! existingItems.containsKey(targetFieldName)) {
            existingItems.put(
                targetFieldName,
                prepareAndCreateResponseItem(formInputDTO, singleInputHandler, targetFieldName, "")
            );
            return;
        }

        ResponseItem responseItem = existingItems.get(targetFieldName);
        existingItems.remove(targetFieldName);
        existingItems.put(
            targetFieldName,
            prepareAndCreateResponseItem(formInputDTO, singleInputHandler, targetFieldName, responseItem.getValue())
        );
    }

    private ResponseItem prepareAndCreateResponseItem(
        FormDTO formInputDTO,
        SingleInputHandlerInterface singleInputHandler,
        String targetFieldName,
        String existingValue
    ) {
        String preparedValue = singleInputHandler.prepareValue(existingValue, formInputDTO.getValue());
        return new ResponseItem(targetFieldName, preparedValue);
    }
}
