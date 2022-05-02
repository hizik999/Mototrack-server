package com.hizik.service;

import com.hizik.domain.Moto;
import com.hizik.domain.User;

import java.util.List;

public interface MotoService {

    Moto insert(Moto moto);

    List<Moto> getAll();

    Moto getById(long id);

    Moto getByUser(User user);

    Moto update(
           long id,
           User user,
           int speed,
           float latitude,
           float longitude,
           float altitude
    );

    void deleteById(long id);

    void deleteByUser(User user);
}
