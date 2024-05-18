package com.signapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "TRAINERS")
@Builder
public class TrainerEntity {

    @Id
    private String id;
    private String name;
    private String surname;

    @ManyToMany
    @JoinTable(name = "trainers_session_types", joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "session_type_id"))
    private Set<SessionTypeEntity> sessionTypeEntities = new HashSet<>();
}
