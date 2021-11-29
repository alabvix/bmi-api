package com.bmiapi.framework.spring.bmi;

import com.bmiapi.core.bmi.CalculateBmiInteractor;
import com.bmiapi.core.bmi.domain.BmiInput;
import com.bmiapi.framework.spring.bmi.web.BmiWebInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BmiService {

    private final CalculateBmiInteractor calculateBmiInteractor;

    @Autowired
    public BmiService(CalculateBmiInteractor calculateBmiInteractor) {
        this.calculateBmiInteractor = calculateBmiInteractor;
    }

    public void calculateBmi( BmiWebInput bmiWebInput) {
        calculateBmiInteractor.calculateBmi(new BmiInput( UUID.fromString(bmiWebInput.userUUID())));
    }

}
