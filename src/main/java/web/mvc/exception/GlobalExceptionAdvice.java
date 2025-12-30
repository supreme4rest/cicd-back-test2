package web.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(BasicException.class)
    public ResponseEntity<Object> handleException(BasicException ex) {
        return ResponseEntity.status(ex.getErrorCode().getStatus())
                .body(ex.getErrorCode().getMessage()
                );
    }
}
