package com.manaCoulby.gestionTicket.controlleur;


import com.manaCoulby.gestionTicket.Entity.User;
import com.manaCoulby.gestionTicket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userg")
public class UserControlleur {
    @Autowired
    private UserService userService;

    @PostMapping("creer")
    public ResponseEntity<User> ajouterUser(@RequestBody User user) {
        this.userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("modifier/{id}")
    public ResponseEntity<User> modifierUser(@PathVariable int id, @RequestBody User user) {
        this.userService.modifyUser(id,user);
        return ResponseEntity.ok(user);
    }

//    @DeleteMapping("supprimer/{id}")
//    public ResponseEntity<User> supprimerUser(@PathVariable int id) {
//        this.userService.deleteUser(id);
//        return ResponseEntity.ok(null);
//    }

    @DeleteMapping("supprimer/{id}")
    public ResponseEntity<Void> supprimerUser(@PathVariable int id) {
        User user = this.userService.findUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("listeAll")
    public ResponseEntity<List<User>> getAllUsers() {
        this.userService.findAllUsers();
        return ResponseEntity.ok(this.userService.findAllUsers());
    }



    @GetMapping("parId/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = this.userService.findUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }


//    @PostMapping("parId/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable int id) {
//        User user = this.userService.findUserById(id);
//        return ResponseEntity.ok(user);
//    }
}
