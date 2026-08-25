package com.luis.springboot.EduConnect.exceptions;

import com.luis.springboot.EduConnect.DTOs.ErrorResponseDTO;
import com.luis.springboot.EduConnect.DTOs.ValidationResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> ResourceNotFound(ResourceNotFoundException ex){
        ErrorResponseDTO error = new ErrorResponseDTO(LocalDateTime.now(),404,"Not Found",ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationResponseDTO> handleValidation(MethodArgumentNotValidException ex){
        Map<String,List<String>> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach((error)->{
                    errors.computeIfAbsent(error.getField(),k-> new ArrayList<>())
                            .add(error.getDefaultMessage());
                });
        ValidationResponseDTO error = new ValidationResponseDTO(LocalDateTime.now(),400,"Bad Request",errors);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
