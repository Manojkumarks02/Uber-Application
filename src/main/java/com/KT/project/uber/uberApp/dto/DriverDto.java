package com.KT.project.uber.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto{

    private Long id;
    private UserDto user;
    private double rating;
    private Boolean available;
    private  String vehicleId;

}

