package ar.edu.unlam.recycloud.app.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpException extends RuntimeException {
    private int statusCode;

    public HttpException(String message, int statusCode) {
        super(message);
    }

}
