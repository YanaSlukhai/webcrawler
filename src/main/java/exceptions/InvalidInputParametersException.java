package exceptions;

import java.io.IOException;

public class InvalidInputParametersException extends RuntimeException{

    public InvalidInputParametersException(IOException e) {
        super(e);
    }
}
