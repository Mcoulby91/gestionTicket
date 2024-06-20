package com.manaCoulby.gestionTicket.Repository;


import com.manaCoulby.gestionTicket.Entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
