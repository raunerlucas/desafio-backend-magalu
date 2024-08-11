package com.programin.rauner.magaludesafio.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Status implements Serializable {

    @Id
    private Long id;
    private String description;

    public enum Values {
        EMAIL(1L, "Pending"),
        SMS(2L, "Success"),
        PUSH(3L, "Error"),
        WHATSAPP(4L, "Canceled");

        private final Long id;
        private final String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Status toStatus() {
            return new Status(id, description);
        }
    }
}


