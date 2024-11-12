package com.KT.project.uber.uberApp.dto;

import com.KT.project.uber.uberApp.entity.enums.TransactionMethod;
import com.KT.project.uber.uberApp.entity.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletTransactionDto {

    private Long id;
    private Double amount;
    private TransactionType transactionType;
    private TransactionMethod transactionMethod;
    private RideDto rideDto;
    private String transactionId;
    private WalletDto walletDto;
    private LocalDateTime timeStamp;
}
