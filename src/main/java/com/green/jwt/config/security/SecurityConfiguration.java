package com.green.jwt.config.security;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springdoc.webmvc.core.service.RequestService;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration //빈등록, 보통 빈등록 메소드가 포함되어 있을 가능성이 높다.
@RequiredArgsConstructor
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean // 스프링이 메소드 호출을 하고 리턴한 객체의 주소값을 관리한다. (빈등록)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 시큐리티가 세션을 사용하지 않는다.
                .httpBasic(h -> h.disable()) //SSR(Server Side Rendering)이 아니다. 화면을 만들지 않을것이기 때문에 비활성화 시킨다. 시큐리티 로그인창 나타나지 않을 것이다.
                .formLogin(form -> form.disable()) //폼로그인 기능 자체를 비활성화
                .csrf(csrf -> csrf.disable()) //보안관련 SSR이 아니면 보안이슈가 없기 때문에 기능을 끈다.

                .build();
    }
}
