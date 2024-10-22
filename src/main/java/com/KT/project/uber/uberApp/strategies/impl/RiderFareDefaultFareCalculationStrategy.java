package com.KT.project.uber.uberApp.strategies.impl;

import com.KT.project.uber.uberApp.dto.RideRequestDto;
import com.KT.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculate(RideRequestDto rideRequestDto) {
        return 0;
    }
}
