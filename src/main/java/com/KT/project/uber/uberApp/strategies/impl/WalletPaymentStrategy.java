package com.KT.project.uber.uberApp.strategies.impl;

import com.KT.project.uber.uberApp.entity.Driver;
import com.KT.project.uber.uberApp.entity.Payment;
import com.KT.project.uber.uberApp.entity.Rider;
import com.KT.project.uber.uberApp.entity.enums.PaymentStatus;
import com.KT.project.uber.uberApp.entity.enums.TransactionMethod;
import com.KT.project.uber.uberApp.service.PaymentService;
import com.KT.project.uber.uberApp.service.WalletService;
import com.KT.project.uber.uberApp.strategies.PaymentStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentService paymentService;

    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.dedectMoneyFromWallet(rider.getUser(),
                payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE );

        double driverCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(),
                driverCut,null,payment.getRide(),TransactionMethod.RIDE);

        paymentService.updatePaymentStatus(payment, PaymentStatus.CONFIRMED);

    }
}
