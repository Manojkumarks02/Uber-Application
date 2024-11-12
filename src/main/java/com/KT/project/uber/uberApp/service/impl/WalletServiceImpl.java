package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.dto.RideDto;
import com.KT.project.uber.uberApp.dto.WalletDto;
import com.KT.project.uber.uberApp.dto.WalletTransactionDto;
import com.KT.project.uber.uberApp.entity.Ride;
import com.KT.project.uber.uberApp.entity.User;
import com.KT.project.uber.uberApp.entity.Wallet;
import com.KT.project.uber.uberApp.entity.WalletTransaction;
import com.KT.project.uber.uberApp.entity.enums.TransactionMethod;
import com.KT.project.uber.uberApp.entity.enums.TransactionType;
import com.KT.project.uber.uberApp.exception.ResourceNotFoundException;
import com.KT.project.uber.uberApp.repository.WalletRepository;
import com.KT.project.uber.uberApp.service.WalletService;
import com.KT.project.uber.uberApp.service.WalletTransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final WalletTransactionService walletTransactionService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance() + amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.CREDIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        walletTransactionService.createNewWalletTransaction(walletTransaction);
        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public Wallet dedectMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod)  {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance() - amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.DEBIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

//        walletTransactionService.createNewWalletTransaction(walletTransaction);

        wallet.getTransactions().add(walletTransaction);

        return walletRepository.save(wallet);
    }

    @Override
    public void withdrawAllMyMoneyFromWallet() {

    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found with id" +walletId));
    }


    @Override
    public Wallet creatNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findByUser(User user) {
        return  walletRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException( "wallet not found for the user with id"+ user.getId()));

    }
}
