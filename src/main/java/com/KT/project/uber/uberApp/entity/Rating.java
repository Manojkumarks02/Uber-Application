package com.KT.project.uber.uberApp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(name = "idx_rating_rider", columnList = "rider_id"),
        @Index(name = "idx_rating_driver", columnList = "driver_id")

})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Ride ride;

    @ManyToOne
    private Rider rider;

    @ManyToOne
    private Driver driver;

    private Integer driverRating;

    private Integer riderRating;
}
