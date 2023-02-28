package gg.astrub.astrub.exceptions;

import gg.astrub.astrub.enums.ApiStatusCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class UserException extends Exception{

    private String message;
    private String messageFront;
    private ApiStatusCode code;
    private HttpStatus httpStatus;

    public UserException(String message) {
        super();
        this.message = message;
    }

    public UserException(String message, String messageFront , ApiStatusCode code) {
        super();
        this.message = message;
        this.code = code;
        this.messageFront = messageFront;
    }

    public UserException(String message, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public UserException(String message, ApiStatusCode code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public UserException(String message, String messageFront, ApiStatusCode code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.messageFront = messageFront;
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
