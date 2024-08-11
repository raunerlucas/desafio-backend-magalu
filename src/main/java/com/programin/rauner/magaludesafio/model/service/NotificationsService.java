package com.programin.rauner.magaludesafio.model.service;

import com.programin.rauner.magaludesafio.controller.DTO.ScheduleNotificationsDto;
import com.programin.rauner.magaludesafio.model.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationsService {

    private final NotificationsRepository notificationsRepository;

    @Autowired
    public NotificationsService(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }

    public void scheduleNotifications(ScheduleNotificationsDto dto) {
        notificationsRepository.save(dto.toNotifications());

    }
}
