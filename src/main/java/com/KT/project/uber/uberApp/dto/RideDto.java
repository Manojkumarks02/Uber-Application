package com.KT.project.uber.uberApp.dto;

import com.KT.project.uber.uberApp.entity.enums.PaymentMethod;
import com.KT.project.uber.uberApp.entity.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {

    private Long id;
    private PointDto pickupLocation;
    private PointDto dropoffLocation;
    private LocalDateTime createdTime;
    private RiderDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;
    private RideStatus rideStatus;
    private String otp;
    private Double fare;
    private LocalDateTime  startedAt;
    private LocalDateTime  endedAt;
}
