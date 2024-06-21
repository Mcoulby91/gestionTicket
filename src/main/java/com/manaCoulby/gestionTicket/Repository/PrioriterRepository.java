package com.manaCoulby.gestionTicket.Repository;


import com.manaCoulby.gestionTicket.Entity.Prioriter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrioriterRepository extends JpaRepository<Prioriter, Integer> {

    Prioriter findByNomPrioriter(String nom);
}
