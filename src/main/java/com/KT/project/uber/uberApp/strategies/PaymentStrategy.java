package com.KT.project.uber.uberApp.strategies;

import com.KT.project.uber.uberApp.entity.Payment;

public interface PaymentStrategy {

    Double  PLATFORM_COMMISSION = 0.3;

    void processPayment(Payment payment);
}
