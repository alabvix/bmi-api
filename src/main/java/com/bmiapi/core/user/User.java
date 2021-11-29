package com.bmiapi.core.user;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

public record User(UUID uuid,
                   @NotNull(message = "Name cannot be null") @NotEmpty(message = "Name cannot be empty")
                   String name,
                   @NotEmpty(message = "Email cannot be empty") @NotNull(message = "Email cannot be null")
                   @Email(message = "Email must be valid")
                   String email,
                   @DecimalMin(value = "0.40", inclusive = false, message = "Minimum height must be 0.40")
                   @DecimalMax(value = "2.50", inclusive = false, message = "Maximum height must be 2.50")
                   BigDecimal height,
                   @DecimalMin(value = "20.0", inclusive = false, message = "Minimum weight must be 20.0")
                   @DecimalMax(value = "400.0", inclusive = false, message = "Maximum weight must be 400.0")
                   BigDecimal weight,
                   @Min(value=5, message = "Age should not be less than 5")
                   @Max(value=120, message = "Age should not be greater than 120")
                   Integer age) {

}
