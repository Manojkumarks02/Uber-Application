package com.KT.project.uber.uberApp.service;

import com.KT.project.uber.uberApp.entity.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
