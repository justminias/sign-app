package com.signapp.entity;

import com.signapp.model.NumberOfSessions;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.*;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"sessions", "participantEntity"})
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "MEMBERSHIPS")
@Builder
public class MembershipEntity {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private NumberOfSessions numberOfSessions;
    private LocalDate validFrom;
    private LocalDate validUntil;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private ParticipantEntity participantEntity;

    @ManyToMany
    @JoinTable(name = "memberships_sessions", joinColumns = @JoinColumn(name = "membership_id"),
            inverseJoinColumns = @JoinColumn(name = "session_id"))
    private Set<SessionEntity> sessions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "session_type_id")
    private SessionTypeEntity sessionTypeEntity;
}
