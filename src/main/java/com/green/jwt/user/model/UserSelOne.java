package com.green.jwt.user.model;

import com.green.jwt.config.jwt.UserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString //데이터가 잘 담겨있는지 확인하기 위함
public class UserSelOne { //Dto
    private long id;
    private String email;
    private String pw;
    private String name;
    private List<UserRole> roles;
}
