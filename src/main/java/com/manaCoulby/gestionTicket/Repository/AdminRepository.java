package com.manaCoulby.gestionTicket.Repository;


import com.manaCoulby.gestionTicket.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
