package com.KT.project.uber.uberApp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.geolatte.geom.Point;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(indexes= {
//        @Index(name="")
//})
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;

    private Boolean available;

    private  String vehicleId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "Geometry(Point,4326)")  // deals with the earth geometry
    private Point currentLocation;
}
