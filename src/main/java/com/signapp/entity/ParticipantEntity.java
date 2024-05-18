package com.signapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PARTICIPANTS")
@Builder
public class ParticipantEntity {

    @Id
    private String id;
    private String name;
    private String surname;
    private String email;

    @OneToMany(mappedBy = "participantEntity")
    private List<MembershipEntity> membershipEntities = new ArrayList<>();
}
