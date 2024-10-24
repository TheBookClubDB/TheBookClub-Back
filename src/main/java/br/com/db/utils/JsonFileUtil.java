package br.com.db.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonFileUtil {

    private static final String BASE_PATH = "src/test/resources/json/";

    public static Path filePath(String fileName) {
        return Paths.get(BASE_PATH, fileName);
    }

    public static String getFileContent(String fileName) throws IOException {
        Path path = filePath(fileName);
        return new String(Files.readAllBytes(path));
    }
}