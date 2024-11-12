package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.dto.WalletTransactionDto;
import com.KT.project.uber.uberApp.entity.WalletTransaction;
import com.KT.project.uber.uberApp.repository.WalletTransactionRepository;
import com.KT.project.uber.uberApp.service.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;
    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
        walletTransactionRepository.save(walletTransaction);
    }
}
