package com.example.HotelManagement.Controller;

import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;
@PostMapping("createhotel")
    public Hotel createHotel(@RequestBody  HotelDTO hotelDTO){
        return hotelService.saveHotel(hotelDTO);

    }
    @GetMapping("/getallhotels")
    public List<Hotel> getAllHotels(){
    return hotelService.getAllHotels();

    }
    @GetMapping("/gethotel/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        return ResponseEntity.ok(hotelService.getHotelById(id));

    }


    @PutMapping("/updatehotel/{id}")
    public Hotel updateHotel(@RequestBody HotelDTO hotelDTO,@PathVariable Long id){
    return hotelService.updateHotel(hotelDTO,id);


    }

    @DeleteMapping("/deletehotel/{id}")
    public void deleteHotel(@PathVariable long id){
     hotelService.deleteHotelById(id);
    }

    @PutMapping("/updatehoteladdress/{id}")

    public Hotel updateHotelAddress(@RequestBody UpdateHotelAddressDTO updateHotelAddressDTO, @PathVariable long id){
        return hotelService.updateHotelAddress(updateHotelAddressDTO,id);
    }
}
