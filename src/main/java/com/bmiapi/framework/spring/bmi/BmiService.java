package com.bmiapi.framework.spring.bmi;

import com.bmiapi.core.bmi.BmiInteractor;
import com.bmiapi.core.bmi.domain.BmiInput;
import com.bmiapi.framework.spring.bmi.web.BmiWebInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BmiService {

    private final BmiInteractor bmiInteractor;

    @Autowired
    public BmiService(BmiInteractor bmiInteractor) {
        this.bmiInteractor = bmiInteractor;
    }

    public void calculateBmi( BmiWebInput bmiWebInput) {
        bmiInteractor.calculateBmi(new BmiInput( UUID.fromString(bmiWebInput.userUUID())));
    }

}
