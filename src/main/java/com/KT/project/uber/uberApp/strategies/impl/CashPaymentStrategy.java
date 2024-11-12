package com.KT.project.uber.uberApp.strategies.impl;

import com.KT.project.uber.uberApp.entity.Driver;
import com.KT.project.uber.uberApp.entity.Payment;
import com.KT.project.uber.uberApp.entity.Wallet;
import com.KT.project.uber.uberApp.entity.enums.PaymentStatus;
import com.KT.project.uber.uberApp.entity.enums.TransactionMethod;
import com.KT.project.uber.uberApp.repository.PaymentRepository;
import com.KT.project.uber.uberApp.service.PaymentService;
import com.KT.project.uber.uberApp.service.WalletService;
import com.KT.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;
    @Override
    public void processPayment(Payment payment ) {

        Driver driver = payment.getRide().getDriver();
        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.dedectMoneyFromWallet(driver.getUser(),platformCommission, null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);    }
}
