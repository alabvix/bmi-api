package com.bmiapi.framework.spring.user.web;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public record UserWebInput(
        @ApiModelProperty(value = "Nome do usuário")
        String name,

        @ApiModelProperty(value = "Email do usuário")
        String email,

        @ApiModelProperty(value = "Altura do usuário")
        BigDecimal height,

        @ApiModelProperty(value = "Peso do usuário")
        BigDecimal weight,

        @ApiModelProperty(value = "Altura")
        Integer age) implements Serializable {
}
