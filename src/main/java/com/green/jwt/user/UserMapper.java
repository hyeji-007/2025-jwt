package com.green.jwt.user;

import com.green.jwt.user.model.UserSignUpReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpReq req);
    int insUserRole(UserSignUpReq req);
}
