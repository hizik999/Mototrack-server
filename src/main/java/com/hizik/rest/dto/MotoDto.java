package com.hizik.rest.dto;

import com.hizik.domain.Moto;
import com.hizik.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoDto {

    private long id;
    private UserDto userDto;
    private int speed;
    private float latitude;
    private float longitude;
    private float altitude;



    public static MotoDto toDto(Moto moto){

        return new MotoDto(
                moto.getId(),
                UserDto.toDto(moto.getUser()),
                moto.getSpeed(),
                moto.getLatitude(),
                moto.getLongitude(),
                moto.getAltitude()
        );
    }

    public static Moto toDomainObject(MotoDto motoDto){

        return new Moto(
                motoDto.getId(),
                UserDto.toDomainObject(motoDto.getUserDto()),
                motoDto.getSpeed(),
                motoDto.getLatitude(),
                motoDto.getLongitude(),
                motoDto.getAltitude()
        );
    }
}
