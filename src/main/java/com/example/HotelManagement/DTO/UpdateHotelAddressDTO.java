package com.example.HotelManagement.DTO;

import lombok.Data;

@Data
public class UpdateHotelAddressDTO {

    private  String address;
    private String city;
    private int postalCode;
}
