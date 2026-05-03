package com.example.HotelManagement.Exception;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message){
        super(message);
    }
}
