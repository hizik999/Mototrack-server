package com.hizik.service;

import com.hizik.domain.Moto;
import com.hizik.domain.User;
import com.hizik.repository.MotoRepository;
import com.hizik.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LibDemoService {

    private final UserRepository usersRepository;
    private final MotoRepository motosRepository;

    public void usersDemo(){

        List<User> usersList = usersRepository.findAll();
        System.out.println("==========Users==========");

        for (User user : usersList) {
            System.out.println(user.getName());
        }

        System.out.println("========================");

        User user = User.builder()
                .name("Andy")
                .nickname("Scott")
                .email("andyscott@mail.ru")
                .status("moto")
                .build();

        usersRepository.save(user);
        usersList = usersRepository.findAll();

        System.out.println("==========New users==========");

        for (User user1: usersList) {
            System.out.println(user1.getName() + ": " + user1.getStatus());
        }

        System.out.println("=============================");
    }


    @Transactional
    public void motosDemo(){
        insertMotosByUsersStatus();

        List<Moto> motosList = motosRepository.findAll();
        for (Moto motos : motosList) {
            System.out.println("========Moto========");
            System.out.println(motos.getId() + ":");
            System.out.println(motos.getUser().getName() + ", " + motos.getUser().getStatus());
            System.out.println(motos.getSpeed() + "; " +
                    motos.getLatitude() + "; " +
                    motos.getLongitude() + "; " +
                    motos.getAltitude());
            System.out.println("====================");
        }


    }

    @Transactional
    public void insertMotosByUsersStatus(){

        List<User> usersList = usersRepository.findAll();
        int speed = 100;
        for (User user : usersList) {

            if (Objects.equals(user.getStatus(), "moto")) {

                System.out.println("NEW MOTO IS DETECTED");
                Moto moto1 = Moto.builder()
                        .user(user)
                        .speed(speed)
                        .latitude(87.4322f)
                        .longitude(98.42324f)
                        .altitude(218.3123f)
                        .build();

                motosRepository.save(moto1);

                speed += 20;
            }

        }
    }
}
