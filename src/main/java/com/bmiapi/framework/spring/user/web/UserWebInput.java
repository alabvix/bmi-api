package com.bmiapi.framework.spring.user.web;

import java.io.Serializable;
import java.math.BigDecimal;

public record UserWebInput(String name, String email, BigDecimal height, BigDecimal weight,
                           Integer age) implements Serializable {
}
