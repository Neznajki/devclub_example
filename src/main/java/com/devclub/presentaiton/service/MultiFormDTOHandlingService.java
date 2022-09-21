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
            String preparedValue = singleInputHandler.prepareValue("", formInputDTO.getValue());
            existingItems.put(targetFieldName, new ResponseItem(targetFieldName, preparedValue));
            return;
        }

        ResponseItem responseItem = existingItems.get(targetFieldName);
        existingItems.remove(targetFieldName);
        String preparedValue = singleInputHandler.prepareValue(responseItem.getValue(), formInputDTO.getValue());
        existingItems.put(targetFieldName, new ResponseItem(targetFieldName, preparedValue));
    }
}
