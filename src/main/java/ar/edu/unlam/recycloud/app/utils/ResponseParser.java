package ar.edu.unlam.recycloud.app.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseParser {

    public <T> T parse(ResponseEntity<T> responseEntity) {
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        throw new RuntimeException(responseEntity.getStatusCode().getReasonPhrase());
    }

}
