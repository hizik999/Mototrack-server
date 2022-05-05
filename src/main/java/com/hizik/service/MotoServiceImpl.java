package com.hizik.service;

import com.hizik.domain.Moto;
import com.hizik.domain.User;
import com.hizik.repository.MotoRepository;
import com.hizik.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotoServiceImpl implements MotoService{

    private final MotoRepository motoRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public Moto insert(Moto moto) {

        return motoRepository.save(moto);
    }

    @Transactional
    @Override
    public Moto insert(long idUser, int speed, float latitude, float longitude, float altitude) {

        User user = userRepository.findById(idUser);
        Moto moto = Moto.builder()
                .user(user)
                .speed(speed)
                .latitude(latitude)
                .longitude(longitude)
                .altitude(altitude)
                .build();
        return motoRepository.save(moto);
    }

    @Transactional
    @Override
    public List<Moto> getAll() {

        return motoRepository.findAll();
    }

    @Transactional
    @Override
    public Moto getById(long id) {

        return motoRepository.findById(id);
    }

    @Transactional
    @Override
    public Moto getByUser(User user) {

        return motoRepository.findByUser(user);
    }

    @Transactional
    @Override
    public Moto update(long id, long idUser, int speed, float latitude, float longitude, float altitude) {

        User user = userRepository.findById(idUser);
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

    @Transactional
    @Override
    public Moto updateLatLonAlt(long id, float latitude, float longitude, float altitude) {

        User user = motoRepository.findById(id).getUser();
        Moto moto = Moto.builder()
                .id(id)
                .user(user)
                .speed(motoRepository.findById(id).getSpeed())
                .latitude(latitude)
                .longitude(longitude)
                .altitude(altitude)
                .build();
        return motoRepository.save(moto);
    }

    @Transactional
    @Override
    public float findDistance(float startLatitude, float startLongitude, float endLatitude, float endLongitude) {

        float distance = (float) Math.acos(Math.sin(startLatitude) * Math.sin(endLatitude)
                + Math.cos(startLatitude) * Math.cos(endLatitude) * Math.cos(startLongitude - endLongitude));
        return distance * 6371;
    }

    @Transactional
    @Override
    public void deleteById(long id) {

        motoRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByUser(User user) {

        motoRepository.deleteByUser(user);
    }
}
