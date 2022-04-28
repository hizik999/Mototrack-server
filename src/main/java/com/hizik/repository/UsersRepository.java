package com.hizik.repository;

import com.hizik.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByName(String name);
    Users findByNickname(String nickname);
    Users findByEmail(String email);
    Users findById(long id);

    List<Users> findByStatus(String status);

    void deleteById(long id);
}
