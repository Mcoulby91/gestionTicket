package com.manaCoulby.gestionTicket.controlleur;


import com.manaCoulby.gestionTicket.Entity.Ticket;
import com.manaCoulby.gestionTicket.Repository.TicketRepository;
import com.manaCoulby.gestionTicket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketControlleur {
    @Autowired
    private TicketService ticketService;

    @GetMapping("listeTicket")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public Optional<Ticket> getTicketById(@PathVariable int id) {
        return ticketService.getTicketById(id);

    }


    @PostMapping("creer")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.ok(createdTicket);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable int id, @RequestBody Ticket ticket) {
        Optional<Ticket> existingTicket = ticketService.findAllById(id);
        if (!existingTicket.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ticket.setId(id);
        Ticket updatedTicket = ticketService.updateTicket(id, ticket);
        return ResponseEntity.ok(updatedTicket);
    }


////    @PutMapping("/{id}")
////     public ResponseEntity<Ticket> updateTicket (@PathVariable int id, @RequestBody Ticket ticket) {
////        Ticket updatedTicket = ticketService.updateTicket(id, ticket);
////        return ResponseEntity.ok(updatedTicket);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable int id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
