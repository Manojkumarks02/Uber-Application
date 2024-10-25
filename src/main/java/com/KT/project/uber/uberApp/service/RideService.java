package com.KT.project.uber.uberApp.service;

import com.KT.project.uber.uberApp.dto.RideRequestDto;
import com.KT.project.uber.uberApp.entity.Driver;
import com.KT.project.uber.uberApp.entity.Ride;
import com.KT.project.uber.uberApp.entity.RideRequest;
import com.KT.project.uber.uberApp.entity.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDto rideRequestDto);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Long rideId, RideStatus rideStatus);

   Page<Ride> getAllRidesOfRider(Long rideId, PageRequest pageRequest);

   Page<Ride> getAllRidesOfDriver(Long DriverId, PageRequest pageRequest);
}
