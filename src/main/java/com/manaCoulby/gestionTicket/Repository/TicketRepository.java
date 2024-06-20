package com.manaCoulby.gestionTicket.Repository;


import com.manaCoulby.gestionTicket.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    Optional<Ticket> findAllById(int id);
}
