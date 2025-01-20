package com.green.jwt;

import com.green.jwt.config.constant.JwtConst;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintStream;

class System2 {
    static PrintStream out;
}

@SpringBootTest
class JwtApplicationTests {

    @Autowired
    private JwtConst jwtConst;

    @Test
    void system_out_println() {
        PrintStream ps = System.out;
        System2.out.println();
    }

    @Test
    void objJwtConst() {
        System.out.println(jwtConst);
    }

}
