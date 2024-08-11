package com.programin.rauner.magaludesafio.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Channel implements Serializable {

    @Id
    private Long id;

    private String description;

    public enum Values {
        EMAIL(1L, "Email"),
        SMS(2L, "SMS"),
        PUSH(3L, "Push"),
        WHATSAPP(4L, "WhatsApp");

        private final Long id;
        private final String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Channel toChannel() {
            return new Channel(id, description);
        }
    }

}
