package com.codecool.hp_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Wand {
    @Id
    @GeneratedValue
    private Long id;

    private String wood;

    private String length;

    @Enumerated(EnumType.STRING)
    private Core core;

    @OneToOne(mappedBy = "wand", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
    @ToString.Exclude
    private Character owner;


    @Override
    public String toString() {
        return wood + ", " + length + ", " + core.getName();
    }
}
