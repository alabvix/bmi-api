package com.bmiapi.core.bmi.usecases;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateBmiUseCase {

    public BigDecimal calculate(BigDecimal height, BigDecimal weight) {

        BigDecimal height2 = height.multiply(height);

        return weight.divide(height2, RoundingMode.HALF_UP).setScale(1);
    }
}
