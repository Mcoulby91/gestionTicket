package com.manaCoulby.gestionTicket.controlleur;

import com.manaCoulby.gestionTicket.Entity.Prioriter;
import com.manaCoulby.gestionTicket.service.PrioriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "prioriter")
public class PrioriterControlleur {
    @Autowired
    private PrioriterService prioriterService;

    @PostMapping
    public void ajouterPrioriter(@RequestBody Prioriter prioriter) {
        this.prioriterService.creerPrioriter(prioriter);
    }

}
