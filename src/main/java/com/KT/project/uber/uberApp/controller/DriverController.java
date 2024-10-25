package com.KT.project.uber.uberApp.controller;


import com.KT.project.uber.uberApp.dto.RideDto;
import com.KT.project.uber.uberApp.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/accpetRide/{rideRequestId}")
    public ResponseEntity<RideDto> acceptRide(@PathVariable Long rideRequestId){
        return  ResponseEntity.ok(driverService.acceptRide(rideRequestId));


    }
}
