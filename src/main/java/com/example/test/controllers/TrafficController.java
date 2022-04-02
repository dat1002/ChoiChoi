package com.example.test.controllers;

import com.example.test.bases.BaseController;
import com.example.test.dtos.BorrowerDTO;
import com.example.test.dtos.TrafficDTO;
import com.example.test.models.Traffic;
import com.example.test.services.ITrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/traffic")
public class TrafficController extends BaseController<Traffic> {
    @Autowired
    private ITrafficService trafficService;

    @PostMapping("/{idUser}")
    public ResponseEntity<?> createNewTraffic(@RequestBody @Valid TrafficDTO trafficDTO, @PathVariable( name = "idUser") Integer idUser){
        return this.resSuccess(trafficService.createNewTraffic(trafficDTO, idUser));
    }

    @DeleteMapping("/delete/{idTraffic}")
    public ResponseEntity<?> deleteTrafficById(@PathVariable(name ="idTraffic") Integer idTraffic ){
        return this.resSuccess(trafficService.deleteTrafficById(idTraffic));
    }

    @GetMapping("/get-all-traffic-by-IdUser/{idUser}")
    public ResponseEntity<?> getAllTrafficByIdUser(@PathVariable(name="idUser") Integer idUser){
        return this.resSetSuccess(trafficService.getAllTrafficByIdUser(idUser));
    }

    @GetMapping("/get-all-traffic")
    public ResponseEntity<?> getAllTraffic( ){
        return this.resSetSuccess(trafficService.getAllTraffic());
    }

    @PatchMapping("/edit-traffic-by-Id/{idTraffic}")
    public ResponseEntity<?> editTrafficById(@RequestBody TrafficDTO trafficDTO ,@PathVariable(name = "idTraffic" ) Integer idTraffic){
        return  this.resSuccess(trafficService.editTrafficById(trafficDTO,idTraffic));
    }

    @PatchMapping("/edit-avater-traffic-by-id/{idTraffic}")
    public ResponseEntity<?> editAvatarTrafficById(@RequestParam("avatarTraffic")MultipartFile file, @PathVariable(name = "idTraffic") Integer idTraffic){
        return this.resSuccess(trafficService.editAvatarTrafficById(file,idTraffic));
    }

}
