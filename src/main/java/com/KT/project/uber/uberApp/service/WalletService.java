package com.KT.project.uber.uberApp.service;

import com.KT.project.uber.uberApp.entity.Ride;
import com.KT.project.uber.uberApp.entity.User;
import com.KT.project.uber.uberApp.entity.Wallet;
import com.KT.project.uber.uberApp.entity.enums.TransactionMethod;

public interface WalletService{

    Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) ;

    Wallet dedectMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) ;

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet creatNewWallet(User user);

    Wallet findByUser(User user);
}
