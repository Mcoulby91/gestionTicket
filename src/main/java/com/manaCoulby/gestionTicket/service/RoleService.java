package com.manaCoulby.gestionTicket.service;


import com.manaCoulby.gestionTicket.Entity.Role;
import com.manaCoulby.gestionTicket.Entity.Statut;
import com.manaCoulby.gestionTicket.Entity.User;
import com.manaCoulby.gestionTicket.Repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String name){
       return this.roleRepository.findByRoleName (name);
    }
    public Role creerRole (Role role) {

        return this.roleRepository.save(role);
    }

    public Role modifierRole (int id, Role role) {
        role.setIdRole(id);
        return this.roleRepository.save(role);
    }

//    public void deleterRole (int id) {
//        this.roleRepository.deleteById(id);
//    }
public Role deleterRole(int id) {
    Optional<Role> roleOptional = this.roleRepository.findById(id);
    if (roleOptional.isPresent()) {
        Role role = roleOptional.get();
        this.roleRepository.deleteById(id);
        return role;
    } else {
        throw new EntityNotFoundException("Role non trouvé avec l'id : " + id);
    }
}

    public Role findUserById(int id) {
        return this.roleRepository.findById(id).get();
    }
}
