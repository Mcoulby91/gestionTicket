package com.manaCoulby.gestionTicket.service;

import com.manaCoulby.gestionTicket.Entity.Categorie;
import com.manaCoulby.gestionTicket.Entity.Prioriter;
import com.manaCoulby.gestionTicket.Repository.PrioriterRepository;
import org.springframework.stereotype.Service;

@Service
public class PrioriterService {
        private PrioriterRepository prioriterRepository;
        public PrioriterService(PrioriterRepository prioriterRepository) {
            this.prioriterRepository = prioriterRepository;
        }

    public Prioriter recupererParNom (String nom) {
        return this.prioriterRepository.findByNomPrioriter(nom);
    }

    public Prioriter creerPrioriter(Prioriter prioriter) {
        return this.prioriterRepository.save(prioriter);
    }



}
