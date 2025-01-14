package com.green.jwt.config.jwt;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;


class MyFunction implements Function<String, SimpleGrantedAuthority> {
    @Override
    public SimpleGrantedAuthority apply(String str) {
        return new SimpleGrantedAuthority(str);
    }
}

@Setter
@Getter
@EqualsAndHashCode //Equals, HashCode 메소드 오버라이딩 >> 객체 비교와 해시 코드를 자동으로 생성
// 논리적 동등성: 메모리 주소값이 다르더라도 필드 값이 같다면 동등하다고 판단
public class JwtUser implements UserDetails {
    private long signedUserId;
    private List<String> roles; //인가(권한)처리 때 사용, ROLE_이름, ROLE_USER, ROLE_ADMIN

    //리턴타입으로 콜렉션인데 콜렉션에 방 하나하나의 타입은 <>로 지정을 한다.
    //<?>이렇게 하면 Object가 되기 때문에 모든 타입이 허용이 된다.
    //<? extends GrantedAuthority>는 지정 타입이 꼭 GrantedAuthority를 포함, GrantedAuthority를 상속받은 객체만 가능하도록 제한을 거는 것

    //<? super GrantedAuthority>는 지정 타입이 꼭 GrantedAuthority를 포함, GrantedAuthority의 부모 객체만 가능하도록 제한을 거는 것
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>(roles.size());
//        for(String role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role));
//        }
//        return authorities;

        Function fn2 = new MyFunction();

        Function fn = new Function<String, SimpleGrantedAuthority>() { //Function 객체화 x
            @Override
            public SimpleGrantedAuthority apply(String str) {
                return new SimpleGrantedAuthority(str);
            }
        };

        return roles.stream() //List<String>을 Stream<List<String>>으로 변환
                //SimpleGrantedAuthority::new은 메소드 참조라고 호칭

                //interface를 implements할 때 람다식을 사용
                //interface가 추상메소드를 단 하나만 가지고 있을 때 람다식 사용 가능
                //.map(fn)
                //.map(item -> {return new SimpleGrantedAuthority(item); }) //와 같은 내용이다.
                //여러줄의 메소드 작성시 중괄호 사용, 람다식에서 중괄호가 있으면 return을 해주어야 한다.
                .map(fn2)
                //.map(SimpleGrantedAuthority::new) //map은 똑같은 size의 스트림을 만든다. Stream<List<SimpleGrantedAuthority>>으로 변환
                .toList();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
