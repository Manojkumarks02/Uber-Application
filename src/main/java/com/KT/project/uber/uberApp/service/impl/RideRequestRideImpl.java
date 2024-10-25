package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.entity.RideRequest;
import com.KT.project.uber.uberApp.exception.ResourceNotFoundException;
import com.KT.project.uber.uberApp.repository.RideRequestRepository;
import com.KT.project.uber.uberApp.service.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestRideImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Ride Request not found with this id : "+ rideRequestId)) ;
    }

    @Override
    public void update(RideRequest rideRequest) {
        RideRequest toSave = rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException(" Ride request not found with id: " +rideRequest.getId()));
        rideRequestRepository.save(rideRequest);

    }
}
