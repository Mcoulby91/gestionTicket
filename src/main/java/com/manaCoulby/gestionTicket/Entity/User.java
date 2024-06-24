package com.manaCoulby.gestionTicket.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

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
    private String role;


}
