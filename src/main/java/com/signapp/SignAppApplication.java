package com.signapp;

import com.signapp.entity.MembershipEntity;
import com.signapp.entity.ParticipantEntity;
import com.signapp.entity.SessionEntity;
import com.signapp.entity.SessionTypeEntity;
import com.signapp.entity.TrainerEntity;
import com.signapp.model.NumberOfSessions;
import com.signapp.repository.jpa.MembershipRepository;
import com.signapp.repository.jpa.ParticipantRepository;
import com.signapp.repository.jpa.SessionRepository;
import com.signapp.repository.jpa.SessionTypeRepository;
import com.signapp.repository.jpa.TrainerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;

@EnableJpaRepositories("com.signapp.repository.jpa")
@AllArgsConstructor
@SpringBootApplication
public class SignAppApplication implements CommandLineRunner {

    TrainerRepository trainerRepository;
    ParticipantRepository participantRepository;
    MembershipRepository membershipRepository;
    SessionTypeRepository sessionTypeRepository;
    SessionRepository sessionRepository;


    public static void main(String[] args) {
        SpringApplication.run(SignAppApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        TrainerEntity trainerEntity = TrainerEntity.builder()
                .id("1")
                .name("Name")
                .surname("Surname")
                .build();
        trainerRepository.save(trainerEntity);

        ParticipantEntity participantEntity = ParticipantEntity.builder()
                .id("1")
                .name("Name")
                .surname("Surname")
                .email("Email")
                .build();
        participantRepository.save(participantEntity);

        MembershipEntity membershipEntity = MembershipEntity.builder()
                .id("1")
                .numberOfSessions(NumberOfSessions.EIGHT)
                .validFrom(LocalDate.of(2022, Month.SEPTEMBER, 1))
                .validUntil(LocalDate.of(2022, Month.OCTOBER, 1))
                .participantEntity(participantEntity)
                .build();
        membershipRepository.save(membershipEntity);

        MembershipEntity membershipEntity1 = MembershipEntity.builder()
                .id("2")
                .numberOfSessions(NumberOfSessions.EIGHT)
                .validFrom(LocalDate.of(2022, Month.SEPTEMBER, 1))
                .validUntil(LocalDate.of(2023, Month.OCTOBER, 1))
                .participantEntity(participantEntity)
                .build();
        membershipRepository.save(membershipEntity1);

        SessionTypeEntity sessionTypeEntity = SessionTypeEntity.builder()
                .id("1")
                .name("Name")
                .build();
        sessionTypeRepository.save(sessionTypeEntity);

        SessionEntity sessionEntity = SessionEntity.builder()
                .id("1")
                .startTime(LocalDateTime.of(2022, Month.SEPTEMBER, 12, 19, 30, 00))
                .endTime(LocalDateTime.of(2022, Month.SEPTEMBER, 12, 21, 30, 00))
                .trainerEntity(trainerEntity)
                .membershipEntities(Set.of(membershipEntity, membershipEntity1))
                .sessionTypeEntity(sessionTypeEntity)
                .build();
        sessionRepository.save(sessionEntity);
    }
}
