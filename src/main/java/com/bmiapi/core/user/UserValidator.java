package com.bmiapi.core.user;

import com.bmiapi.core.user.exception.InvalidUserException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserValidator {

    public void validate(User user) {

        List<String> validationMessages = new ArrayList<>();
        String concatMessages = "";

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        for (ConstraintViolation<User> violation : violations) {
            validationMessages.add(violation.getMessage());
        }

        concatMessages = validationMessages.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        if (!concatMessages.isEmpty()) {
            throw new InvalidUserException(concatMessages);
        }

    }
}
