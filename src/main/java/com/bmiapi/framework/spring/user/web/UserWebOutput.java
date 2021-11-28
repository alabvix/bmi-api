package com.bmiapi.framework.spring.user.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public record UserWebOutput(UUID id, String name, String email, BigDecimal height, BigDecimal weight,
                            Integer age) implements Serializable {

}
