package com.hizik.service;

import com.hizik.domain.Motos;
import com.hizik.domain.Users;
import com.hizik.repository.MotosRepository;
import com.hizik.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LibDemoService {

    private final UsersRepository usersRepository;
    private final MotosRepository motosRepository;

    public void usersDemo(){

        List<Users> usersList = usersRepository.findAll();
        System.out.println("==========Users==========");

        for (Users user : usersList) {
            System.out.println(user.getName());
        }

        System.out.println("========================");

        Users user = Users.builder()
                .name("Andy")
                .nickname("Scott")
                .email("andyscott@mail.ru")
                .status("moto")
                .build();

        usersRepository.save(user);
        usersList = usersRepository.findAll();

        System.out.println("==========New users==========");

        for (Users user1: usersList) {
            System.out.println(user1.getName() + ": " + user1.getStatus());
        }

        System.out.println("=============================");
    }


    @Transactional
    public void motosDemo(){
        insertMotosByUsersStatus();

        List<Motos> motosList = motosRepository.findAll();
        for (Motos motos : motosList) {
            System.out.println("========Moto========");
            System.out.println(motos.getId() + ":");
            System.out.println(motos.getUsers().getName() + ", " + motos.getUsers().getStatus());
            System.out.println(motos.getSpeed() + "; " +
                    motos.getLatitude() + "; " +
                    motos.getLongitude() + "; " +
                    motos.getAltitude());
            System.out.println("====================");
        }


    }

    public void insertMotosByUsersStatus(){

        List<Users> usersList = usersRepository.findAll();
        int speed = 100;
        for (Users user : usersList) {

            if (Objects.equals(user.getStatus(), "moto")) {

                System.out.println("NEW MOTO IS DETECTED");
                Motos moto1 = Motos.builder()
                        .users(user)
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
