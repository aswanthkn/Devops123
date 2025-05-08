package com.backend.devops.controller;


import com.backend.devops.dto.UserDto;
import com.backend.devops.model.User;
import com.backend.devops.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        boolean success = authService.register(new User(userDto.getUsername(), userDto.getPassword()));
        return success ? ResponseEntity.ok("User registered") : ResponseEntity.badRequest().body("User already exists");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        boolean success = authService.login(userDto.getUsername(), userDto.getPassword());
        return success ? ResponseEntity.ok("Login successful") : ResponseEntity.status(401).body("Invalid credentials");
    }
}
