package com.bmiapi.framework.spring.bmi;

import com.bmiapi.core.bmi.CalculateBmiInteractor;
import com.bmiapi.core.bmi.domain.BmiInput;
import com.bmiapi.framework.spring.bmi.web.BmiWebInput;
import com.bmiapi.framework.spring.bmi.web.BmiWebOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BmiService {

    private final CalculateBmiInteractor calculateBmiInteractor;

    private final BmiConverter bmiConverter;

    @Autowired
    public BmiService(CalculateBmiInteractor calculateBmiInteractor, BmiConverter bmiConverter) {
        this.calculateBmiInteractor = calculateBmiInteractor;
        this.bmiConverter = bmiConverter;
    }

    public BmiWebOutput calculateBmi(BmiWebInput bmiWebInput) {
        return bmiConverter.toWebOutPut(
                calculateBmiInteractor.calculateBmi(
                        new BmiInput(UUID.fromString(bmiWebInput.userUUID()))
                ));
    }

}
