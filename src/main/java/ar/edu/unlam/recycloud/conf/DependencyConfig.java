package ar.edu.unlam.recycloud.conf;

import ar.edu.unlam.recycloud.app.utils.GsonRecyBuilder;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyConfig {

    private final Gson gson;

    DependencyConfig(GsonRecyBuilder builder) {
        this.gson = builder.getGson();
    }

    @Bean
    public Gson gson() {
        return this.gson;
    }

}
