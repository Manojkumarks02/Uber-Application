package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.service.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point dest) {
        //calling third party API called OSRM to fetch the distance

        return 0;
    }
}
