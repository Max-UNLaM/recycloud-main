package ar.edu.unlam.recycloud.app.utils;

import java.io.IOException;

public interface JsonTools {
    <T> T loadFile(String filepath, Class<T> clazz) throws IOException;

    <T> T loadJson(String jsonString, Class<T> clazz);

    String loadJsonString(Object object);

    String loadJsonString(String filepath, Class clazz) throws IOException;
}
