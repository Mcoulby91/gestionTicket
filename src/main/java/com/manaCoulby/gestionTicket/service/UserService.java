package com.manaCoulby.gestionTicket.service;

import com.manaCoulby.gestionTicket.Entity.Role;
import com.manaCoulby.gestionTicket.Entity.User;
import com.manaCoulby.gestionTicket.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.apache.catalina.realm.UserDatabaseRealm.getRoles;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;



    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User modifyUser(int id, User user) {
        user.setIdUser(id);
        return userRepository.save(user);
    }


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

    public Optional<User> findUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByNom(username);
        if (user.isPresent()) {
            var userObj = user.get();

            // Assurez-vous que les rôles sont initialisés
            Hibernate.initialize(userObj.getRole());

            return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getNom())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }

    private String[] getRoles(User user) {
        if (user.getRole() == null || user.getRole().isEmpty()) {
            return new String[0];
        }
        return user.getRole().split(",");
    }

}
