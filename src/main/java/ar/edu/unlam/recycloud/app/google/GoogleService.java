package ar.edu.unlam.recycloud.app.google;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoogleService {

    private final GeoApiContext geoApiContext;

    public GoogleService(GeoApiContext geoApiContext) {
        this.geoApiContext = geoApiContext;
    }

    public LatLng geoLocate(String address) throws InterruptedException, ApiException, IOException {
        GeocodingResult[] results = GeocodingApi.geocode(geoApiContext, address).await();
        return results[0].geometry.location;
    }

    public GeocodingResult geoLocate(LatLng latitude) throws InterruptedException, ApiException, IOException {
        GeocodingResult[] results = GeocodingApi.reverseGeocode(geoApiContext, latitude).await();
        return results[0];
    }

}
