package com.green.jwt;

import com.green.jwt.config.security.AuthenticationFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("mentor")
public class MentorController {
    @GetMapping
    public String get() {
        log.info("mentor-signedUserId: {}", AuthenticationFacade.getSignedUserId());
        return "mentor";
    }
}
