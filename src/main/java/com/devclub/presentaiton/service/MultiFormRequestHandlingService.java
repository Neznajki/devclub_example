package com.devclub.presentaiton.service;

import com.devclub.presentaiton.collection.MultiFormCollection;
import com.devclub.presentaiton.contract.*;
import com.devclub.presentaiton.dto.FormDTO;
import com.devclub.presentaiton.serializer.JsonSerializer;
import com.devclub.presentaiton.valueobject.ResponseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MultiFormRequestHandlingService implements ContainsInputInterface {
    private final SerializerInterface serializer = new JsonSerializer();
    private final MultiFormCollection multiFormCollection = new MultiFormCollection();
    private final MultiFormDTOHandlingService multiFormDTOHandlingService;

    @Autowired
    public MultiFormRequestHandlingService(MultiFormDTOHandlingService multiFormDTOHandlingService) {
        this.multiFormDTOHandlingService = multiFormDTOHandlingService;
    }

    public String handleRequest(String formId, String requestBody) {
        List<FormDTO> requestDataList = serializer.deserializeData(requestBody);
        Map<String, ResponseItem> responseDataList = new HashMap<>();
        WebFormInterface webForm = multiFormCollection.getSelectedFieldCollection(formId);

        for (FormDTO formInputDTO: requestDataList) {
            if (! this.containsInputInForm(webForm, formInputDTO)) {
                String errorMessage = String.format(
                    "form %s doesn't contain an input %s",
                    webForm.getId(),
                    formInputDTO.getName()
                );

                throw new RuntimeException(errorMessage);
            }
            multiFormDTOHandlingService.handleDTO(formInputDTO, responseDataList);
        }

        return serializer.serializeData(new ArrayList<>(responseDataList.values()));
    }

    @Override
    public boolean containsInputInForm(WebFormListInterface webForm, FormDTO formDTO) {
        for (SingleInputInterface formInput: webForm.getFieldList()) {
            if (formInput.getName().equals(formDTO.getName())) {
                return true;
            }
        }

        return false;
    }
}
