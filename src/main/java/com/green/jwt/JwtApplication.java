package com.green.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

}
/*
    Security는 필터에서 작동
    필터는 (1) 아무런 작업을 하지 않고 다음 필터에게 넘긴다.
          (2) 무슨 작업을 하고 다음 필터에게 넘긴다.
          (3) 문제가 있으면 다음 필터에게 넘기지 않고 바로 예외처리 응답을 한다.

    - 로그인, AT, RT 생성, AT는 BODY로 리턴(응답), RT는 Cookie에 담아서 리턴(응답)
    - 프론트는 AT를 받은 순간부터 모든 요청의 HEADER에 "Authorization" 키값으로 "Bearer ${AT}"를 보내준다.
    - 요청이 들어올 때마다 AT 체크를 한다. 현 프로젝트 기준 TokenAuthenticationFilter에서 담당.
        (1) HEADER에 Authorization키가 있는지 확인, 있으면 Bearer를 뺀 AT를 뽑아낸다.
           >> Token이 유효하면, Authentication 객체를 생성하고 SecurityContextHolder에 담는다. (Spring Framework Security(SFS) 미들웨어 쓰는데
                                                                          SFS가 인증처리하는 방법)
                                                                          , 즉 모든 요청마다 Authentication객체가
                                                                          SecurityContextHolder에 담겨있어야 인증이 되었다고 처리한다.

          >> Token이 만료되었다면 예외를 발생한다. 403을 응답함.
        (2) HEADER에 Authorization키가 없었다면 아무런 작업을 안 한다.
          >> SFS가 인증/인가 처리되는 URL은 사용할 수 없다. (X) >> 인증/인가가 필요한 URL에서는 Authorization 키가 없으면 접근이 차단된다.
          >> SFS 인증/인가가 필요없는 URL은 사용할 수 있다. (O) >> 인증/인가가 필요 없는 URL에서는 Authorization 키가 없어도 접근할 수 있다.

 */
