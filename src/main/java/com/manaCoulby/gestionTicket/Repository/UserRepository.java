package com.manaCoulby.gestionTicket.Repository;


import com.manaCoulby.gestionTicket.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User deleteByIdUser(int id);

    Optional<User> findByEmail(String email);

    Optional<User>  findByNom(String username);

    Optional<User>  findByPassword(String password);
}
