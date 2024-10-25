package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.dto.RideDto;
import com.KT.project.uber.uberApp.dto.RideRequestDto;
import com.KT.project.uber.uberApp.entity.Driver;
import com.KT.project.uber.uberApp.entity.RideRequest;
import com.KT.project.uber.uberApp.entity.Rider;
import com.KT.project.uber.uberApp.entity.User;
import com.KT.project.uber.uberApp.entity.enums.RideRequestStatus;
import com.KT.project.uber.uberApp.exception.ResourceNotFoundException;
import com.KT.project.uber.uberApp.repository.RideRequestRepository;
import com.KT.project.uber.uberApp.repository.RiderRepository;
import com.KT.project.uber.uberApp.service.RiderService;
import com.KT.project.uber.uberApp.strategies.impl.RideStrategyManager;
import jakarta.transaction.Transactional;
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
    private final RideStrategyManager rideStrategyManager;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
//        log.info( rideRequest.toString());
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);

        Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare( fare);

        RideRequest saveRideRequest   = rideRequestRepository.save(rideRequest);

        List<Driver> drivers = rideStrategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);

        //todo : send notification to all the drivers about this ride request
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

    @Override
    public Rider getCurrentRider() {
        //todo spring security
        return riderRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(
                "rider not found with id"+ 1
        ));
    }
}
