package com.devclub.presentaiton.serializer;

import com.devclub.presentaiton.contract.SerializerInterface;
import com.devclub.presentaiton.dto.FormDTO;
import com.devclub.presentaiton.valueobject.ResponseItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonSerializer implements SerializerInterface {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String serializeData(List<ResponseItem> data) {
        String response = "{";

        for (ResponseItem listItem: data) {
            String value = listItem.getValue();
            String name = listItem.getName();
            response += String.format("\n   \"%s\":\"%s\",", name, value);
        }

        response = response.replaceAll(",$", "\n}");
        return response;
    }

    @Override
    public List<FormDTO> deserializeData(String dataString) {
        try {
            return objectMapper.readValue(dataString, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("invalid incoming JSON", e);
        }
    }
}
