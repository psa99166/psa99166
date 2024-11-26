package com.xyz.xyz.exception;
import java.util.Date;

import com.xyz.xyz.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(ResourceNotFound e){
        ErrorDetails errorDetails=new ErrorDetails(e.getMessage(),new Date());
        return new ResponseEntity<>(errorDetails,HttpStatus.OK);

    }
}
