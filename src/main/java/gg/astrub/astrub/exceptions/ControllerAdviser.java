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
        result.setStatusCode("");
        result.setDescription("");
        result.setFrontDescription("");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @ExceptionHandler(ListingException.class)
    public  ResponseEntity<GenericResponse> HandleListingException(ListingException e) {
        GenericResponse result = new GenericResponse();
        log.error(e.getMessage(), e);
        e.printStackTrace();
        result.setFrontDescription("Listing Not Found !");
        result.setDescription(e.getMessage());
        result.setStatusCode("ERROR L01");
        result.setError(true);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
    }

}
