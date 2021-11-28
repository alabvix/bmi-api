package com.bmiapi.core.bmi;

import com.bmiapi.core.bmi.usecases.CalculateBmiUseCase;
import com.bmiapi.core.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateBmiInputUseCaseUnitTest {

    CalculateBmiUseCase calculateBmiUseCase;

    @BeforeEach
    public void before() {
        calculateBmiUseCase = new CalculateBmiUseCase();
    }

    @Test
    public void calculate_valid_bmi() {

        // Given
        User user = new User(
                UUID.randomUUID(),
                "Test User",
                "user@test.com",
                new BigDecimal(1.75),
                new BigDecimal(67.0),
                30
        );

        // when
        BigDecimal bmi = calculateBmiUseCase.calculate(user.height(), user.weight(), user.age());

        // then
        assertEquals(BigDecimal.valueOf(22.00), bmi);

    }

}
