package com.manaCoulby.gestionTicket.Repository;


import com.manaCoulby.gestionTicket.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
