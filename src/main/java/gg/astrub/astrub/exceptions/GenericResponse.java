package gg.astrub.astrub.exceptions;

import gg.astrub.astrub.enums.ApiStatusCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class GenericResponse {
    private ApiStatusCode statusCode;
    private boolean error;
    private String description;
    private String frontDescription;
}
