package com.KT.project.uber.uberApp.strategies;

import com.KT.project.uber.uberApp.dto.RideRequestDto;

public interface RideFareCalculationStrategy {

    double calculate (RideRequestDto rideRequestDto);
}
