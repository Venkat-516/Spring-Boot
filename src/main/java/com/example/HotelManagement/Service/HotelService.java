package com.example.HotelManagement.Service;

import com.example.HotelManagement.Communicator.RestTemplateCommunicator;
import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Exception.HotelNotFoundException;
import com.example.HotelManagement.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class HotelService {
    @Autowired
 private HotelRepository hotelRepository;
    @Autowired
    private RestTemplateCommunicator restTemplateCommunicator;
    public Hotel saveHotel(HotelDTO hotelDTO){
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setCity(hotelDTO.getCity());
        hotel.setPostalCode(hotelDTO.getPostalCode());
        hotel.setRating(hotelDTO.getRating());
        hotel.setAvailable(hotelDTO.isAvailable());
        hotelRepository.save(hotel);
        return hotel;

    }

    public List<Hotel> getAllHotels(){
       return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id)  {
      Optional<Hotel> hotelBox = hotelRepository.findById(id);
      if(hotelBox.isPresent()) {
          Float hotelActualRating = restTemplateCommunicator.getActaulHotelRating(id);
          Hotel hotel = hotelBox.get();
          hotel.setRating(hotelActualRating);
      }


        return hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException("Hotel not found "+ id));
    }

   /* public ResponseEntity<Hotel> updateHotel(HotelDTO hotelDTO, Long id){
           Optional<Hotel> hotel =  getHotelById(id);
           if (hotel != null){
            hotel.setName(hotelDTO.getName());
            hotel.setAddress(hotelDTO.getAddress());
            hotel.setCity(hotelDTO.getCity());
            hotel.setPostalCode(hotelDTO.getPostalCode());
            hotel.setRating(hotelDTO.getRating());
            hotel.setAvailable(hotelDTO.isAvailable());
             hotelRepository.save(hotel);
            return hotel;
        }

        return hotel;
    } */

    public void deleteHotelById(long id){
         Hotel hotel = getHotelById(id);
         if(hotel != null){
             hotelRepository.deleteById(id);
         }
    }


    public Hotel updateHotel(HotelDTO hotelDTO, Long id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id); // get Optional directly

        Hotel updatedHotel = null;
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();

            hotel.setName(hotelDTO.getName());
            hotel.setAddress(hotelDTO.getAddress());
            hotel.setCity(hotelDTO.getCity());
            hotel.setPostalCode(hotelDTO.getPostalCode());
            hotel.setRating(hotelDTO.getRating());
            hotel.setAvailable(hotelDTO.isAvailable());

            updatedHotel = hotelRepository.save(hotel);

            return updatedHotel; // return 200 OK with hotel
        }

        // If not found, return 404;
        return updatedHotel;
    }

    public Hotel updateHotelAddress(UpdateHotelAddressDTO dto, long id) {
        Hotel hotel = getHotelById(id); // throws if not found

        hotel.setAddress(dto.getAddress());
        hotel.setCity(dto.getCity());
        hotel.setPostalCode(dto.getPostalCode());

        return hotelRepository.save(hotel); // return saved entity
    }

}
