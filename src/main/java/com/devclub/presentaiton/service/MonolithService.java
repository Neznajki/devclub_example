package com.devclub.presentaiton.service;

import com.devclub.presentaiton.dto.FormDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;

@Service
public class MonolithService {
    public String getHomePage() throws IOException {
        return Files.readString(Path.of(new ClassPathResource("templates/index.html").getURI()));
    }

    public String handleRequest(String requestData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<FormDTO> list = objectMapper.readValue(requestData, new TypeReference<>(){});
        String response = "{";

        for (FormDTO listItem: list) {
            String value = listItem.getValue();
            String name = listItem.getName();
            if (listItem.getName().equals("password")) {
                value = Base64.getEncoder().withoutPadding().encodeToString(listItem.getName().getBytes());
            }
            response += String.format("\n   \"%s\":\"%s\",", name, value);
        }

        response = response.replaceAll(",$", "\n}");

        return response;
    }
}
