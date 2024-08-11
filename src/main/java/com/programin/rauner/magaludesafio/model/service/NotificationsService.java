package com.programin.rauner.magaludesafio.model.service;

import com.programin.rauner.magaludesafio.controller.DTO.ScheduleNotificationsDto;
import com.programin.rauner.magaludesafio.model.entity.Notifications;
import com.programin.rauner.magaludesafio.model.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationsService {

    private final NotificationsRepository notificationsRepository;

    @Autowired
    public NotificationsService(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }

    public Long scheduleNotifications(ScheduleNotificationsDto dto) {
        return notificationsRepository.save(dto.toNotifications()).getId();
    }

    public Optional<Notifications> getNotification(Long id) {
        return notificationsRepository.findById(id);
    }
}
