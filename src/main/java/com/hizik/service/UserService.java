package com.hizik.service;

import com.hizik.domain.User;

import java.util.List;

public interface UserService {

    User insert(User user);

    List<User> getAll();

    User getById(long id);

    User getByName(String name);

    User getByNickname(String nickname);

    User updateUser(
            long id,
            String name,
            String nickname,
            String email,
            String status
    );

    void deleteById(long id);

}
