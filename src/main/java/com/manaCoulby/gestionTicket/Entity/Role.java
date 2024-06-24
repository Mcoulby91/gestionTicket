package com.manaCoulby.gestionTicket.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int idRole;
    String roleName;

}
