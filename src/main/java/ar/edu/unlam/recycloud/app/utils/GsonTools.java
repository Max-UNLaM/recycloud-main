package ar.edu.unlam.recycloud.app.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.inject.Singleton;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Singleton
@Component
public class GsonTools implements JsonTools {

    private final Gson gson;

    GsonTools(GsonRecyBuilder gsonRecyBuilder) {
        this.gson = gsonRecyBuilder.getGson();
    }

    @Override
    public <T> T loadFile(String filepath, Class<T> clazz) throws IOException {
        try (FileReader fileReader = new FileReader(clazz.getResource(filepath).getFile())) {
            JsonReader jsonReader = new JsonReader(fileReader);
            return gson.fromJson(jsonReader, clazz);
        }
    }

    @Override
    public <T> T loadJson(String jsonString, Class<T> clazz) {
        return gson.fromJson(jsonString, clazz);
    }

    @Override
    public String loadJsonString(Object object) {
        return gson.toJson(object);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String loadJsonString(String filepath, Class clazz) throws IOException {
        return gson.toJson(loadFile(filepath, clazz), clazz);
    }
}
