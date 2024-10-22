package com.KT.project.uber.uberApp.repository;

import com.KT.project.uber.uberApp.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
}
