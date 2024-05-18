package com.signapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"membershipEntities", "trainerEntity"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SESSIONS")
@Builder
public class SessionEntity {

    @Id
    private String id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private TrainerEntity trainerEntity;

    @ManyToOne
    @JoinColumn(name = "session_type_id")
    private SessionTypeEntity sessionTypeEntity;

    @ManyToMany(mappedBy = "sessions")
    private Set<MembershipEntity> membershipEntities = new HashSet<>();
}
