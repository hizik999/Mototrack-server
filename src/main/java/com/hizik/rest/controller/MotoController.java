package com.hizik.rest.controller;

import com.hizik.domain.Moto;
import com.hizik.domain.User;
import com.hizik.rest.dto.MotoDto;
import com.hizik.service.MotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MotoController {

    private final MotoService motoService;

    @GetMapping("/moto")
    public List<MotoDto> getAllMoto(){

        return motoService.getAll()
                .stream()
                .map(MotoDto::toDto)
                .collect(Collectors.toList());
    }

//    @PostMapping("/moto")
//    public MotoDto insertMoto(@RequestBody MotoDto motoDto){
//
//        Moto moto = motoService.insert(MotoDto.toDomainObject(motoDto));
//        return MotoDto.toDto(moto);
//    }

    @PostMapping("/moto")
    public MotoDto insertMoto(
            @RequestParam String user_id,
            @RequestParam String speed,
            @RequestParam String latitude,
            @RequestParam String longitude,
            @RequestParam String altitude
    ){
        long user_id1 = Long.valueOf(user_id).longValue();
        //System.out.println(user_id1);
        int speed1 = Integer.parseInt(speed);
        float latitude1 = Float.parseFloat(latitude);
        float longitude1 = Float.parseFloat(longitude);
        float altitude1 = Float.parseFloat(altitude);

        Moto moto = motoService.insert(user_id1, speed1, latitude1, longitude1, altitude1);
        return MotoDto.toDto(moto);
    }
    
    @PutMapping("/moto/{id}")
    public MotoDto updateMoto(@PathVariable long id,
                              @RequestParam long user_id,
                              @RequestParam int speed,
                              @RequestParam float latitude,
                              @RequestParam float longitude,
                              @RequestParam float altitude){

        Moto moto = motoService.update(id, user_id, speed, latitude, longitude, altitude);
        return MotoDto.toDto(moto);
    }

    @PutMapping("/moto/speed/{id}")
    public MotoDto updateSpeed(@PathVariable long id,
                                @RequestParam int speed){

        Moto moto = motoService.update(
                id,
                motoService.getById(id).getId(),
                speed,
                motoService.getById(id).getLatitude(),
                motoService.getById(id).getLongitude(),
                motoService.getById(id).getAltitude()
        );
        return MotoDto.toDto(moto);
    }

    @PutMapping("/moto/latlonalt/{id}")
    public MotoDto updateLatLonAlt(@PathVariable long id,
                                   @RequestParam float lat,
                                   @RequestParam float lon,
                                   @RequestParam float alt){

        Moto moto = motoService.updateLatLonAlt(id, lat, lon, alt);
        return MotoDto.toDto(moto);
    }

    @GetMapping("/moto/distance/{id}")
    public float getDistance(@PathVariable long id,
                           @RequestParam float endLon,
                           @RequestParam float endLat){

        float distance = motoService.findDistance(
                motoService.getById(id).getLatitude(),
                motoService.getById(id).getLongitude(),
                endLon,
                endLat
        );
        return distance;
    }

    @GetMapping("/moto/{id}")
    public MotoDto getMotoById(@PathVariable long id){

        Moto moto = motoService.getById(id);
        return MotoDto.toDto(moto);
    }

    @DeleteMapping("/moto/{id}")
    public void deleteMoto(@PathVariable long id){

        motoService.deleteById(id);
    }

}
