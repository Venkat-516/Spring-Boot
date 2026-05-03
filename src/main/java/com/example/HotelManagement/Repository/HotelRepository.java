package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
