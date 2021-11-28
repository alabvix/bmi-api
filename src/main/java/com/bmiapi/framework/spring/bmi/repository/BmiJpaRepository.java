package com.bmiapi.framework.spring.bmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BmiJpaRepository extends JpaRepository<BmiEntity, UUID> {
}
