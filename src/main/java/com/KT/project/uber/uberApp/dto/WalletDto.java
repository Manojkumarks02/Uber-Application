package com.KT.project.uber.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {

    private Long id;

    private UserDto userDto;

    private Double balance;

    private List<WalletTransactionDto> transactions;
}
