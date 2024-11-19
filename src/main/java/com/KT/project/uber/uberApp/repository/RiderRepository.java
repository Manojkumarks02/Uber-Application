package com.KT.project.uber.uberApp.repository;

import com.KT.project.uber.uberApp.entity.Ride;
import com.KT.project.uber.uberApp.entity.Rider;
import com.KT.project.uber.uberApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
     Optional<Rider> findByUser(User user);
}
