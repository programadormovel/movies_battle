package br.com.letscode.movies_battle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMethodOperationException extends RuntimeException {

    private static final long serivalVersionID = 1L;

    public UnsuportedMethodOperationException(String exception){
        super(exception);
    }
}
