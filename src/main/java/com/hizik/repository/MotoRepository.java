package com.hizik.repository;

import com.hizik.domain.Moto;
import com.hizik.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoRepository extends JpaRepository<Moto, Integer> {

    @Override
    @EntityGraph(attributePaths = {"user"})
    List<Moto> findAll();

    Moto findByUser(User user);
    Moto findBySpeed(int speed);
    Moto findById(long id);

    void deleteById(long id);
    void deleteByUser(User user);

}
