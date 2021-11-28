package com.bmiapi.core.bmi.domain;

import com.bmiapi.core.bmi.BmiRateEnum;
import com.bmiapi.core.user.User;

import java.math.BigDecimal;

public record BmiOutput(User user, BmiRateEnum rate,
                        BigDecimal value) {

}
