package my.pinkyo.demo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yinkn on 2017/7/9.
 */
@ControllerAdvice
public class ExceptionHanderAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<Object>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
