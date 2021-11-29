package com.bmiapi.framework.spring.bmi;

import com.bmiapi.core.bmi.domain.Bmi;
import com.bmiapi.core.bmi.domain.BmiOutput;
import com.bmiapi.framework.spring.bmi.repository.BmiEntity;
import com.bmiapi.framework.spring.bmi.web.BmiWebOutput;
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

    public BmiWebOutput toWebOutPut(BmiOutput bmiOutput) {
        BmiWebOutput bmiWebOutput = new BmiWebOutput(bmiOutput.user().name(),
                bmiOutput.value(), bmiOutput.date(), bmiOutput.rate());

        return bmiWebOutput;
    }

}
