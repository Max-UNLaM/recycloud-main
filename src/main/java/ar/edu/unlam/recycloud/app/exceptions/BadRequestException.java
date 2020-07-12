package ar.edu.unlam.recycloud.app.exceptions;

public class BadRequestException extends HttpException {
    public BadRequestException(String message) {
        super(message, 400);
    }
}
