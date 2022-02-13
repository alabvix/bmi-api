package com.bmiapi.framework.spring.bmi.repository;

import com.bmiapi.core.bmi.BmiRepository;
import com.bmiapi.core.bmi.domain.Bmi;
import com.bmiapi.framework.spring.bmi.BmiConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public class BmiRepositoryImpl implements BmiRepository {

    private final BmiJpaRepository bmiJpaRepository;

    private final BmiConverter bmiConverter;

    @Autowired
    public BmiRepositoryImpl(BmiJpaRepository bmiJpaRepository, BmiConverter bmiConverter) {
        this.bmiJpaRepository = bmiJpaRepository;
        this.bmiConverter = bmiConverter;
    }

    @Override
    public void save(Bmi bmi) {
        BmiEntity bmiEntity = bmiConverter.toEntity(bmi);
        bmiJpaRepository.save(bmiEntity);
    }

    @Override
    public Optional<Bmi> findByDateAndUserId(UUID userId, LocalDate date) {
        return Optional.empty();
    }
}
