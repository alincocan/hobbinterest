package ro.hobbinterest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.hobbinterest.response.ResponseEntity;

@ControllerAdvice(annotations = RestController.class)
public class CustomExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleExceptions(Exception ex, WebRequest webRequest) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

}
