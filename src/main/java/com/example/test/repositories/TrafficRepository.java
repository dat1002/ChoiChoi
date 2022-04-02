package com.example.test.repositories;

import com.example.test.models.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TrafficRepository extends JpaRepository<Traffic,Integer> {
    Traffic findByLicensePlate(String licensePlate);
    Traffic deleteByLicensePlate(String licensePlate);
    Set<Traffic> findAllByUserTraffic(Integer idUser);


}
