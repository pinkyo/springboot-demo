package my.pinkyo.demo.exceptionHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.invoke.MethodHandles;

/**
 * Created by yinkn on 2017/7/9.
 */
@ControllerAdvice(basePackages = "my.pinkyo.demo.controller")
public class ExceptionHanderAdvice {
    private Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        log.error(ex);
        return new ResponseEntity<Object>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
