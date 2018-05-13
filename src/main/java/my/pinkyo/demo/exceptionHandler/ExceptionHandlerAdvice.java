package my.pinkyo.demo.exceptionHandler;

import java.lang.invoke.MethodHandles;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import my.pinkyo.demo.exception.BadRequestException;

/**
 * Created by yinkn on 2017/7/9.
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String, String> handleArgumentNOtValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldErrors().get(0);
        return Collections.singletonMap("validationError", 
        		String.format("%s:%s", fieldError.getField(), fieldError.getDefaultMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    String handleBadRequestException(BadRequestException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String handleControllerException(Throwable ex) {
        return "Internal Error";
    }
}
