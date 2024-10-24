package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.dto.RideDto;
import com.KT.project.uber.uberApp.dto.RideRequestDto;
import com.KT.project.uber.uberApp.entity.RideRequest;
import com.KT.project.uber.uberApp.entity.Rider;
import com.KT.project.uber.uberApp.entity.User;
import com.KT.project.uber.uberApp.entity.enums.RideRequestStatus;
import com.KT.project.uber.uberApp.repository.RideRequestRepository;
import com.KT.project.uber.uberApp.repository.RiderRepository;
import com.KT.project.uber.uberApp.service.RiderService;
import com.KT.project.uber.uberApp.strategies.DriverMatchingStrategy;
import com.KT.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideFareCalculationStrategy rideFareCalculationStrategy;
    private final DriverMatchingStrategy driverMatchingStrategy;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
//        log.info( rideRequest.toString());
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        Double fare = rideFareCalculationStrategy.calculate(rideRequest);
        rideRequest.setFare( fare);

        RideRequest saveRideRequest   = rideRequestRepository.save(rideRequest);

        driverMatchingStrategy.findMatchingDriver(rideRequest);

        return modelMapper.map(saveRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RideDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRide() {
        return null;
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider.builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }
}
