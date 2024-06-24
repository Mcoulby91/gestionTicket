package com.manaCoulby.gestionTicket.Repository;


import com.manaCoulby.gestionTicket.Entity.Prioriter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReponseTicketRepository extends JpaRepository<Prioriter, Integer> {
}
