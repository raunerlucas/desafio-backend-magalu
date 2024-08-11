package com.programin.rauner.magaludesafio.model.repository;

import com.programin.rauner.magaludesafio.model.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
}
