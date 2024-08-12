package com.programin.rauner.magaludesafio.model.repository;

import com.programin.rauner.magaludesafio.model.entity.Notifications;
import com.programin.rauner.magaludesafio.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
    List<Notifications> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
