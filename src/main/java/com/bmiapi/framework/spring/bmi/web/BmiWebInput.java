package com.bmiapi.framework.spring.bmi.web;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public record BmiWebInput(@ApiModelProperty(value = "User Id in UUID format") String userUUID) implements Serializable {

}
