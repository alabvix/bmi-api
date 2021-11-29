package com.bmiapi.core.bmi;

import com.bmiapi.core.bmi.domain.Bmi;
import com.bmiapi.core.bmi.domain.BmiInput;
import com.bmiapi.core.bmi.domain.BmiOutput;
import com.bmiapi.core.bmi.usecases.CalculateBmiUseCase;
import com.bmiapi.core.bmi.usecases.RateBmiUseCase;
import com.bmiapi.core.bmi.usecases.SaveBmiUseCase;
import com.bmiapi.core.user.User;
import com.bmiapi.core.user.usecase.FindUserUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalculateBmiInteractor {

    final Logger logger = LoggerFactory.getLogger(CalculateBmiInteractor.class);

    private final CalculateBmiUseCase calculateBmiUseCase;

    private final SaveBmiUseCase saveBmiUseCase;

    private final FindUserUseCase findUserUseCase;

    private final RateBmiUseCase rateBmiUseCase;

    public CalculateBmiInteractor(CalculateBmiUseCase calculateBmiUseCase,
                                  SaveBmiUseCase saveBmiUseCase,
                                  FindUserUseCase findUserUseCase,
                                  RateBmiUseCase rateBmiUseCase) {

        this.calculateBmiUseCase = calculateBmiUseCase;
        this.saveBmiUseCase = saveBmiUseCase;
        this.findUserUseCase = findUserUseCase;
        this.rateBmiUseCase = rateBmiUseCase;

    }

    public BmiOutput calculateBmi(BmiInput input) {

        User user = findUserUseCase.findById(input.userId());

        BigDecimal bmiValue = calculateBmiUseCase.calculate(user.height(), user.weight(), user.age());

        BmiRateEnum rate = rateBmiUseCase.rate(bmiValue);

        Bmi bmi = new Bmi(null, input.userId(), LocalDate.now(), bmiValue, rate);

        saveBmiUseCase.save(bmi);

        BmiOutput bmiOutput = new BmiOutput(user, rate, bmiValue);

        logger.info("Bmi calculated for user id {} : {}", input.userId(), bmiValue);

        return bmiOutput;

    }

}
