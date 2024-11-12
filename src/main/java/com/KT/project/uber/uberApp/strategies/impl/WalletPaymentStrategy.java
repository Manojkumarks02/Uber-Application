package com.KT.project.uber.uberApp.strategies.impl;

import com.KT.project.uber.uberApp.entity.Payment;
import com.KT.project.uber.uberApp.strategies.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service
public class WalletPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(Payment payment) {

    }
}
