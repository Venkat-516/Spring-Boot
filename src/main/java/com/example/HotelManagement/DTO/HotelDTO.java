package com.example.HotelManagement.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class HotelDTO {
    private String name;

    private  String address;
    private String city;

    private float rating;
    private int postalCode;

    private boolean isAvailable;
}
