package com.KT.project.uber.uberApp.strategies.impl;

import com.KT.project.uber.uberApp.entity.RideRequest;
import com.KT.project.uber.uberApp.service.DistanceService;
import com.KT.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;
    private static final double SURGE_FACTOR = 2;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropoffLocation());
        return distance*RIDE_FARE_MULTIPLIER ;
    }
}
