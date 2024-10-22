package com.KT.project.uber.uberApp.service;

import com.KT.project.uber.uberApp.dto.DriverDto;
import com.KT.project.uber.uberApp.dto.RideDto;
import com.KT.project.uber.uberApp.dto.RideRequestDto;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);
    RideDto cancelRide(Long rideId);

    RideDto rateDriver(Long rideId, Integer rating);

    RideDto getMyProfile();

    List<RideDto> getAllMyRide();
}
