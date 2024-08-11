package com.programin.rauner.magaludesafio.controller;


import com.programin.rauner.magaludesafio.controller.DTO.ScheduleNotificationsDto;
import com.programin.rauner.magaludesafio.model.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @PostMapping()
    public ResponseEntity<?> scheduleNotifications(@RequestBody ScheduleNotificationsDto dto) {
        notificationsService.scheduleNotifications(dto);
        return ResponseEntity.accepted().build();
    }

}
