package com.KT.project.uber.uberApp.repository;

import com.KT.project.uber.uberApp.entity.Payment;
import com.KT.project.uber.uberApp.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByRide(Ride ride);
}
