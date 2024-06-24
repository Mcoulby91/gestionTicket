package com.manaCoulby.gestionTicket.Repository;

import com.manaCoulby.gestionTicket.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String name);
}
