package com.hizik.repository;

import com.hizik.domain.Motos;
import com.hizik.domain.Users;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotosRepository extends JpaRepository<Motos, Integer> {

    @Override
    @EntityGraph(attributePaths = {"users"})
    List<Motos> findAll();

    Motos findByUsers(Users users);
    Motos findBySpeed(int speed);
    Motos findById(long id);

    void deleteById(long id);
    void deleteByUsers(Users user);

}
