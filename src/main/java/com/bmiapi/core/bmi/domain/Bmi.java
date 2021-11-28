package com.bmiapi.core.bmi.domain;

import com.bmiapi.core.bmi.BmiRateEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record Bmi(UUID id, UUID userId, LocalDate date, BigDecimal value, BmiRateEnum rate) {

}
