package gg.astrub.astrub.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@Slf4j
public class ControllerAdviser extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> handleGenericException(Exception e) {
        GenericResponse result = new GenericResponse();
        log.error(e.getMessage(), e);
        e.printStackTrace();
        result.setStatusCode(null);
        result.setDescription(e.getMessage());
        result.setFrontDescription(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @ExceptionHandler(ListingException.class)
    public  ResponseEntity<GenericResponse> HandleListingException(ListingException e) {
        GenericResponse result = new GenericResponse();
        log.error(e.getMessage(), e);
        e.printStackTrace();
        result.setFrontDescription(e.getMessageFront());
        result.setDescription(e.getMessage());
        result.setStatusCode(e.getCode());
        result.setError(true);
        return ResponseEntity.status(e.getHttpStatus()).body(result);
    }

}
