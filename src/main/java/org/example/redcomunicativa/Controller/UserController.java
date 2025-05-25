package org.example.redcomunicativa.Controller;

import org.example.redcomunicativa.DTOs.UserDto;
import org.example.redcomunicativa.Entity.User;
import org.example.redcomunicativa.Servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
