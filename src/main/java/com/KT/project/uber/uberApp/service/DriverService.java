package com.KT.project.uber.uberApp.service;

import com.KT.project.uber.uberApp.dto.DriverDto;
import com.KT.project.uber.uberApp.dto.RideDto;
import com.KT.project.uber.uberApp.entity.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface DriverService {

    RideDto acceptRide(Long rideRequestId);
    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId, String otp);

    RideDto endRide(Long rideId);

    RideDto rateRider(Long rideId, Integer rating);

    DriverDto getMyProfile();

    Page<RideDto> getAllMyRide(PageRequest pageRequest);

    Driver getCurrentDriver();

    Driver updateDriverAvailability(Driver driver, boolean available);
}
