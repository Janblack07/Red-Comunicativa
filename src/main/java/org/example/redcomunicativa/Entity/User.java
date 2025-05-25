package org.example.redcomunicativa.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String role; // ABOGADO, CLIENTE, ADMIN, ASISTENTE
    private String password; // Encriptada
}