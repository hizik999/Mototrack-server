package com.hizik.repository;

import com.hizik.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository usersRepository;

    @DisplayName("Insert User")
    @Test
    void shouldInsertUser(){

        User expectedUser = User.builder()
                .name("Test")
                .nickname("Test")
                .id(5)
                .email("amalyshev@mail.ru")
                .status("moto")

                .build();
        usersRepository.save(expectedUser);
        User actualUser = usersRepository.findById(5);

        assertThat(actualUser).isEqualTo(expectedUser);

    }

    @DisplayName("Delete user")
    @Test
    void shouldDeleteUser(){
        int prev_size = usersRepository.findAll().size();
        usersRepository.deleteById(1);
        int actual_size = usersRepository.findAll().size();

        assertThat(prev_size).isEqualTo(actual_size + 1);
    }

    @DisplayName("Update user status")
    @Test
    void shouldUpdateUserStatus(){

        List<User> usersCar = usersRepository.findByStatus("car");
        User car_user = usersCar.get(0);

        List<User> usersMoto = usersRepository.findByStatus("moto");
        User moto_user = usersMoto.get(0);

        car_user.setStatus("moto");

        assertThat(car_user.getStatus()).isEqualTo(moto_user.getStatus());
    }
}
