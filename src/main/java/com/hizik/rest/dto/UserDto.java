package com.hizik.rest.dto;

import com.hizik.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private long id;
    private String name;
    private String nickname;
    private String email;
    private String status;


    public static UserDto toDto(User user){

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getNickname(),
                user.getEmail(),
                user.getStatus()
        );
    }

    public static User toDomainObject(UserDto userDto){

        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getNickname(),
                userDto.getEmail(),
                userDto.getStatus()
        );
    }

}
