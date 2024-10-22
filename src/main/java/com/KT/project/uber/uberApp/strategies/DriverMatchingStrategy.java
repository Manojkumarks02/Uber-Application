package com.KT.project.uber.uberApp.strategies;

import com.KT.project.uber.uberApp.dto.RideRequestDto;
import com.KT.project.uber.uberApp.entity.Driver;

import java.util.List;

public interface DriverMatchingStrategy{

    List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
