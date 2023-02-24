package gg.astrub.astrub.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class ListingException extends RuntimeException{
    private String message;
    private String code;
    private HttpStatus httpStatus;

    public ListingException(String message) {
        super();
        this.message = message;
    }

    public ListingException(String message, String code) {
        super();
        this.message = message;
        this.code = code;
    }

    public ListingException(String message, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ListingException(String message, String code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
