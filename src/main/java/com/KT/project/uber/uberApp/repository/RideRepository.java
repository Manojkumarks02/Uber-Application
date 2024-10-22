package com.KT.project.uber.uberApp.repository;

import com.KT.project.uber.uberApp.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}
