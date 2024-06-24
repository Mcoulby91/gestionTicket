package com.manaCoulby.gestionTicket.controlleur;

import com.manaCoulby.gestionTicket.Entity.Role;
import com.manaCoulby.gestionTicket.Entity.User;
import com.manaCoulby.gestionTicket.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
public class RoleControlleur {

    @Autowired
    private RoleService roleService;

    @PostMapping("creer")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        this.roleService.creerRole(role);
        return ResponseEntity.ok(role);
    }
    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole(@PathVariable int id, @RequestBody Role role) {
        this.roleService.modifierRole(id, role);
        return ResponseEntity.ok(role);
    }


    @DeleteMapping("supprimer/{id}")
    public ResponseEntity<Void> supprimerRole(@PathVariable int id) {
        Role role = this.roleService.findUserById(id);
        if (role == null) {
            return ResponseEntity.notFound().build();
        }
        this.roleService.deleterRole(id);
        return ResponseEntity.noContent().build();
    }

}
