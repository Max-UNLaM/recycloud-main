package ar.edu.unlam.recycloud.app.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;

@Singleton
@Component
public class GsonRecyBuilder {

    private final Gson GSON;

    GsonRecyBuilder() {
        this.GSON = new com.google.gson.GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .serializeNulls()
                .create();
    }

    public Gson getGson() {
        return GSON;
    }

}
