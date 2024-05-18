package com.signapp.repository.jpa;

import com.signapp.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<TrainerEntity, String> {
}
