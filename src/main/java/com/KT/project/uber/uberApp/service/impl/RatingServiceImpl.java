package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.dto.DriverDto;
import com.KT.project.uber.uberApp.dto.RiderDto;
import com.KT.project.uber.uberApp.entity.Driver;
import com.KT.project.uber.uberApp.entity.Rating;
import com.KT.project.uber.uberApp.entity.Ride;
import com.KT.project.uber.uberApp.entity.Rider;
import com.KT.project.uber.uberApp.exception.ResourceNotFoundException;
import com.KT.project.uber.uberApp.repository.DriverRepository;
import com.KT.project.uber.uberApp.repository.RatingRepository;
import com.KT.project.uber.uberApp.repository.RiderRepository;
import com.KT.project.uber.uberApp.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    private final ModelMapper modelMapper;

    @Override
    public DriverDto rateDriver(Ride ride, Integer rating) {
        Driver driver =ride.getDriver();
        Rating ratingObj = ratingRepository.findByRide(ride)
                .orElseThrow(() -> new ResourceNotFoundException("rating not found for ride with id : " + ride.getId()));

        ratingObj.setDriverRating(rating);
        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByDriver(driver)
                .stream()
                .mapToDouble(Rating :: getDriverRating)
                .average().orElse(0.0);

        driver.setRating(newRating);
        Driver savedDriver = driverRepository.save(driver);
        return modelMapper.map(savedDriver, DriverDto.class);

    }

    @Override
    public RiderDto rateRider(Ride ride,  Integer rating) {

        Rider rider = ride.getRider();
        Rating ratingObj = ratingRepository.findByRide(ride)
                .orElseThrow(() -> new ResourceNotFoundException("rating not found for ride with id : " + ride.getId()));

        ratingObj.setRiderRating(rating);
        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByRider(rider)
                .stream()
                .mapToDouble(Rating :: getDriverRating)
                .average().orElse(0.0);

        rider.setRating(newRating);

        Rider savedRider = riderRepository.save(rider);
        return modelMapper.map(savedRider, RiderDto.class);
    }

    @Override
    public void createNewRating(Ride ride) {
        Rating rating = Rating.builder()
                .rider(ride.getRider())
                .driver(ride.getDriver())
                .ride(ride)
                .build();

        ratingRepository.save(rating);
    }
}
