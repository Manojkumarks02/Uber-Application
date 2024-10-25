package com.KT.project.uber.uberApp.strategies;

import com.KT.project.uber.uberApp.entity.Driver;
import com.KT.project.uber.uberApp.entity.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy{

    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
