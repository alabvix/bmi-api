package com.bmiapi.framework.spring.bmi.repository;

import com.bmiapi.core.bmi.BmiRateEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "bmi")
public class BmiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    private UUID userId;

    private LocalDate date;

    private BigDecimal value;

    private BmiRateEnum rate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BmiRateEnum getRate() {
        return rate;
    }

    public void setRate(BmiRateEnum rate) {
        this.rate = rate;
    }
}
