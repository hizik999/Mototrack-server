package com.hizik.repository;

import com.hizik.domain.Motos;
import com.hizik.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class MotosRepositoryTest {

    @Autowired
    private MotosRepository motosRepository;

    @Autowired
    private UsersRepository usersRepository;

    @DisplayName("Insert moto by user status")
    @Test
    void shouldInsertMotoByUserId(){

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


    @DisplayName("Should delete moto by Users user")
    @Test
    void shouldDeleteMotoByUserId(){

        shouldInsertMotoByUserId();

        List<Users> usersList = usersRepository.findByStatus("moto");
        Users userToDelete = usersList.get(0);
        System.out.println("User to delete = " + userToDelete.getName() + ": " + userToDelete.getStatus());

        int prev_size = motosRepository.findAll().size();
        System.out.println("Previous size = " + prev_size);

        motosRepository.deleteByUsers(userToDelete);
        int actual_size = motosRepository.findAll().size();
        System.out.println("Actual size = " + actual_size);

        assertThat(prev_size).isEqualTo(actual_size + 1);
    }


    @DisplayName("Should update moto's values")
    @Test
    void shouldUpdateMotosValues(){

        shouldInsertMotoByUserId();

        List<Motos> motosList = motosRepository.findAll();

        Motos moto1 = motosList.get(0);
        System.out.println("Moto 1 speed: " + moto1.getSpeed());

        Motos moto2 = motosList.get(motosList.size() - 1);
        System.out.println("Moto 2 speed: " + moto2.getSpeed());

        moto1.setSpeed(moto2.getSpeed());

        assertThat(moto1.getSpeed()).isEqualTo(moto2.getSpeed());
    }
}
