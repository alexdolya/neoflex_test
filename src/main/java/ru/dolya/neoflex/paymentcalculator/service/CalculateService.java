package ru.dolya.neoflex.paymentcalculator.service;

import ru.dolya.neoflex.paymentcalculator.model.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CalculateService {
    Payment calculate(BigDecimal avgSalary, int vacationDays, LocalDate date);
}
