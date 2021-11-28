package com.bmiapi.framework.spring.bmi.web;

import com.bmiapi.framework.spring.bmi.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/bmi")
public class BmiController {

    private final BmiService bmiService;

    @Autowired
    public BmiController(BmiService service) {
        this.bmiService = service;
    }

    @PostMapping
    public void calculateBmi(@RequestBody  BmiWebInput bmiWebInput) {
        bmiService.calculateBmi(bmiWebInput);
    }
}
