package com.bmiapi.framework.spring.config;

import com.bmiapi.core.bmi.BmiInteractor;
import com.bmiapi.core.bmi.usecases.CalculateBmiUseCase;
import com.bmiapi.core.bmi.usecases.RateBmiUseCase;
import com.bmiapi.core.bmi.usecases.SaveBmiUseCase;
import com.bmiapi.core.user.UserValidator;
import com.bmiapi.core.user.usecase.CreateUserUseCase;
import com.bmiapi.core.user.usecase.FindUserUseCase;
import com.bmiapi.framework.spring.bmi.repository.BmiRepositoryImpl;
import com.bmiapi.framework.spring.user.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BmiApiConfig {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Autowired
    private BmiRepositoryImpl bmiRepositoryImpl;

    @Bean
    public CreateUserUseCase createUserUseCase() {
        UserValidator userValidator = new UserValidator();
        return new CreateUserUseCase(userRepositoryImpl, userValidator);
    }

    @Bean
    public FindUserUseCase findUserUseCase() {
        return new FindUserUseCase(userRepositoryImpl);
    }

    @Bean
    CalculateBmiUseCase calculateBmiUseCase() { return new CalculateBmiUseCase(); }

    @Bean
    RateBmiUseCase rateBmiUseCase() { return new RateBmiUseCase(); }

    @Bean
    SaveBmiUseCase saveBmiUseCase() { return new SaveBmiUseCase(bmiRepositoryImpl); }

    @Bean
    BmiInteractor bmiInteractor() {
        return new BmiInteractor(
                calculateBmiUseCase(),
                saveBmiUseCase(),
                findUserUseCase(),
                rateBmiUseCase()
        );
    }

}
