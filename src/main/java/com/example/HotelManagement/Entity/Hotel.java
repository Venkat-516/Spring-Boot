package com.example.HotelManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private  String address;
    private String city;
    private int postalCode;
    private float rating;
    @Column(name ="available")
    private boolean isAvailable;
}
