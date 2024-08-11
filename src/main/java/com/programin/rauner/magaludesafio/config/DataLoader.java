package com.programin.rauner.magaludesafio.config;

import com.programin.rauner.magaludesafio.model.entity.Channel;
import com.programin.rauner.magaludesafio.model.entity.Status;
import com.programin.rauner.magaludesafio.model.repository.ChannelRepository;
import com.programin.rauner.magaludesafio.model.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;

    private final StatusRepository statusRepository;

    @Autowired
    public DataLoader(ChannelRepository channelRepository,
                      StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(statusRepository::save);
    }
}
