package com.manaCoulby.gestionTicket.service;


import com.manaCoulby.gestionTicket.Entity.Categorie;
import com.manaCoulby.gestionTicket.Entity.Prioriter;
import com.manaCoulby.gestionTicket.Entity.Ticket;
import com.manaCoulby.gestionTicket.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private PrioriterService prioriterService;


    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(int id) {
        return ticketRepository.findAllById(id);
    }

    public Ticket createTicket(Ticket ticket) {
        Categorie category = this.categorieService.recupererParNom(ticket.getCategorie().getNomCategorie());
        ticket.setCategorie(category);
        Prioriter prioriter = this.prioriterService.recupererParNom(ticket.getPrioriter().getNomPrioriter());
        ticket.setPrioriter(prioriter);
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(int id, Ticket ticket) {
       ticket.setId(id);
       return ticketRepository.save(ticket);
    }

    public void deleteTicket(int id) {
        ticketRepository.deleteById(id);
    }

    public Optional<Ticket> findAllById(int id) {
        return ticketRepository.findAllById(id);
    }
}
