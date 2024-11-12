package com.KT.project.uber.uberApp.repository;

import com.KT.project.uber.uberApp.entity.User;
import com.KT.project.uber.uberApp.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUser(User user);
}
