package ar.edu.unlam.recycloud.app.map.pin;

import org.bson.conversions.Bson;

import java.util.List;
import java.util.Map;

public interface PinRepository<T> {
    List<T> findAll();
    List<T> find(Map<String, String> filters);
    List<T> find(Bson filter);
    void setPunto(T punto);
    void updatePunto(T pin);
}
