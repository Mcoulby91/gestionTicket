package com.manaCoulby.gestionTicket.service;

import com.manaCoulby.gestionTicket.Entity.Categorie;
import com.manaCoulby.gestionTicket.Entity.Role;
import com.manaCoulby.gestionTicket.Entity.User;
import com.manaCoulby.gestionTicket.Repository.RoleRepository;
import com.manaCoulby.gestionTicket.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RoleService  roleService;

    public User createUser(User user) {

        // Récupérer et vérifier le role
        Role role = this.roleService.findByName(user.getRole().getRoleName());
        if (role == null) {
            throw new IllegalArgumentException("Le role spécifiée n'existe pas.");
        }
        user.setRole(role);

        return userRepository.save(user);
    }

    public User modifyUser(int id, User user) {
        user.setIdUser(id);
        return userRepository.save(user);
    }

//    public User deleteUser(int id) {
//     return this.userRepository.deleteByIdUser(id);
//    }

    public User deleteUser(int id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            this.userRepository.deleteById(id);
            return user;
        } else {
            throw new EntityNotFoundException("Utilisateur non trouvé avec l'id : " + id);
        }
    }


    public User findUserById(int id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

}
