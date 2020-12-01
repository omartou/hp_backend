package com.codecool.hp_backend.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.assertj.core.util.Lists;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class HPUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection
    @Builder.Default
    private List<String> roles = Lists.newArrayList("ROLE_USER");
}
