package com.KT.project.uber.uberApp.strategies.impl;

import com.KT.project.uber.uberApp.dto.RideRequestDto;
import com.KT.project.uber.uberApp.entity.RideRequest;
import com.KT.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculate(RideRequest rideRequest)  {
        return 0;
    }
}
