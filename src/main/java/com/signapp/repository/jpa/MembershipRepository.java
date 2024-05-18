package com.signapp.repository.jpa;

import com.signapp.entity.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<MembershipEntity, String> {
}
