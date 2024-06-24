package com.manaCoulby.gestionTicket.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idUser;
    private String nom;
    private String email;
    private String password;
    @ManyToOne
    private Role role;
}
