package com.hizik.service;

import com.hizik.domain.Moto;
import com.hizik.domain.User;
import com.hizik.repository.MotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotoServiceImpl implements MotoService{

    private final MotoRepository motoRepository;

    @Override
    public Moto insert(Moto moto) {

        return motoRepository.save(moto);
    }

    @Override
    public List<Moto> getAll() {

        return motoRepository.findAll();
    }

    @Override
    public Moto getById(long id) {

        return motoRepository.findById(id);
    }

    @Override
    public Moto getByUser(User user) {

        return motoRepository.findByUser(user);
    }

    @Override
    public Moto update(long id, User user, int speed, float latitude, float longitude, float altitude) {

        Moto moto = Moto.builder()
                .id(id)
                .user(user)
                .speed(speed)
                .latitude(latitude)
                .longitude(longitude)
                .altitude(altitude)
                .build();

        return motoRepository.save(moto);
    }

    @Override
    public void deleteById(long id) {

        motoRepository.deleteById(id);
    }

    @Override
    public void deleteByUser(User user) {

        motoRepository.deleteByUser(user);
    }
}
