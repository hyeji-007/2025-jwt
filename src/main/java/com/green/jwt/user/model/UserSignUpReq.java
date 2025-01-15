package com.green.jwt.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class UserSignUpReq {
    private final String email;
    private String pw;
    private final String name;
}
