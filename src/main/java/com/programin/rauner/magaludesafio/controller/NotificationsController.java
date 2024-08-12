package com.programin.rauner.magaludesafio.controller;


import com.programin.rauner.magaludesafio.controller.DTO.ScheduleNotificationsDto;
import com.programin.rauner.magaludesafio.model.entity.Notifications;
import com.programin.rauner.magaludesafio.model.service.NotificationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController()
@RequestMapping("/notifications")
@Tag(name = "Notifications", description = "API para agendamento de notificações")
public class NotificationsController {

    private final NotificationsService notificationsService;

    @Autowired
    public NotificationsController(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @PostMapping()
    @Operation(summary = "Agendar notificações",
            description = "Agenda notificações para serem enviadas em um horário específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Notificação criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ScheduleNotificationsDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public ResponseEntity<Void> scheduleNotifications(@RequestBody ScheduleNotificationsDto dto) {
        var id = notificationsService.scheduleNotifications(dto);
        return ResponseEntity.accepted().location(URI.create("/"+id)).build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notificação",
            description = "Busca uma notificação agendada pelo seu id")
    public ResponseEntity<Notifications> getNotification(@PathVariable Long id) {
        return notificationsService.getNotification(id)
         .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancelar notificação",
            description = "Altera o status de uma notificação agendada(Pending - Canceled) pelo seu id")
    public ResponseEntity<Void> cancelNotification(@PathVariable Long id) {
        notificationsService.cancelNotification(id);
        return ResponseEntity.noContent().build();
    }

}
