package com.signapp.repository.jpa;

import com.signapp.entity.SessionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionTypeRepository extends JpaRepository<SessionTypeEntity, String> {
}
