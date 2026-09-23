package com.zen.authservice.controller;

import com.zen.authservice.service.JwtService;
import com.zen.authservice.dto.LoginRequest;
import com.zen.authservice.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
 
    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        String token = jwtService.generateToken(request.username(), request.role());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validate(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "").trim();
        String username = jwtService.validateToken(token);
        return ResponseEntity.ok("Token valid for user: " + username);
    }
}
