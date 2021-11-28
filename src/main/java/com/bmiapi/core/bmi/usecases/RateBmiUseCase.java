package com.bmiapi.core.bmi.usecases;

import com.bmiapi.core.bmi.BmiRateEnum;

import java.math.BigDecimal;

public class RateBmiUseCase {

    public BmiRateEnum rate(BigDecimal value) {

        BmiRateEnum rate = BmiRateEnum.UNDERWEIGHT;

        if (value.compareTo(new BigDecimal("18.5")) == 0 ||
                value.compareTo(new BigDecimal("24.9")) == -1) {

            rate = BmiRateEnum.NORMAL;

        } else if (value.compareTo(new BigDecimal("25.0")) == 0 ||
                    value.compareTo(new BigDecimal("29.9")) == -1) {

            rate = BmiRateEnum.OVERWEIGHT;

        } else {

            rate = BmiRateEnum.OBESITY;
        }

        return rate;

    }
}
