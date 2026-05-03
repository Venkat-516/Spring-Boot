package com.example.HotelManagement.Entity;


import com.example.HotelManagement.Exception.HotelNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.context.request.WebRequest;


@Data
public class HotelNotFound {
    private String errorDetails;
    private String errorMessage;
    private int status;

    public HotelNotFound(String errorDetails, String errorMessage, int status){
        this.errorDetails=errorDetails;
        this.errorMessage =errorMessage;
        this.status = status;
    }

}
