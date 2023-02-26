package gg.astrub.astrub.exceptions;

import gg.astrub.astrub.enums.ApiStatusCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class ListingException extends RuntimeException{
    private String message;
    private String messageFront;
    private ApiStatusCode code;
    private HttpStatus httpStatus;

    public ListingException(String message) {
        super();
        this.message = message;
    }

    public ListingException(String message, String messageFront , ApiStatusCode code) {
        super();
        this.message = message;
        this.code = code;
        this.messageFront = messageFront;
    }

    public ListingException(String message, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ListingException(String message, ApiStatusCode code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public ListingException(String message, String messageFront, ApiStatusCode code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.messageFront = messageFront;
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
