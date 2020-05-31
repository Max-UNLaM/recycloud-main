package ar.edu.unlam.recycloud.app.map.pin;

import java.util.List;

public interface PinRepository<T> {
    List<T> findAll();
}
