package com.bmiapi.framework.spring.bmi;

import com.bmiapi.core.bmi.domain.Bmi;
import com.bmiapi.framework.spring.bmi.repository.BmiEntity;
import org.springframework.stereotype.Component;

@Component
public class BmiConverter {

    public BmiEntity toEntity(Bmi bmi) {
        BmiEntity bmiEntity = new BmiEntity();
        bmiEntity.setId(bmi.id());
        bmiEntity.setUserId(bmi.userId());
        bmiEntity.setDate(bmi.date());
        bmiEntity.setValue(bmi.value());
        bmiEntity.setRate(bmi.rate());

        return bmiEntity;
    }

}
