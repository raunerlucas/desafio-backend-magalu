package com.programin.rauner.magaludesafio.model.service;

import com.programin.rauner.magaludesafio.controller.DTO.ScheduleNotificationsDto;
import com.programin.rauner.magaludesafio.model.entity.Notifications;
import com.programin.rauner.magaludesafio.model.entity.Status;
import com.programin.rauner.magaludesafio.model.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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

    public void cancelNotification(Long id) {
        Optional<Notifications> notification = getNotification(id);
        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationsRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime){
        List<Notifications> notifications = notificationsRepository.findByStatusInAndDateTimeBefore(List.of(
                        Status.Values.PENDING.toStatus(), Status.Values.ERROR.toStatus()), dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notifications> sendNotification() {
        return n -> {
            // TODO: Realizar o envio.

            // TODO: Atualiza o Status.
            n.setStatus(Status.Values.SUCCESS.toStatus());
            notificationsRepository.save(n);
        };
    }
}
