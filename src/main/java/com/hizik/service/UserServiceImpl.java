package com.hizik.service;

import com.hizik.domain.User;
import com.hizik.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Transactional
    @Override
    public User insert(User user) {

        return userRepository.save(user);
    }

    @Transactional
    @Override
    public List<User> getAll() {

        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User getById(long id) {

        return userRepository.findById(id);
    }
    @Transactional

    @Override
    public User getByName(String name) {

        return userRepository.findByName(name);
    }

    @Transactional
    @Override
    public User getByNickname(String nickname) {

        return userRepository.findByNickname(nickname);
    }

    @Transactional
    @Override
    public User updateUser(long id, String name, String nickname, String email, String status) {

        User user = User.builder()
                .id(id)
                .name(name)
                .nickname(nickname)
                .email(email)
                .status(status)
                .build();

        return userRepository.save(user);
    }

    

    @Transactional
    @Override
    public void deleteById(long id) {

        userRepository.deleteById(id);
    }
}
