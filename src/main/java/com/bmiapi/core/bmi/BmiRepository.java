package com.bmiapi.core.bmi;

import com.bmiapi.core.bmi.domain.Bmi;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface BmiRepository {

    void save(Bmi bmi);

    Optional<Bmi> findByDateAndUserId(UUID userId, LocalDate date);
}
