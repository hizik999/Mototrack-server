package com.hizik.repository;

import com.hizik.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
    User findByNickname(String nickname);
    User findByEmail(String email);
    User findById(long id);

    List<User> findByStatus(String status);

    void deleteById(long id);
}
