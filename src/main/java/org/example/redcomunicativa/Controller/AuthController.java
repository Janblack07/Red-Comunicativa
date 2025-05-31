package org.example.redcomunicativa.Controller;

import org.example.redcomunicativa.DTOs.LoginDto;
import org.example.redcomunicativa.DTOs.UserDto;
import org.example.redcomunicativa.Entity.User;
import org.example.redcomunicativa.Servicio.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto) {
        String token = authService.login(dto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDto dto) {
        return ResponseEntity.ok(authService.register(dto));
    }
    //a
}
