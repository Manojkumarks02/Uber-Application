package com.KT.project.uber.uberApp.strategies.impl;

import com.KT.project.uber.uberApp.entity.Driver;
import com.KT.project.uber.uberApp.entity.RideRequest;
import com.KT.project.uber.uberApp.repository.DriverRepository;
import com.KT.project.uber.uberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }
}
