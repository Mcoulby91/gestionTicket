package com.manaCoulby.gestionTicket.service;

import com.manaCoulby.gestionTicket.Repository.ReponseTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseTicketService {
    @Autowired
    private ReponseTicketRepository reponseTicketRepository;


}
