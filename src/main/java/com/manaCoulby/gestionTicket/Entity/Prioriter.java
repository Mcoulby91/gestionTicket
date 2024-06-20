package com.manaCoulby.gestionTicket.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Prioriter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prioriter;
    private String nom_prioriter;
    @OneToMany
    private List<Ticket> ticket;
}
