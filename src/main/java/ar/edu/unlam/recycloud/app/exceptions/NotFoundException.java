package ar.edu.unlam.recycloud.app.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String entity, Long id) {
        super(String.format("Elemento %s %s no encontrado", entity, id));
    }
}
