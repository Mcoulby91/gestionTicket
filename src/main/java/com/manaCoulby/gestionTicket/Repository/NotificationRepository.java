package com.manaCoulby.gestionTicket.Repository;


import com.manaCoulby.gestionTicket.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
