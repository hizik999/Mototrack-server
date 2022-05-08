package com.hizik.service;

import com.hizik.domain.Moto;
import com.hizik.domain.User;

import java.util.List;

public interface MotoService {

    Moto insert(Moto moto);

    Moto insert(long user_id, int speed, float latitude, float longitude, float altitude);

    List<Moto> getAll();

    Moto getById(long id);

    Moto getByUser(User user);

    Moto update(
           long id,
           long idUser,
           int speed,
           float latitude,
           float longitude,
           float altitude
    );

    Moto updateLatLonAlt(
            long id,
            float latitude,
            float longitude,
            float altitude
    );

    float findDistance(float startLatitude, float startLongitude, float endLatitude, float endLongitude);

    void deleteById(long id);

    void deleteByUser(User user);
}
