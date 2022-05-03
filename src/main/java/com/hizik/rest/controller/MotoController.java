package com.hizik.rest.controller;

import com.hizik.domain.Moto;
import com.hizik.domain.User;
import com.hizik.rest.dto.MotoDto;
import com.hizik.rest.dto.UserDto;
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

    @PostMapping("/moto")
    public MotoDto insertMoto(@RequestBody MotoDto motoDto){

        Moto moto = motoService.insert(MotoDto.toDomainObject(motoDto));
        return MotoDto.toDto(moto);
    }
    
    @PutMapping("/moto/{id}")
    public MotoDto updateMoto(@PathVariable long id,
                              @RequestParam User user,
                              @RequestParam int speed,
                              @RequestParam float latitude,
                              @RequestParam float longitude,
                              @RequestParam float altitude){

        Moto moto = motoService.update(id, user, speed, latitude, longitude, altitude);
        return MotoDto.toDto(moto);
    }

    @PutMapping("/moto/speed/{id}")
    public MotoDto updateSpeed(@PathVariable long id,
                                @RequestParam int speed){

        Moto moto = motoService.update(
                id,
                motoService.getById(id).getUser(),
                speed,
                motoService.getById(id).getLatitude(),
                motoService.getById(id).getLongitude(),
                motoService.getById(id).getAltitude()
        );
        return MotoDto.toDto(moto);
    }

    @GetMapping("/moto/{id}")
    public MotoDto getMotoById(@PathVariable long id){

        Moto moto = motoService.getById(id);
        return MotoDto.toDto(moto);
    }

    @DeleteMapping("/user/{id}")
    public void deleteMoto(@PathVariable long id){

        motoService.deleteById(id);
    }

}
