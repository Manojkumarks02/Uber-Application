package com.KT.project.uber.uberApp.strategies;

import com.KT.project.uber.uberApp.entity.RideRequest;

public interface RideFareCalculationStrategy {

  double  RIDE_FARE_MULTIPLIER= 10;

    double calculateFare(RideRequest rideRequest);
}
