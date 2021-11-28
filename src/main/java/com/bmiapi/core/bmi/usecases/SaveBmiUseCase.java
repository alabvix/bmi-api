package com.bmiapi.core.bmi.usecases;

import com.bmiapi.core.bmi.domain.Bmi;
import com.bmiapi.core.bmi.BmiRepository;

import java.util.Optional;

public class SaveBmiUseCase {

    private BmiRepository bmiRepository;

    public SaveBmiUseCase(BmiRepository repository) {
        this.bmiRepository = repository;
    }

    public void save(Bmi bmi) {

        // If already exists a BMI for the same date and user, just update it.
        Optional<Bmi> existent = bmiRepository.findByDateAndUserId(bmi.userId(), bmi.date());

        if (existent.isPresent()) {
            Bmi updateBmi = new Bmi(existent.get().id(),
                    existent.get().userId(),
                    existent.get().date(),
                    bmi.value(),
                    bmi.rate());
            bmiRepository.save(updateBmi);
        } else {
            bmiRepository.save(bmi);
        }

    }
}
