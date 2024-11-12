package com.KT.project.uber.uberApp.service;

import com.KT.project.uber.uberApp.entity.Payment;
import com.KT.project.uber.uberApp.entity.Ride;

public interface PaymentService {

    void processPayment(Payment payment);

    Payment createNewPayment(Ride ride);
}
