package org.graduatework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserCreateDto {

    private final String nickname;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;

    public UserCreateDto(@JsonProperty("nickname") String nickname,
                         @JsonProperty("name") String name,
                         @JsonProperty("surname") String surname,
                         @JsonProperty("email") String email,
                         @JsonProperty("password") String password) {
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

}
