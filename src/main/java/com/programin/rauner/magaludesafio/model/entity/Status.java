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
}


