package com.green.jwt.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "jwt-const") //application.yml에 있는 const 아래에 있는 데이터를 가져올 때
@RequiredArgsConstructor //final 붙은 애들만 생성자로 받겠다.
@ToString
public class JwtConst {
    private final String issuer;
    private final String secret;
    private final String headerSchemaName;
    private final String claimKey;
    private final String tokenName;
    private final String tokenType;
    private final long accessTokenExpiry;
    private final long refreshTokenExpiry;
    private final String refreshTokenCookieName;
    private final int refreshTokenCookieExpiry;
}

