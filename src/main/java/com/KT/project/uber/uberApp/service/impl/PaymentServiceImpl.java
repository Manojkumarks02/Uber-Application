package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.entity.Payment;
import com.KT.project.uber.uberApp.entity.Ride;
import com.KT.project.uber.uberApp.repository.PaymentRepository;
import com.KT.project.uber.uberApp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {


    }

    @Override
    public Payment createNewPayment(Ride ride) {
        return null;
    }
}
