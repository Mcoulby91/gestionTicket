package com.manaCoulby.gestionTicket.service;

import com.manaCoulby.gestionTicket.Entity.User;
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

    public User createUser(User user) {
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
