package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.dto.DriverDto;
import com.KT.project.uber.uberApp.dto.RideDto;
import com.KT.project.uber.uberApp.entity.Driver;
import com.KT.project.uber.uberApp.entity.Ride;
import com.KT.project.uber.uberApp.entity.RideRequest;
import com.KT.project.uber.uberApp.entity.enums.RideRequestStatus;
import com.KT.project.uber.uberApp.entity.enums.RideStatus;
import com.KT.project.uber.uberApp.exception.ResourceNotFoundException;
import com.KT.project.uber.uberApp.repository.DriverRepository;
import com.KT.project.uber.uberApp.service.DriverService;
import com.KT.project.uber.uberApp.service.RideRequestService;
import com.KT.project.uber.uberApp.service.RideService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final RideRequestService rideRequestService;
    private final DriverRepository driverRepository;
    private final RideService rideService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public RideDto acceptRide(Long rideRequestId) {
        RideRequest rideRequest = rideRequestService.findRideRequestById(rideRequestId);

        if( !rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)){
            throw new RuntimeException("Ride request cannot be accepted, status is :" + rideRequest.getRideRequestStatus());
        }

        Driver currentDriver = getCurrentDriver();
        if(!currentDriver.getAvailable()){
            throw new RuntimeException("driver cannot accept ride due to unavailability :");
        }

       Driver savedDriver = updateDriverAvailability(currentDriver, false);

        Ride ride = rideService.createNewRide(rideRequest, savedDriver);
        return modelMapper.map(ride, RideDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
       Ride ride = rideService.getRideById(rideId);
        Driver driver = getCurrentDriver();

        if( !driver.equals(ride.getDriver())){
            throw  new RuntimeException("driver cannot start a ride as he has not accept it earlier");
        }

        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException(" Ride cannot be cancelled, invalid status "+ride.getRideStatus());
        }

        rideService.updateRideStatus(ride,RideStatus.CANCELLED);
        updateDriverAvailability(driver,true);

        return modelMapper.map(ride, RideDto.class);

    }

    @Override
    public RideDto startRide(Long rideId, String otp) {

        Ride ride = rideService.getRideById(rideId);
        Driver driver = getCurrentDriver();

        if( !driver.equals(ride.getDriver())){
            throw  new RuntimeException("driver cannot start a ride as he has not accept it earlier");
        }

        if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw  new RuntimeException("Ride Status is not confirmed hence cannot be started, status :"+ride.getRideStatus());
        }

        if(!otp.equals(ride.getOtp())){
            throw new RuntimeException("Otp is not valid, otp: "+otp );
        }

        ride.setStartedAt(LocalDateTime.now());
        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);
        return modelMapper.map(savedRide, RideDto.class);
    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDto getMyProfile() {
        Driver currentDriver = getCurrentDriver();
        return modelMapper.map(currentDriver, DriverDto.class);
    }

    @Override
    public Page<RideDto> getAllMyRide(PageRequest pageRequest) {
        Driver currentDriver = getCurrentDriver();
        return  rideService.getAllRidesOfDriver(currentDriver.getId(),pageRequest).map(
                ride -> modelMapper.map(ride, RideDto.class)
        );
    }

    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException("Driver not found with id :"+2));
    }

    @Override
    public Driver updateDriverAvailability(Driver driver, boolean available) {
        driver.setAvailable(available);
        driverRepository.save(driver);
    }
}
