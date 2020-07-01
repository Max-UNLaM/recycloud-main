package ar.edu.unlam.recycloud.conf;

import com.google.maps.GeoApiContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleApiConfig {

    private static final String KEY = "AIzaSyA0lJoUoC-kiNyutxVB9ay4Oycbs35KjEg";

    @Bean
    GeoApiContext geoApiContext() {
        return new GeoApiContext.Builder()
                .apiKey(KEY)
                .build();
    }

}
