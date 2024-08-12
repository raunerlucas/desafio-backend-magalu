package com.programin.rauner.magaludesafio.scheduler;

import com.programin.rauner.magaludesafio.model.service.NotificationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class MagaluTaskScheduler {

    private final NotificationsService notificationsService;

    @Autowired
    public MagaluTaskScheduler(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @Scheduled(
            fixedDelay = 1,
            timeUnit = TimeUnit.MINUTES
    )
    public void checkTasks(){
        var dateTime = LocalDateTime.now();
        notificationsService.checkAndSend(dateTime);
    }

}
