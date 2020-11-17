package com.codecool.hp_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Builder
public class House {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public House() {
        initTable();
    }

    private void initTable() {
        House gryffindor = House.builder().name("Gryffindor").build();
        House hufflepuff = House.builder().name("Hufflepuff").build();
        House ravenclaw = House.builder().name("Ravenclaw").build();
        House slytherin = House.builder().name("Slytherin").build();
    }
}
