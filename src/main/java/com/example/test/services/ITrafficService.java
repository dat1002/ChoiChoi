package com.example.test.services;

import com.example.test.dtos.TrafficDTO;
import com.example.test.models.Traffic;
import com.example.test.payload.AuthenticationRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface ITrafficService {
    Traffic createNewTraffic(TrafficDTO trafficDTO, Integer idUser);
    Traffic deleteTrafficById(Integer idTraffic);
    Set<Traffic> getAllTrafficByIdUser(Integer idUser);
    Set<Traffic> getAllTraffic();
    Traffic editTrafficById(TrafficDTO trafficDTO, Integer idTraffic);
    Traffic editAvatarTrafficById(MultipartFile file, Integer idTraffic);


}
