package com.zen.authservice;

import com.zen.authservice.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    @Test
    void shouldGenerateAndValidateToken() {
        String token = jwtService.generateToken("alice", "ADMIN");

        assertNotNull(token);
        assertEquals("alice", jwtService.validateToken(token));
    }
}
