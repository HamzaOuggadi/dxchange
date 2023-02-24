package gg.astrub.astrub.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse {
    private String statusCode;
    private boolean error;
    private String description;
    private String frontDescription;
}
