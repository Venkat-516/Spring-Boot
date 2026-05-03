package com.example.HotelManagement.Exception;

import com.example.HotelManagement.Entity.HotelNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<HotelNotFound> hotelNotFound(HotelNotFoundException hnfe, WebRequest webRequest){
        HotelNotFound h = new HotelNotFound(hnfe.getMessage(), webRequest.getDescription(false),HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<HotelNotFound>(h, HttpStatus.NOT_FOUND);
    }
}
