package com.bmiapi.framework.spring.bmi.web;

import com.bmiapi.core.bmi.BmiRateEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public record BmiWebOutput(String userName, BigDecimal bmi, LocalDate date,
                           BmiRateEnum rate) implements Serializable {

}
