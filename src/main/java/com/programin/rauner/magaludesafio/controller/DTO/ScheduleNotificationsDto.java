package com.programin.rauner.magaludesafio.controller.DTO;

import com.programin.rauner.magaludesafio.model.entity.Channel;
import com.programin.rauner.magaludesafio.model.entity.Notifications;
import com.programin.rauner.magaludesafio.model.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationsDto(
        LocalDateTime dataTime,
        String destination,
        String message,
        Channel.Values channel) {

    public Notifications toNotifications() {
        new Notifications();
        return Notifications.builder()
                .dateTime(dataTime)
                .destination(destination)
                .message(message)
                .channel(channel.toChannel())
                .status(Status.Values.PENDING.toStatus())
                .build();
    }
}
