package com.hizik.rest.controller;

import com.hizik.domain.User;
import com.hizik.rest.dto.UserDto;
import com.hizik.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<UserDto> getAllUser(){

        return userService.getAll()
                .stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
    }


    @PostMapping("/user")
    public UserDto insertUser(@RequestBody UserDto userDto){

        User user = userService.insert(UserDto.toDomainObject(userDto));
        return UserDto.toDto(user);
    }

    @PutMapping("/user/{id}")
    public UserDto updateUser(@PathVariable long id,
                              @RequestParam String name,
                              @RequestParam String nickname,
                              @RequestParam String email,
                              @RequestParam String status){

        User user = userService.updateUser(id, name, nickname, email, status);
        return UserDto.toDto(user);
    }

    @PutMapping("/user/status/{id}")
    public UserDto updateStatus(@PathVariable long id,
                                @RequestParam String status){

        User user = userService.updateStatus(id, status);
        return UserDto.toDto(user);
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable long id){

        User user = userService.getById(id);
        return UserDto.toDto(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id){

        userService.deleteById(id);
    }
}
