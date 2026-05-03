package com.example.HotelManagement.Communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//import org.springframework.boot.web.client.RestTemplateBuilder;





@Component
public class RestTemplateCommunicator {

    private  final RestTemplate restTemplate;
    @Autowired
    public RestTemplateCommunicator(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Float getActaulHotelRating(Long hotelid){
        String url = "http://localhost:8084/rating/getratingbyhotelid/"+hotelid;
        ResponseEntity<Float> hotelRating = restTemplate.getForEntity(url,Float.class );
        return hotelRating.getBody();
    }
}
