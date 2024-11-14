package com.KT.project.uber.uberApp.controller;

import com.KT.project.uber.uberApp.dto.*;
import com.KT.project.uber.uberApp.service.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController  {

    private final RiderService riderService;

    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto){
        return new ResponseEntity<>(riderService.requestRide(rideRequestDto), HttpStatus.CREATED) ;
    }

    @PostMapping("/cancelRide/{rideId}")
    public  ResponseEntity<RideDto> cancelRide(@PathVariable Long rideId){
        return ResponseEntity.ok(riderService.cancelRide( rideId));
    }

    @PostMapping("/rateDriver")
    public ResponseEntity<DriverDto> rateDriver(@RequestBody RatingDto ratingDto){
        return ResponseEntity.ok(riderService.rateDriver(ratingDto.getRideId(), ratingDto.getRating()));
    }

    @GetMapping("/getMyProfile")
    public ResponseEntity<RideDto> getMyProfile(){
        return ResponseEntity.ok(riderService.getMyProfile());
    }

    @GetMapping("/getMyRides")
    public ResponseEntity<Page<RideDto>> getAllMyRides(@RequestParam(defaultValue = "0") Integer pageOffSet,
                                                       @RequestParam(defaultValue = "10", required = false) Integer pageSize){
        PageRequest pageRequest = PageRequest.of(pageOffSet, pageSize, Sort.by(Sort.Direction.DESC, "createdTime", "id "));
        return ResponseEntity.ok(riderService.getAllMyRide(pageRequest));

    }

    //    @PostMapping("/rateDriver/{rideId}/{rating}")
    //    public ResponseEntity<DriverDto> rateDriver(@PathVariable Long rideId, @PathVariable Integer rating){
    //        return ResponseEntity.ok(riderService.rateDriver(rideId,rating));
    //    }

}
