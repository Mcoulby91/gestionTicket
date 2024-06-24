package com.manaCoulby.gestionTicket.service;

import com.manaCoulby.gestionTicket.Entity.Categorie;
import com.manaCoulby.gestionTicket.Entity.Prioriter;
import com.manaCoulby.gestionTicket.Entity.Statut;
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


    public Prioriter modifierPrioriter (int id, Prioriter prioriter) {
        prioriter.setIdPrioriter(id);
        return this.prioriterRepository.save(prioriter);
    }

    public void deleterPrioriter (int id) {

            this.prioriterRepository.deleteById(id);
    }


}
