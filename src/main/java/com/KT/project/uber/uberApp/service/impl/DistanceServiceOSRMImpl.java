package com.KT.project.uber.uberApp.service.impl;

import com.KT.project.uber.uberApp.service.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    //https://router.project-osrm.org/route/v1/driving/13.388860,52.517037;13.397634,52.529407?overview=false
    private static final String OSRM_API_BASE_URL = "https://router.project-osrm.org/route/v1/driving/";
    @Override
    public double calculateDistance(Point src, Point dest) {
        //calling third party API called OSRM to fetch the distance

        try{
            String uri = src.getX()+","+ src.getY()+";"+dest.getX()+","+dest.getY();
            OSRMResponseDto responseDto =RestClient.builder()
                    .baseUrl(OSRM_API_BASE_URL)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMResponseDto.class);
            return responseDto.getRoutes().get(0).getDistance()/1000.0;
        }catch (Exception e){
            throw new RuntimeException("error getting data from OSRM"+ e.getMessage());
        }
    }
}

@Data
class OSRMResponseDto{
    private List<OSRMRoute> routes;
}

@Data
class OSRMRoute{
    private Double distance;
}
