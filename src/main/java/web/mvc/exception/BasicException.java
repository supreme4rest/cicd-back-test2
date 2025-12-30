package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BasicException extends RuntimeException {
    final private ErrorCode errorCode;
}
