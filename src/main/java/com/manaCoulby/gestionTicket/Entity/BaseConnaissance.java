package com.manaCoulby.gestionTicket.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class BaseConnaissance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_base_connaissance;
    private String titre;
    private String description;
    private Date date;
    @ManyToOne
    private Formateur formateur;
}
