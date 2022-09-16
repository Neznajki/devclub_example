package com.devclub.presentaiton.helper;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHelper {
    public static String getFileContents(String relativePath) {
        try {
            return Files.readString(Path.of(new ClassPathResource(relativePath).getURI()));
        } catch (IOException e) {
            throw new RuntimeException(String.format("relative path %s could not be found", relativePath));
        }
    }
}
