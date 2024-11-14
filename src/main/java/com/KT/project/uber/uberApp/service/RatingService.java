package com.KT.project.uber.uberApp.service;

import com.KT.project.uber.uberApp.dto.DriverDto;
import com.KT.project.uber.uberApp.dto.RiderDto;
import com.KT.project.uber.uberApp.entity.Driver;
import com.KT.project.uber.uberApp.entity.Ride;
import com.KT.project.uber.uberApp.entity.Rider;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);

    RiderDto  rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);

}
