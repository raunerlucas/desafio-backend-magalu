package com.programin.rauner.magaludesafio.controller;


import com.programin.rauner.magaludesafio.controller.DTO.ScheduleNotificationsDto;
import com.programin.rauner.magaludesafio.model.entity.Notifications;
import com.programin.rauner.magaludesafio.model.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController()
@RequestMapping("/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @PostMapping()
    public ResponseEntity<Void> scheduleNotifications(@RequestBody ScheduleNotificationsDto dto) {
        var id = notificationsService.scheduleNotifications(dto);
        return ResponseEntity.accepted().location(URI.create("/"+id)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notifications> getNotification(@PathVariable Long id) {
        return notificationsService.getNotification(id)
         .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelNotification(@PathVariable Long id) {
        notificationsService.cancelNotification(id);
        return ResponseEntity.noContent().build();
    }

}
