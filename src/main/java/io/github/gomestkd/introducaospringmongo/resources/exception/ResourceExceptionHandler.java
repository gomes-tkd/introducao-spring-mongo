package io.github.gomestkd.introducaospringmongo.resources.exception;

import io.github.gomestkd.introducaospringmongo.services.execption.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Não encontrado!",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(standardError);
    };
}
