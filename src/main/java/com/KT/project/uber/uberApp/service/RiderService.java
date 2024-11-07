package com.KT.project.uber.uberApp.service;

import com.KT.project.uber.uberApp.dto.RideDto;
import com.KT.project.uber.uberApp.dto.RideRequestDto;
import com.KT.project.uber.uberApp.entity.Rider;
import com.KT.project.uber.uberApp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);
    RideDto cancelRide(Long rideId);

    RideDto rateDriver(Long rideId, Integer rating);

    RideDto getMyProfile();

    Page<RideDto> getAllMyRide(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();

}
