package org.example.firstproject_refac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long id;


}
