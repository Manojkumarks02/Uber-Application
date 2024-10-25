package com.KT.project.uber.uberApp.dto;

import com.KT.project.uber.uberApp.entity.Rider;
import com.KT.project.uber.uberApp.entity.enums.PaymentMethod;
import com.KT.project.uber.uberApp.entity.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {
    private Long id;
    private PointDto pickupLocation;
    private PointDto dropoffLocation;
    private LocalDateTime requestedTime;
    private Rider rider;
    private PaymentMethod paymentMethod;
    private RideRequestStatus rideRequestStatus;
    private Double fare;
}